 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.CommentDAO;
 import cn.lee.market.dao.MessageDAO;
 import cn.lee.market.model.Comment;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class DelCommentAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String commentid = request.getParameter("commentid");
     String messageid = request.getParameter("messageid");
     CommentDAO cDao = new CommentDAO();
     MessageDAO mDao = new MessageDAO();
 
     Comment comment = cDao.findById(commentid);
     cDao.delete(comment);
     request.setAttribute("messageid", messageid);
     return mapping.findForward("messageDetail");
   }
 }