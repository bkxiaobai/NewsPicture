package com.np.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import com.np.service.AService;
import com.np.service.NService;
import com.np.vo.ChannelVO;

public class AddChannelAction extends Action
{
	private AService as;

	private NService ns;

	public void setAs(AService as)
	{
		this.as = as;
	}

	public void setNs(NService ns)
	{
		this.ns = ns;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm addChannelForm = (DynaActionForm)form;
		String title = (String)addChannelForm.get("title");
		as.addChannel(title);
		List<ChannelVO> cvos = ns.getAllChannel();
		request.getSession().setAttribute("channels", cvos);
		request.setAttribute("success", "添加栏目成功");
		return mapping.findForward("success");
	}
}
