 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.ArticleDAO;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class GuideListAction extends Action
 {
   ArticleDAO aDao = new ArticleDAO();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     List articleList = this.aDao.getAllArticle();
     request.setAttribute("articleList", articleList);
 
     String delSucess = (String)request.getAttribute("delSucess");
     if (delSucess != null) {
       request.setAttribute("delSucess", "delSucess");
     }
     return mapping.findForward("guideList");
   }
 }