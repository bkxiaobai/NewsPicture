package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import com.np.vo.AlbumVO;
import com.np.vo.UserVO;
import com.np.service.NService;
import com.np.tool.PageConst;

public class AlbumListAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserVO uvo = (UserVO) request.getSession().getAttribute("userInfo");
		int uId = uvo.getId();
		List<AlbumVO> avos = ns.getUserAlbums(uId, PageConst.FIRST,
				PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(ns.getAlbumCount(uId), 1);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
		return mapping.findForward("success");
	}
}
