package com.np.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.np.exception.NException;
import com.np.web.base.BaseServlet;

public class ValidateNameServlet extends BaseServlet {

	private static final long serialVersionUID = 9038839276327742641L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		response.setContentType("text/javascript;charset=GBK");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try {
			if (username != null) {
				if (as.validateName(username)) {
					out.println("alert('恭喜您，该用户名还未使用，你可使用该用户名！');");
				} else {
					out.println("alert('对不起，该用户名已被他人占用！');");
					out.println("$('#user').val('');");
				}
			} else {
				out.println("alert('验证用户名出现异常，请更换用户名重试！');");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "请更换用户名重试！');");
		}
	}
}
