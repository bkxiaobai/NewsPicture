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
		// 获取输出流
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("curUser");
		// 如果name不为null，表明用户已经登录
		if (name != null) {
			// 隐藏id为noLogin的元素(用户登录面板)
			out.println("$('#noLogin').hide()");
			// 隐藏id为hasLogin的元素(用户控制面板)
			out.println("$('#hasLogin').show()");
			// 调用获取图集列表的方法
			out.println("onLoadPhoto();");
			// 取出HttpSession中的curImg属性
			String curImg = (String) session.getAttribute("curImg");
			// 重新显示用户正在浏览的图集
			if (curImg != null) {
				out.println("$('#show').attr('src' , 'uploadfiles/" + curImg
						+ "');");
			}
		}
	}
}
