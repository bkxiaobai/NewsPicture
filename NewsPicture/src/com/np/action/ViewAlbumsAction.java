package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

import com.np.service.NService;

import java.util.List;
import com.np.tool.PageConst;
import com.np.vo.AlbumVO;
import com.np.vo.ChannelVO;

public class ViewAlbumsAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer channelId = Integer.valueOf(request.getParameter("channelId"));
		List<AlbumVO> avos = ns.getAlbumsByChannel(channelId, PageConst.FIRST, PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(ns.getAlbumCount(channelId), 1);
		ChannelVO cvo = ns.getChannel(channelId);
		request.getSession().setAttribute("channel", cvo);
		request.setAttribute("channel", cvo);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
		return mapping.findForward("get");
	}
}
