package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import com.np.vo.UserVO;
//ÅÐ¶ÏµÇÂ¼×´Ì¬
public class CommentAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("userInfo");
		if (uvo == null)
		{
			System.out.println(request.getQueryString());
			System.out.println(request.getRequestURL());
			System.out.println(request.getRequestURI());
			System.out.println("Ã»ÓÐµÇÂ¼");
		}
		else
		{
			System.out.println("ÒÑ¾­µÇÂ¼ÁË");
		}
		return mapping.findForward("login");
	}
}
