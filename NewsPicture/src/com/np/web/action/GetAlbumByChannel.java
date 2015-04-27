package com.np.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.np.exception.NException;
import com.np.po.Album;
import com.np.po.Channel;
import com.np.web.base.BaseServlet;

public class GetAlbumByChannel extends BaseServlet {

	private static final long serialVersionUID = -8380695760546582385L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession(true);
		// ��HttpSession�л�ȡϵͳ��ǰ�û�����Ƭ�б�ĵ�ǰҳ��
		Channel channel = (Channel) session.getAttribute("curChannel");
		Object pageObj = session.getAttribute("curPage");

		// ���HttpSession�е�curPageΪnull�������õ�ǰҳΪ��һҳ
		int curPage = pageObj == null ? 1 : (Integer) pageObj;
		response.setContentType("text/javascript;charset=GBK");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try {
			List<Album> albums = as.getAlbumByChannel(channel, curPage);
			// ���idΪlist��Ԫ��
			out.println("var list = $('#list').empty();");
			for (Album ph : albums) {
				// ��ÿ����Ƭ��̬��ӵ�idΪlist��Ԫ����
				out.println("list.append(\"<div align='center'>"
						+ "<a href='javascript:void(0)' onclick=\\\"showAlbum('"
						+ ph.getTitle() + "');\\\">" );
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "�����ԣ�')");
		}
	}
}

