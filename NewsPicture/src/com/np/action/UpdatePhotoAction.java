package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;

import com.np.service.NService;
import com.np.vo.PhotoVO;

public class UpdatePhotoAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm updatePhotoForm = (DynaActionForm) form;
		Integer photoId = Integer.valueOf((String) updatePhotoForm
				.get("photoId"));
		String title = (String) updatePhotoForm.get("title");
		Integer albumId = Integer
				.valueOf((String) updatePhotoForm.get("album"));
		String keyword = (String) updatePhotoForm.get("keyword");
		if (ns.checkPhoto(photoId) == false) {
			request.setAttribute("noexist", "你所要修改的相片不存在");
			return mapping.findForward("noexist");
		}
		ns.updatePhoto(title, keyword, albumId, photoId);
		PhotoVO pvo = ns.getPhoto(photoId);
		request.setAttribute("photo", pvo);
		request.setAttribute("success", "修改相册信息成功");
		return mapping.findForward("success");
	}
}
