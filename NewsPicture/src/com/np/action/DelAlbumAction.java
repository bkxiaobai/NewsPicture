package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import com.np.exception.NException;
import com.np.service.NService;

public class DelAlbumAction extends Action
{

	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer albumId = Integer.valueOf(request.getParameter("albumId"));
		if (ns.checkAlbum(albumId) == false)
		{
			request.setAttribute("noexist", "你要删除的相册不存在");
			return mapping.findForward("noexist");
		}
		if(ns.checkHavePhotos(albumId))throw new NException("请先把相册内相片全部删除!");
		ns.deleteAlbum(albumId.intValue());
		request.setAttribute("success", "删除相册成功");
		return mapping.findForward("success");
	}
}
