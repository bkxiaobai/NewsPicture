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
		// ���HttpSession�е�curPageΪnull�������õ�ǰҳΪ��һҳ
		int curPage = pageObj == null ? 1 : (Integer) pageObj;
		response.setContentType("text/javascript;charset=GBK");
		PrintWriter out = response.getWriter();
		if (curPage == 1 && turn.equals("-1")) {
			out.println("alert('�����Ѿ��ǵ�һҳ���޷���ǰ��ҳ��')");
		} else {
			// ִ�з�ҳ���޸�curPage��ֵ��
			curPage += Integer.parseInt(turn);
			try {
				List<PhotoHolder> photos = as.getPhotoByUser(name, curPage);
				// ��ҳ��û�м�¼
				if (photos.size() == 0) {
					out.println("alert('��ҳ���Ҳ����κ���Ƭ��¼��ϵͳ���Զ�������һҳ')");
					// ���·�����һҳ
					curPage -= Integer.parseInt(turn);
				} else {
					// ���û����������ҳ�����HttpSession��
					session.setAttribute("curPage", curPage);
				}
			} catch (NException ex) {
				out.println("alert('" + ex.getMessage() + "�����ԣ�')");
			}
		}
	}
}
