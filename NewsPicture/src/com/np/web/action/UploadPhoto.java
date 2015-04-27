package com.np.web.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.np.exception.NException;
import com.np.web.base.BaseServlet;

public class UploadPhoto extends BaseServlet {

	private static final long serialVersionUID = 642229801989188793L;
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		@SuppressWarnings("rawtypes")
		Iterator iter = null;
		String title = null;
		String keyword = request.getParameter("keyword");
		response.setContentType("text/html;charset=GBK");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript>'");
		try {
			// ʹ��Uploader�����ϴ�
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			iter = items.iterator();
			// ����ÿ�����ؼ���Ӧ������
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// �����������ͨ����
				if (item.isFormField()) {
					String name = item.getFieldName();
					if (name.equals("title")) {
						title = item.getString("GBK");
					}
				}
				// �������Ҫ�ϴ����ļ�
				else {
					String user = (String) request.getSession().getAttribute(
							"curUser");
					int album_id = (Integer)request.getSession().getAttribute(
							"curAlbumID");
					String serverFileName = null;
					// �����ļ���
					String fileName = item.getName();
					// ȡ���ļ���׺
					String appden = fileName.substring(fileName
							.lastIndexOf("."));
					// �����ļ�����
					String contentType = item.getContentType();
					// ֻ�����ϴ�jpg��gif��pngͼƬ
					if (contentType.equals("image/pjpeg")
							|| contentType.equals("image/gif")
							|| contentType.equals("image/jpeg")
							|| contentType.equals("image/png")) {
						InputStream input = item.getInputStream();
						serverFileName = String.valueOf(System
								.currentTimeMillis());
						FileOutputStream output = new FileOutputStream(
								getServletContext().getRealPath("/")
										+ "uploadfiles\\" + serverFileName
										+ appden);
						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = input.read(buffer)) > 0) {
							output.write(buffer, 0, len);
						}
						input.close();
						output.close();
						as.addPhoto(title, serverFileName + appden, keyword, user, album_id);
						response.sendRedirect("album.html?resultCode=0");
					} else {
						response.sendRedirect("album.html?resultCode=1");
					}
				}
			}
		} catch (FileUploadException fue) {
			fue.printStackTrace();
			response.sendRedirect("album.html?resultCode=2");
		} catch (NException ex) {
			ex.printStackTrace();
		}
	}
}