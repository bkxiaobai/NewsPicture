package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.np.service.NService;
import com.np.vo.UserVO;

public class UserLoginAction extends Action {
	private NService ns;

	public void setNs(NService ns) {
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm userLoginForm = (DynaActionForm) form;
		String username = (String) userLoginForm.get("username");
		String password = (String) userLoginForm.get("password");
		HttpSession session = request.getSession();
		int uId = 0;
		if ((uId = ns.checkUser(username, password)) <= 0) {
			request.setAttribute("username", username);
			request.setAttribute("wrong", "用户名或者密码错误");
			return mapping.findForward("wrong");
		} else {
			UserVO uvo = ns.getUserInfo(uId);
			request.getSession().setAttribute("userInfo", uvo);
			String url = (String) session.getAttribute("userUrl");
			if (url == null) {
				return mapping.findForward("success");
			} else {
				ActionForward af = new ActionForward(url);
				return af;
			}
		}
	}
}
