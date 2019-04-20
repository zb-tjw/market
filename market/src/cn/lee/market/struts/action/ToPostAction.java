package cn.lee.market.struts.action;

import cn.lee.market.dao.MessageDAO;
import cn.lee.market.model.Message;
import cn.lee.market.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ToPostAction extends Action
{
  MessageDAO mDao = new MessageDAO();

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    String messageid = request.getParameter("messageid");
    User user = (User)request.getSession().getAttribute("user");
    if (user == null)
    {
      request.setAttribute("nologin", "nologin");
      return mapping.findForward("noLogin");
    }
    if (messageid != null)
    {
      Message message = this.mDao.findById(messageid);
      request.setAttribute("message", message);
    }
    return mapping.findForward("messageform");
  }
}