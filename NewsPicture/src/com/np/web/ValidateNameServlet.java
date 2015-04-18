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
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try {
			if (username != null) {
				if (as.validateName(username)) {
					out.println("alert('��ϲ�������û�����δʹ�ã����ʹ�ø��û�����');");
				} else {
					out.println("alert('�Բ��𣬸��û����ѱ�����ռ�ã�');");
					out.println("$('#user').val('');");
				}
			} else {
				out.println("alert('��֤�û��������쳣��������û������ԣ�');");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "������û������ԣ�');");
		}
	}
}
