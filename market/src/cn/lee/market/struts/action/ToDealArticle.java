package cn.lee.market.struts.action;

import cn.lee.market.dao.ArticleDAO;
import cn.lee.market.model.Article;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ToDealArticle extends Action
{
  ArticleDAO aDao = new ArticleDAO();

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    Article article = null;
    String articleid = request.getParameter("articleid");
    article = this.aDao.findById(articleid);
    String action = request.getParameter("action");
    if ("mod".equals(action))
    {
      request.setAttribute("article", article);
      return mapping.findForward("articleForm");
    }
    if ("del".equals(action))
    {
      this.aDao.delete(article);
      request.setAttribute("delSucess", "delSucess");
    }
    return mapping.findForward("guidelist");
  }
}