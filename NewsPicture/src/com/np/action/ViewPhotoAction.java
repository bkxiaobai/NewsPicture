package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import com.np.service.NService;
import com.np.vo.ChannelVO;
import com.np.vo.PhotoVO;

public class ViewPhotoAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer photoId = Integer.valueOf(request.getParameter("photoId"));
		if (ns.checkPhoto(photoId) == false) {
			request.setAttribute("noexist", "你要查看照片不存在");
			return mapping.findForward("noexist");
		}
		// 修改点击数
		ns.updatePhotoTimes(photoId);
		PhotoVO pvo = ns.getPhoto(photoId);
		ChannelVO cvo = ns.getChannelByPhoto(photoId);
		request.setAttribute("photo", pvo);
		request.setAttribute("channel", cvo);
		return mapping.findForward("success");
	}
}
