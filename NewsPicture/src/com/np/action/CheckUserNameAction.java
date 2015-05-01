package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.np.service.NService;

public class CheckUserNameAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm checkNameForm = (DynaActionForm) form;
		String username = (String) checkNameForm.get("userName");
		request.setAttribute("username", username);
		if (ns.checkUserName(username) == false) {
			request.setAttribute("success", "���û�������");
			return mapping.findForward("success");
		}
		request.setAttribute("have", "���û��Ѿ���ע��,����������");
		return mapping.findForward("have");
	}
}
