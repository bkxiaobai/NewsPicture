package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

import com.np.service.NService;

import java.util.List;
import com.np.vo.AlbumVO;
import com.np.vo.PhotoVO;

public class ViewPhotoInfoAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer photoId = Integer.valueOf(request.getParameter("photoId"));
		PhotoVO pvo = ns.getPhoto(photoId);
		if (pvo == null) {
			request.setAttribute("noexist", "你所要查看的相册不存在");
			return mapping.findForward("noexist");
		}
		try {
			// HttpSession session = request.getSession();
			List<AlbumVO> albums = ns.getMyAlbum(userId);
			request.getSession().setAttribute("albums", albums);
			request.setAttribute("photo", pvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("success");
	}
}
