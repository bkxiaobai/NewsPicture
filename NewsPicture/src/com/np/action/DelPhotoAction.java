package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import com.np.service.NService;
import com.np.tool.Upload;
import com.np.vo.PhotoVO;


public class DelPhotoAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer photoId = Integer.valueOf(request.getParameter("photoId"));

		if (ns.checkPhoto(photoId) == false)
		{
			request.setAttribute("noexist", "你要删除的照片不存在");
			return mapping.findForward("noexist");
		}
		PhotoVO pvo = ns.getPhoto(photoId);
		String picUrl = pvo.getPicUrl();
		String bigPicUrl = pvo.getBigPicUrl();
		String smallPicUrl = pvo.getSmallPicUrl();
		Upload up = new Upload();
		up.deleteImage(picUrl, bigPicUrl, smallPicUrl, request.getSession().getServletContext().getRealPath(""));
		ns.deletePhoto(photoId.intValue());
		
		request.setAttribute("success", "删除照片成功");
		return mapping.findForward("success");
	}
}
