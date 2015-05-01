package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.io.File;
import com.np.service.NService;
import com.np.tool.WebUrl;

public class UserRegAction extends Action
{
	private NService ns;

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm userRegForm = (DynaActionForm)form;
		String username = (String)userRegForm.get("username");
		String password = (String)userRegForm.get("password");
		request.setAttribute("username", username);
			if (ns.checkUserName(username) == true)
			{

				request.setAttribute("have", "����ע����û����Ѿ�����, �뻻���û���");
				return mapping.findForward("have");
			}
			else
			{
				String path = WebUrl.DATA_URL;
				int Id = ns.addUser(username, password);
				File userPath = new File(path + Id);
				userPath.mkdir();
				request.setAttribute("success", "ע��ɹ�, ���¼");
				return mapping.findForward("success");
			}
		}
	}
