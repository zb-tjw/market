package cn.lee.market.struts.action;

import cn.lee.market.dao.StudentDAO;
import cn.lee.market.dao.UserDAO;
import cn.lee.market.model.Student;
import cn.lee.market.model.User;
import cn.lee.market.struts.actionform.RegisterForm;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
 public class RegitserAction extends Action
 {
   UserDAO uDao = new UserDAO();
   StudentDAO sDao = new StudentDAO();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     HttpSession session = request.getSession();
     RegisterForm registerForm = (RegisterForm)form;
     int result = 0;
     User user = null;
     if (registerForm != null)
     {
       result = checkUserAndStu(registerForm);
       if (result == 0)
       {
         user = registerForm.getUser();
         user.setMStudent(this.sDao.findById(registerForm.getStu_id()));
         user.setCreate_time(new Date());
         this.uDao.save(user);
         session.setAttribute("user", user);
         return mapping.findForward("regitserSucess");
       }
       System.out.println(result);
     }
     return mapping.findForward("regitserFalse");
   }
 
   public int checkUserAndStu(RegisterForm form) {
     String username = form.getUsername();
     String stu_id = form.getStu_id();
     User user =this.uDao.findByUsername(username);
      List userList =new ArrayList();
      if(user!=null){
    	  userList.add(user);
      }
        userList.add(user);
     System.out.println(username + ":" + userList.size());
     if (userList.size() != 0)
     {
       System.out.println("用户名已经存在!");
       return 1;
     }
     Student stu = this.sDao.findById(form.getStu_id());
     if (stu == null)
     {
       System.out.println("没有此学号的学生！");
       return 2;
     }
     userList = this.uDao.findByStu_id(stu_id);
     if (userList.size() != 0)
     {
       System.out.println("该学号已经注册！");
       return 3;
     }
 
     return 0;
   }
 }