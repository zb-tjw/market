 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.MessageDAO;
 import cn.lee.market.model.Message;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class DeleteMessageAction extends Action
 {
   MessageDAO mDao = new MessageDAO();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String messageid = request.getParameter("messageid");
     Message message = this.mDao.findById(messageid);
     this.mDao.delete(message);
     return mapping.findForward("myMessage");
   }
 }