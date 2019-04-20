 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.AreaDAO;
 import cn.lee.market.dao.MessageDAO;
 import cn.lee.market.dao.TypeDAO;
 import cn.lee.market.model.Message;
 import cn.lee.market.model.User;
 import cn.lee.market.struts.actionform.PostMessageForm;
 import java.util.Date;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class PostMessageAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     MessageDAO mDao = new MessageDAO();
     TypeDAO tDao = new TypeDAO();
     AreaDAO aDao = new AreaDAO();
     PostMessageForm postForm = (PostMessageForm)form;
 
     User user = (User)request.getSession().getAttribute("user");
     Message message = null;
     if (postForm != null)
     {
       message = postForm.getMessage();
       message.setCreate_time(new Date());
       message.setMArea(aDao.findById(postForm.getAreaid()));
       message.setMType(tDao.findById(postForm.getTypeid()));
       message.setTUser(user);
     }
     String messageid = request.getParameter("messageid");
 
     if ((messageid != null) && (!"".equals(messageid)))
     {
       message = mDao.findById(messageid);
       message.setMessage_title(postForm.getMessage_title());
       message.setold_value(postForm.getOld_value().shortValue());
       message.setFlag((short)postForm.getFlag());
       message.setMessage_desc(postForm.getMessage_desc());
       message.setPrice(postForm.getPrice());
       message.setR_user(postForm.getR_user());
       message.setR_email(postForm.getR_email());
       message.setR_phone(postForm.getR_phone());
       message.setMArea(aDao.findById(postForm.getAreaid()));
       message.setMType(tDao.findById(postForm.getTypeid()));
     }
     else {
       mDao.save(message);
     }
     return mapping.findForward("mymessage");
   }
 }