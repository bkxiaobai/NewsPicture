package com.np.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.np.service.NService;
import com.np.tool.PageConst;
import com.np.vo.AlbumVO;
import com.np.vo.ChannelVO;

public class OtherAlbumsAction extends Action 
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
		ChannelVO cvo = (ChannelVO)request.getSession().getAttribute("channel");
		Integer channelId = Integer.valueOf(cvo.getId());
		int currentPage = Integer.parseInt((String)pageForm.get("currentPage"));
		int rsCount = ns.getAlbumCount(channelId);
		PageConst pc = new PageConst(rsCount, currentPage);
		List<AlbumVO> avos = ns.getAlbumsByChannel(channelId, pc.getPageFirst(), PageConst.PAGE_SIZE);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
		return mapping.findForward("get");
	}
}
