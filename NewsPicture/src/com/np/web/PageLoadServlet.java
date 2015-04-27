package com.np.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.web.base.BaseServlet;

public class PageLoadServlet extends BaseServlet {

	private static final long serialVersionUID = 7512001492425261841L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/javascript;charset=GBK");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("curUser");
		// ���name��Ϊnull�������û��Ѿ���¼
		if (name != null) {
			// ����idΪnoLogin��Ԫ��(�û���¼���)
			out.println("$('#noLogin').hide()");
			// ����idΪhasLogin��Ԫ��(�û��������)
			out.println("$('#hasLogin').show()");
			// ���û�ȡͼ���б�ķ���
			out.println("onLoadPhoto();");
			// ȡ��HttpSession�е�curImg����
			String curImg = (String) session.getAttribute("curImg");
			// ������ʾ�û����������ͼ��
			if (curImg != null) {
				out.println("$('#show').attr('src' , 'uploadfiles/" + curImg
						+ "');");
			}
		}
	}
}
