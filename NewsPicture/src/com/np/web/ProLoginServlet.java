package com.np.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.exception.NException;
import com.np.web.base.BaseServlet;

public class ProLoginServlet extends BaseServlet {

	private static final long serialVersionUID = -1253530202224049958L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		response.setContentType("text/javascript;charset=GBK");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try {
			// 清空id为user、pass输入框的内容
			out.println("$('#username,#password').val('');");
			if (username != null && password != null && as.userLogin(username, password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("curUser", username);
				out.println("alert('您已经登录成功！')");
				out.println("$('#noLogin').hide(500)");
				out.println("$('#hasLogin').show(500)");
				// 调用获取相片列表的方法
				out.println("onLoadHandler();");
			} else {
				out.println("alert('您输入的用户名、密码不符，请重试！')");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "请更换用户名、密码重试！')");
		}
	}
}
