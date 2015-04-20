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
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try {
			out.println("$('#username,#password').val('');");
			if (username != null && password != null && as.registUser(username, password) > 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("curUser", username);
				out.println("alert('��ϲ�������Ѿ�ע��ɹ���');");
				out.println("$('#noLogin').hide(500);");
				out.println("$('#hasLogin').show(500);");
				// ���û�ȡ��Ƭ�б�ķ���
				out.println("onLoadHandler();");
			} else {
				out.println("alert('��ע�����ʧ�ܣ���ѡ����ʵ��û������ԣ�');");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "������û������ԣ�');");
		}
	}
}
