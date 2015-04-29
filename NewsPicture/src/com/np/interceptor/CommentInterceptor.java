package com.np.interceptor;

import org.aopalliance.intercept.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.np.vo.UserVO;

public class CommentInterceptor implements MethodInterceptor
{
	public Object invoke(MethodInvocation invocation)throws Throwable
	{
		HttpServletRequest request = null;
		@SuppressWarnings("unused")
		ActionMapping mapping = null;
		Object[] args = invocation.getArguments();
		for (int i = 0 ; i < args.length ; i++ )
		{
			if (args[i] instanceof HttpServletRequest)
			{
				request = (HttpServletRequest)args[i];
			}
			if (args[i] instanceof ActionMapping)
			{
				mapping = (ActionMapping)args[i];
			}
		}
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("userInfo");
		if (uvo == null)
		{
			request.setAttribute("nologin", "���ȵ�¼");
			Integer photoId = (Integer)session.getAttribute("photoId");
			String url = "/seecomment.do?photoId=" + String.valueOf(photoId);
			session.setAttribute("userUrl", url);
			ActionForward af = new ActionForward("/myalbum.do");
			return af;
		}
		else
		{
			return invocation.proceed();
		}
	}
}
