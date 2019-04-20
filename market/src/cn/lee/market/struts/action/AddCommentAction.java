 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.CommentDAO;
 import cn.lee.market.dao.MessageDAO;
 import cn.lee.market.model.Comment;
 import cn.lee.market.model.Message;
 import cn.lee.market.model.User;
 import java.util.Date;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class AddCommentAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String content = request.getParameter("content");
     String messageid = request.getParameter("messageid");
     CommentDAO cDao = new CommentDAO();
     MessageDAO mDao = new MessageDAO();
     Message message = mDao.findById(messageid);
     Comment comment = new Comment();
     comment.setTMessage(message);
     comment.setContent(content);
     comment.setCreate_time(new Date());
     User user = (User)request.getSession().getAttribute("user");
     comment.setTUser(user);
     cDao.save(comment);
 
     request.setAttribute("messageid", messageid);
     return mapping.findForward("messageDetail");
   }
 }