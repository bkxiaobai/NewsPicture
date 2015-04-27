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
		// 获取输出流
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript>'");
		try {
			// 使用Uploader处理上传
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			iter = items.iterator();
			// 遍历每个表单控件对应的内容
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// 如果该项是普通表单域
				if (item.isFormField()) {
					String name = item.getFieldName();
					if (name.equals("title")) {
						title = item.getString("GBK");
					}
				}
				// 如果是需要上传的文件
				else {
					String user = (String) request.getSession().getAttribute(
							"curUser");
					int album_id = (Integer)request.getSession().getAttribute(
							"curAlbumID");
					String serverFileName = null;
					// 返回文件名
					String fileName = item.getName();
					// 取得文件后缀
					String appden = fileName.substring(fileName
							.lastIndexOf("."));
					// 返回文件类型
					String contentType = item.getContentType();
					// 只允许上传jpg、gif、png图片
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