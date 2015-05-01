package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.np.tool.DateUtil;
import com.np.service.NService;
import com.np.vo.UserVO;

public class AddAlbumAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}
	/**
	 * ActionMapping������������һ��Action��URL������ʵ�ֵ��ļ������Ӧ��ActionForm
       ��������(request or session)���Ƿ���Ҫ��������У��ͻ�д���Լ�������ɺ����
       ��ת��URL.
       ��ActionForward��Ϳ������ΪAction ������ɺ����תURL,Action�ڴ�������ز�����
       ���ص���һ��ActionForwardҲ���Ǹ���Struts���������������һ�����Ķ�ȥ��
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm addAlbumForm = (DynaActionForm)form;
		String title = (String)addAlbumForm.get("title");
		Integer channelId = Integer.valueOf((String)addAlbumForm.get("channel"));
		String keyword = (String)addAlbumForm.get("keyword");
		UserVO uvo = (UserVO)request.getSession().getAttribute("userInfo");
		Integer uId = new Integer(uvo.getId());
		ns.addAlbum(title, keyword, DateUtil.getFormalTime(), 0, uId, channelId);
		return mapping.findForward("success");
	}
}
