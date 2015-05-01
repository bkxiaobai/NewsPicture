package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;

import com.np.service.NService;
import com.np.vo.UserVO;

public class UpdatePassAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm updatePassForm = (DynaActionForm)form;
		String old = (String)updatePassForm.get("old");
		String newPass = (String)updatePassForm.get("newPass");
		UserVO uvo = (UserVO)request.getSession().getAttribute("userInfo");
		if (old.equals(uvo.getPassword()))
		{
			ns.updateUser(uvo.getId(), newPass);
			request.setAttribute("success", "�޸�����ɹ�,�����µ�¼");
			return mapping.findForward("success");
		}
		request.setAttribute("noSame", "�޸�ʧ��,����ľ���������");
		return mapping.findForward("fail");
	}
}
