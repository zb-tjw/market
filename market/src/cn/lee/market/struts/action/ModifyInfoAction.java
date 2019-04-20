 package cn.lee.market.struts.action;
 
 import cn.lee.market.model.User;
 import cn.lee.market.util.DateConverter;
 import java.io.PrintStream;
 import java.util.Date;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class ModifyInfoAction extends Action
 {
   DateConverter dc = new DateConverter();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     HttpSession session = request.getSession();
     User user = (User)session.getAttribute("user");
     String result = null;
     result = "修改成功！点确定进入市场主页！";
 
     String photo_ = request.getParameter("photo");
     int photo = Integer.parseInt(photo_);
     String str = request.getParameter("birthday");
     Date birthday = (Date)this.dc.convert(Date.class, str);
     System.out.println(str + "->" + birthday);
     String email = request.getParameter("email");
     String doModPWD = request.getParameter("doModPWD");
     if ("1".equals(doModPWD))
     {
       String oldPassword = request.getParameter("oldPassword");
       String newPassword = request.getParameter("newPassword");
       String confirmPassword = request.getParameter("confirmPassword");
       if (oldPassword.equals(user.getPassword()))
       {
         if (newPassword.equals(confirmPassword)) {
           user.setPassword(newPassword);
         }
         else {
           request.setAttribute("error", "error");
           result = "修改密码与确认密码不同！请重新输入！";
         }
       }
       else
       {
         request.setAttribute("error", "error");
         result = "原始密码输入错误！请重新输入！";
       }
     }
     user.setBirthday(birthday);
     user.setEmail(email);
     user.setPhoto((short)photo);
 
     request.setAttribute("result", result);
     return mapping.findForward("modifyInfo");
   }
 }