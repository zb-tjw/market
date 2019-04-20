 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.CommentDAO;
 import cn.lee.market.dao.MessageDAO;
 import cn.lee.market.model.Message;
 import java.io.PrintStream;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class MessageDetailAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     MessageDAO mDao = new MessageDAO();
     Message message = null;
 
     String messageid = request.getParameter("messageid");
 
     if (messageid == null)
       messageid = (String)request.getAttribute("messageid");
     System.out.println("after post messageid:" + messageid);
 
     if (messageid == null) {
       message = (Message)request.getAttribute("message");
     }
     else {
       message = mDao.findById(messageid);
       message.setTop_value(Integer.valueOf(message.getTop_value().intValue() + 1));
     }
 
     CommentDAO cDao = new CommentDAO();
     request.setAttribute("message", message);
     request.setAttribute("comments", cDao.findAllCommentOfMessage(message));
     return mapping.findForward("messageDetail");
   }
 }