package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.np.service.NService;
import com.np.vo.AlbumVO;

public class UpdateAlbumAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm updateAlbumForm = (DynaActionForm)form;
		Integer albumId = Integer.valueOf((String)updateAlbumForm.get("albumId"));
		String title = (String)updateAlbumForm.get("title");
		Integer channelId = Integer.valueOf((String)updateAlbumForm.get("channel"));
		String keyword = (String)updateAlbumForm.get("keyword");
		if (ns.checkAlbum(albumId) == false)
		{
			request.setAttribute("noexist", "你所要修改的相册不存在");
			return mapping.findForward("noexist");
		}
		ns.updateAlbum(title, keyword, channelId, albumId);
		AlbumVO avo = ns.getUserAlbum(albumId);
		request.setAttribute("album", avo);
		request.setAttribute("success", "修改相册信息成功");
		return mapping.findForward("success");
	}
}
