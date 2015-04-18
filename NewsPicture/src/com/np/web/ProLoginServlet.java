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
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try {
			// ���idΪuser��pass����������
			out.println("$('#username,#password').val('');");
			if (username != null && password != null && as.userLogin(username, password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("curUser", username);
				out.println("alert('���Ѿ���¼�ɹ���')");
				out.println("$('#noLogin').hide(500)");
				out.println("$('#hasLogin').show(500)");
				// ���û�ȡ��Ƭ�б�ķ���
				out.println("onLoadHandler();");
			} else {
				out.println("alert('��������û��������벻���������ԣ�')");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "������û������������ԣ�')");
		}
	}
}
