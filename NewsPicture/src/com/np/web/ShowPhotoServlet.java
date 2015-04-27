package com.np.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.web.base.BaseServlet;

public class ShowPhotoServlet extends BaseServlet {

	private static final long serialVersionUID = 1460203270448078666L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String img = request.getParameter("img");
		HttpSession session = request.getSession(true);
		// 将用户正在浏览的图片放入HttpSession中。
		session.setAttribute("curImg", img);
		response.setContentType("text/javascript;charset=GBK");
		// 获取输出流
		PrintWriter out = response.getWriter();
		out.println("$('#show').attr('src' , 'uploadfiles/" + img + "');");
	}
}
