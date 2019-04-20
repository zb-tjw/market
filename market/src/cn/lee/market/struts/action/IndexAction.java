 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.AreaDAO;
 import cn.lee.market.dao.MessageDAO;
 import cn.lee.market.dao.TypeDAO;
 import cn.lee.market.model.Area;
 import cn.lee.market.model.Message;
 import cn.lee.market.model.Type;
 import java.io.PrintStream;
 import java.util.HashMap;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class IndexAction extends Action
 {
   TypeDAO tDao = new TypeDAO();
   AreaDAO aDao = new AreaDAO();
   MessageDAO mDao = new MessageDAO();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     HashMap messageMap = new HashMap();
     HashMap typeMap = new HashMap();
     HashMap areaMap = new HashMap();
     List TopMessageList = this.mDao.findByTop_value2();
     List <Type> typeList = this.tDao.findAllType();
     List typeMessage;
     for (Type type : typeList)
     {
       typeMessage = this.mDao.getTypeMessages(type.getId());
       messageMap.put(type.getId(), typeMessage);
       typeMap.put(type.getId(), type.getType_desc());
     }
     request.getSession().setAttribute("typeMap", typeMap);
     List <Area>areaList = this.aDao.findAllArea();
     for (Area area : areaList)
     {
       areaMap.put(area.getId(), area.getArea_desc());
     }
     request.getSession().setAttribute("areaMap", areaMap);
     request.setAttribute("messageMap", messageMap);
     request.getSession().setAttribute("TopMessageList", TopMessageList);
     request.setAttribute("homeFlag", "homeFlag");
     if (request.getAttribute("nologin") != null)
       request.setAttribute("nologin", "nologin");
     return mapping.findForward("homepage");
   }
 
   public void display(List <Type>typeList) {
     System.out.println("----------------------------------------");
     for (Type type : typeList)
     {
       System.out.println(type.getType_desc());
       List <Message> typeMessage = this.mDao.getTypeMessages(type.getId());
       for (Message message : typeMessage)
       {
         System.out.printf("----", new Object[0]);
         System.out.println(message.getMessage_desc());
       }
       System.out.println("----------------------------------------");
     }
   }
 }