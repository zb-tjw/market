package cn.lee.market.struts.actionform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class SearchConditionForm extends ValidatorForm
{
  private String keyword;
  private String typeid;
  private int flag;
  private String areaid;

  public String getAreaid()
  {
    return this.areaid;
  }
  public void setAreaid(String areaid) {
    this.areaid = areaid;
  }
  public int getFlag() {
    return this.flag;
  }
  public void setFlag(int flag) {
    this.flag = flag;
  }

  public String getKeyword() {
    return this.keyword;
  }
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
  public String getTypeid() {
    return this.typeid;
  }
  public void setTypeid(String typeid) {
    this.typeid = typeid;
  }

  public void reset(ActionMapping arg0, HttpServletRequest arg1)
  {
    this.areaid = null;
    this.flag = 0;
    this.keyword = null;
    this.typeid = null;
    super.reset(arg0, arg1);
  }
}