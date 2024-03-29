package cn.lee.market.struts.actionform;

import cn.lee.market.model.Message;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class PostMessageForm extends ValidatorForm
{
  private static final long serialVersionUID = 1156452272080581588L;
  private String areaid;
  private String typeid;
  private String message_title;
  private int old_value;
  private int price;
  private String r_user;
  private String r_email;
  private String r_phone;
  private String message_desc;
  private int flag;

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
  public String getMessage_desc() {
    return this.message_desc;
  }
  public void setMessage_desc(String message_desc) {
    this.message_desc = message_desc;
  }
  public String getMessage_title() {
    return this.message_title;
  }
  public void setMessage_title(String message_title) {
    this.message_title = message_title;
  }
  public Integer getOld_value() {
    return Integer.valueOf(this.old_value);
  }
  public void setOld_value(Integer old_value) {
    this.old_value = old_value.intValue();
  }
  public int getPrice() {
    return this.price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public String getR_email() {
    return this.r_email;
  }
  public void setR_email(String r_email) {
    this.r_email = r_email;
  }
  public String getR_phone() {
    return this.r_phone;
  }
  public void setR_phone(String r_phone) {
    this.r_phone = r_phone;
  }
  public String getR_user() {
    return this.r_user;
  }
  public void setR_user(String r_user) {
    this.r_user = r_user;
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
    this.typeid = null;
    this.message_title = null;
    this.message_desc = null;
    this.old_value = 10;
    this.price = 0;
    this.r_email = null;
    this.r_phone = null;
    this.r_user = null;
    this.flag = 0;
    super.reset(arg0, arg1);
  }

  public Message getMessage()
  {
    return new Message(this.message_title, this.old_value, this.price, this.message_desc, this.r_user, this.r_email, this.r_phone, this.flag);
  }
}