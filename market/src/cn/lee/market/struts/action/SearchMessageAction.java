package cn.lee.market.struts.action;

import cn.lee.market.dao.MessageDAO;
import cn.lee.market.model.Message;
import cn.lee.market.struts.actionform.SearchConditionForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SearchMessageAction extends Action
{
  private int size = 0;
  private int page = 0;
  private int first = 0;
  private int last = 0;
  private int cur_page = 0;
  MessageDAO mDao = new MessageDAO();

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    SearchConditionForm searchConditionForm = (SearchConditionForm)form;
    List messageList = this.mDao.findBySearchCondition(searchConditionForm);
    request.getSession().setAttribute("searchMessageList", messageList);
    if (request.getParameter("cur_page") != null)
      this.cur_page = Integer.parseInt(request.getParameter("cur_page"));
    else
      this.cur_page = 0;
    initPage(messageList);
    request.setAttribute("size", Integer.valueOf(this.size));
    request.setAttribute("page", Integer.valueOf(this.page));
    request.setAttribute("first", Integer.valueOf(this.first));
    request.setAttribute("last", Integer.valueOf(this.last));
    request.setAttribute("cur_page", Integer.valueOf(this.cur_page));
    return mapping.findForward("searchMessage");
  }

  public void initPage(List<Message> searchMessage) {
    this.size = searchMessage.size();
    this.page = ((int)Math.ceil(this.size * 1.0D / 20.0D) - 1);
    this.first = (20 * this.cur_page);
    this.last = (20 * this.cur_page + 19);
    if (this.last > this.size - 1)
      this.last = (this.size - 1);
  }
}