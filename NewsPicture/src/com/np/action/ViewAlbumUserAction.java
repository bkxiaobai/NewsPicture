package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import com.np.service.NService;
import com.np.tool.PageConst;
import com.np.vo.AlbumVO;
import com.np.vo.PhotoVO;

public class ViewAlbumUserAction extends Action
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
		List<PhotoVO> pvos = ns.getPhotos(albumId, PageConst.FIRST, PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(ns.getCount(albumId), 1);
		AlbumVO avo = ns.getAlbum(albumId);
		request.setAttribute("album", avo);
		request.setAttribute("photos", pvos);
		request.setAttribute("page", pc);
		return mapping.findForward("get");
	}
}
