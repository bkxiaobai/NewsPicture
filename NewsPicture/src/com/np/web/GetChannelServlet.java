package com.np.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.np.exception.NException;
import com.np.po.Channel;
import com.np.web.base.BaseServlet;

@SuppressWarnings("serial")
public class GetChannelServlet extends BaseServlet {


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/javascript;charset=GBK");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try {
			List<Channel> channels = as.getChannel();
			// ���idΪlist��Ԫ��
			out.println("var list = $('#list').empty();");
			for (Channel ch : channels) {
				// ��ÿ��ͼ����̬��ӵ�idΪlist��Ԫ����
				out.println("list.append(\"<div align='center'>"
						+ "<a href='javascript:void(0)' onclick=\\\"showAlbum('"
						+ ch.getTitle() + "');\\\">"
					);
			}
		} catch (NException ex) {
			out.println("alert('" + ex.getMessage() + "�����ԣ�')");
		}
	}
}

