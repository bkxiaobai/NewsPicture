package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.np.service.AService;
import com.np.vo.AdminVO;

public class AdminLoginAction extends Action {
	private AService as;

	public void setAs(AService as) {
		this.as = as;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm adminLoginForm = (DynaActionForm) form;
		String name = (String) adminLoginForm.get("userName");
		String pass = (String) adminLoginForm.get("pass");
		AdminVO avo = as.checkAdmin(name, pass);
		if (avo == null) {
			request.setAttribute("wrong", "用户名或密码错误");
			return mapping.findForward("wrong");
		} else {
			request.getSession().setAttribute("adminInfo", avo);
			return mapping.findForward("success");
		}
	}
}
