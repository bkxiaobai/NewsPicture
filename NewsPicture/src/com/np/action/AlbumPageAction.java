package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import com.np.tool.PageConst;
import com.np.service.NService;
import com.np.vo.AlbumVO;
import com.np.vo.UserVO;


public class AlbumPageAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		UserVO uvo = (UserVO)request.getSession().getAttribute("userInfo");
		int uId = uvo.getId();
		DynaActionForm pageForm = (DynaActionForm)form;
		int currentPage = getCurrentPage(pageForm);
		PageConst pc = new PageConst(ns.getAlbumCount(uId), currentPage);
		List<AlbumVO> avos = ns.getUserAlbums(uId , pc.getPageFirst(), PageConst.PAGE_SIZE);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
		return mapping.findForward("success");
	}

	private int getCurrentPage(DynaActionForm pageForm)
	{
		int currentPage = 1;
		try
		{
			currentPage = Integer.parseInt((String)pageForm.get("currentPage"));
		}
		catch (Exception e)
		{
			currentPage = 1;
		}
		return currentPage;
	}
}
