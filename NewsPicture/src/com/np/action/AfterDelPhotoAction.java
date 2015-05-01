package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import com.np.service.NService;
import com.np.vo.PhotoVO;
import com.np.vo.AlbumVO;
import com.np.tool.PageConst;

public class AfterDelPhotoAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		AlbumVO avo = (AlbumVO) session.getAttribute("albumInfo");
		List<PhotoVO> pvos = ns.getPhotos(new Integer(avo.getId()),
				PageConst.FIRST, PageConst.PAGE_SIZE);
		request.setAttribute("photos", pvos);
		PageConst pc = new PageConst(ns.getCount(new Integer(avo.getId())), 1);
		request.setAttribute("page", pc);
		return mapping.findForward("success");
	}
}
