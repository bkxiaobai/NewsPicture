package com.np.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.np.exception.NException;
import com.np.web.base.BaseServlet;

public class CreateChannel extends BaseServlet {

	private static final long serialVersionUID = -3174994243043815566L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String title = request.getParameter("title");
		
		response.setContentType("text/javascript;charset=GBK");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try {
			out.println("$('#title').val('');");
			if (title != null  && as.addChannel(title) > 0) {
				out.println("alert('�ɹ������Ŀ');");
				//out.println("$('#noLogin').hide(500);");
				//out.println("$('#hasLogin').show(500);");
				// ���û�ȡ��Ƭ�б�ķ���
				out.println("onLoadChannel();");
			} else {
				out.println("alert('��Ŀ���ʧ�ܣ���ѡ����ʵ���Ŀ�����ԣ�');");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "�������Ŀ�����ԣ�');");
		}
	}
}
