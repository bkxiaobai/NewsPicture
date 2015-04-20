package com.np.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.exception.NException;
import com.np.web.base.BaseServlet;

public class ProRegistServlet extends BaseServlet {

	private static final long serialVersionUID = -3174994243043815566L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/javascript;charset=GBK");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try {
			out.println("$('#username,#password').val('');");
			if (username != null && password != null && as.registUser(username, password) > 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("curUser", username);
				out.println("alert('恭喜您，您已经注册成功！');");
				out.println("$('#noLogin').hide(500);");
				out.println("$('#hasLogin').show(500);");
				// 调用获取相片列表的方法
				out.println("onLoadHandler();");
			} else {
				out.println("alert('您注册出现失败，请选择合适的用户名重试！');");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "请更换用户名重试！');");
		}
	}
}
