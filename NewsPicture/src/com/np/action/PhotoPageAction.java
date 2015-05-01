package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import com.np.vo.PhotoVO;
import com.np.service.NService;
import com.np.tool.PageConst;
import com.np.vo.AlbumVO;
public class PhotoPageAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm pageForm = (DynaActionForm)form;
		HttpSession session = request.getSession();
		AlbumVO avo = (AlbumVO)session.getAttribute("albumInfo");
		Integer albumId = new Integer(avo.getId());
		int currentPage = getCurrentPage(pageForm);
		PageConst pc = new PageConst(ns.getCount(albumId), currentPage);
		List<PhotoVO> pvos = ns.getPhotos(albumId, pc.getPageFirst(), PageConst.PAGE_SIZE);
		request.setAttribute("page", pc);
		request.setAttribute("photos", pvos);
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
