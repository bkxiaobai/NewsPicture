package com.np.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.exception.NException;
import com.np.po.User;
import com.np.po.Photo;
import com.np.web.base.BaseServlet;

public class GetPhotoByUser extends BaseServlet {

	private static final long serialVersionUID = -8380695760546582385L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession(true);
		// 从HttpSession中获取系统当前用户、相片列表的当前页码
		User user = (User) session.getAttribute("curUser");
		Object pageObj = session.getAttribute("curPage");

		// 如果HttpSession中的curPage为null，则设置当前页为第一页
		int curPage = pageObj == null ? 1 : (Integer) pageObj;
		response.setContentType("text/javascript;charset=GBK");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try {
			List<Photo> photos = as.getPhotoByUser(user, curPage);
			// 清空id为list的元素
			out.println("var list = $('#list').empty();");
			for (Photo ph : photos) {
				// 将每个相片动态添加到id为list的元素中
				out.println("list.append(\"<div align='center'>"
						+ "<a href='javascript:void(0)' onclick=\\\"showImg('"
						+ ph.getTitle() + "');\\\">" + ph.getFileName()
						+ "</a></div>\");" + ph.getKeyword() + "</a></div>\");");
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "请重试！')");
		}
	}
}
