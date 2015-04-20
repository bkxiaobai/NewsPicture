package com.np.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.exception.NException;
import com.np.vo.PhotoHolder;
import com.np.web.base.BaseServlet;

public class TurnPageServlet extends BaseServlet {

	private static final long serialVersionUID = -5097286750384714951L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String turn = request.getParameter("turn");
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("curUser");
		Object pageObj = session.getAttribute("curPage");
		// 如果HttpSession中的curPage为null，则设置当前页为第一页
		int curPage = pageObj == null ? 1 : (Integer) pageObj;
		response.setContentType("text/javascript;charset=GBK");
		PrintWriter out = response.getWriter();
		if (curPage == 1 && turn.equals("-1")) {
			out.println("alert('现在已经是第一页，无法向前翻页！')");
		} else {
			// 执行翻页，修改curPage的值。
			curPage += Integer.parseInt(turn);
			try {
				List<PhotoHolder> photos = as.getPhotoByUser(name, curPage);
				// 翻页后没有记录
				if (photos.size() == 0) {
					out.println("alert('翻页后找不到任何相片记录，系统将自动返回上一页')");
					// 重新返回上一页
					curPage -= Integer.parseInt(turn);
				} else {
					// 把用户正在浏览的页码放入HttpSession中
					session.setAttribute("curPage", curPage);
				}
			} catch (NException ex) {
				out.println("alert('" + ex.getMessage() + "请重试！')");
			}
		}
	}
}
