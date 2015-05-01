package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

import com.np.service.NService;
import java.util.List;
import com.np.vo.PhotoVO;
import com.np.tool.PageConst;
import com.np.vo.AlbumVO;

public class ViewPhotosAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer albumId = Integer.valueOf(request.getParameter("albumId"));

		// 修改点击数
		if (ns.checkAlbum(albumId) == false) {
			request.setAttribute("noexist", "你所要修改的相册不存在");
			return mapping.findForward("noexist");
		}
		ns.updateTimes(albumId);
		AlbumVO avo = ns.getUserAlbum(albumId);
		List<PhotoVO> pvos = ns.getPhotos(new Integer(avo.getId()),
				PageConst.FIRST, PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(ns.getCount(new Integer(avo.getId())), 1);
		request.getSession().setAttribute("albumInfo", avo);
		request.setAttribute("page", pc);
		request.setAttribute("photos", pvos);
		return mapping.findForward("success");
	}
}
