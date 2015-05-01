package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

import com.np.service.NService;
import com.np.vo.AlbumVO;

public class ViewAlbumInfoAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer albumId = Integer.valueOf(request.getParameter("albumId"));
		AlbumVO avo = ns.getUserAlbum(albumId);
		if (avo == null) {
			request.setAttribute("noexist", "你所要查看的相册不存在");
			return mapping.findForward("noexist");
		}
		request.setAttribute("album", avo);
		return mapping.findForward("success");
	}
}
