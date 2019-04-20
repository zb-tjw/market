 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.ArticleDAO;
 import cn.lee.market.model.Article;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class ArticleAction extends Action
 {
   ArticleDAO aDao = new ArticleDAO();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     Article article = null;
     String articleid = request.getParameter("articleid");
     article = this.aDao.findById(articleid);
     request.setAttribute("article", article);
     return mapping.findForward("article");
   }
 }