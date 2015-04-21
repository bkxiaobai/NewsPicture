package com.np.web.base;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.np.service.NService;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = -2041755371540813745L;

	protected NService as;

	// 定义构造器，获得Spring容器的引用
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		as = (NService) ctx.getBean("NService");
	}
}
