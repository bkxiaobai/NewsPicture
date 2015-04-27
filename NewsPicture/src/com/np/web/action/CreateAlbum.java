package com.np.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.exception.NException;
//import com.np.po.Channel;
//import com.np.po.User;
import com.np.web.base.BaseServlet;

public class CreateAlbum extends BaseServlet {

	private static final long serialVersionUID = -3174994243043815566L;
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		//此处的channelID应该如何从页面传过来？？？
		int channel_id;
		response.setContentType("text/javascript;charset=GBK");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try {
			out.println("$('#title').val('');");
			HttpSession session = request.getSession(true);
			username = (String) session.getAttribute("curUser");
			channel_id = (Integer) session.getAttribute("curChannel");
			if (title != null  && as.addAlbum(username,channel_id,title) > 0) {
				out.println("alert('相册创建成功');");
				//out.println("$('#noLogin').hide(500);");
				//out.println("$('#hasLogin').show(500);");
				// 调用获取相片列表的方法
				//out.println("onLoadHandler();");
			} 
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "请重试！');");
		}
	}
}