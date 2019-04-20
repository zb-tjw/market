 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.UserDAO;
 import cn.lee.market.model.User;
 import cn.lee.market.struts.actionform.LoginForm;
 import java.io.PrintStream;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class LoginAction extends Action
 {
   UserDAO uDao = new UserDAO();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     LoginForm loginForm = (LoginForm)form;
 
     HttpSession session = request.getSession();
 
     User user = this.uDao.getUser(loginForm);
     if (user != null)
     {
       session.removeAttribute("user");
       session.setAttribute("user", user);
 
       if (user.getRole() == 0)
         session.setAttribute("role", "admin");
     }
     else {
       request.setAttribute("loginError", "login Error!");
     }return mapping.findForward("index");
   }
 
   private User login(String username, String password)
   {
     User user = null;
     UserDAO uDao = new UserDAO();
     if ((username == null) || ("".equals(username)) || (password == null) || ("".equals(password)))
       return null;
     user = uDao.findByUsername(username);
     System.out.println(user.getUsername() + ":" + user.getPassword() + ":{" + password.equals(user.getPassword()) + "}");
     return user;
   }
 }