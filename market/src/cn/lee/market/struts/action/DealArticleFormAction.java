 package cn.lee.market.struts.action;
 
 import cn.lee.market.dao.ArticleDAO;
 import cn.lee.market.model.Article;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class DealArticleFormAction extends Action
 {
   ArticleDAO aDao = new ArticleDAO();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     Article article = null;
     String title = request.getParameter("title");
     String content = request.getParameter("content");
     String action = request.getParameter("action");
     if ("add".equals(action))
     {
       article = new Article(title, content);
       this.aDao.save(article);
     }
     else if ("mod".equals(action))
     {
       String articleid = request.getParameter("articleid");
       article = this.aDao.findById(articleid);
       article.setTitle(title);
       article.setContent(content);
       this.aDao.attachDirty(article);
     }
     request.setAttribute("article", article);
     return mapping.findForward("guidelist");
   }
 }