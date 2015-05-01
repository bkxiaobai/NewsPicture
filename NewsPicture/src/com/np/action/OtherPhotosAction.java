package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import com.np.service.NService;
import com.np.tool.PageConst;
import com.np.vo.AlbumVO;
import com.np.vo.PhotoVO;

public class OtherPhotosAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm pageForm = (DynaActionForm)form;
		int currentPage = Integer.parseInt((String)pageForm.get("currentPage"));
		Integer albumId = Integer.valueOf((String)pageForm.get("albumId"));
		PageConst pc = new PageConst(ns.getCount(albumId), currentPage);
		List<PhotoVO> pvos = ns.getPhotos(albumId, pc.getPageFirst(), PageConst.PAGE_SIZE);
		AlbumVO avo = ns.getAlbum(albumId);
		request.setAttribute("album", avo);
		request.setAttribute("photos", pvos);
		request.setAttribute("page", pc);
		return mapping.findForward("success");
	}
}
