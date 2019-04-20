package cn.lee.market.struts.actionform;

import cn.lee.market.model.User;
import cn.lee.market.util.DateConverter;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class RegisterForm extends ValidatorForm
{
  private static final long serialVersionUID = 5342205774782086129L;
  private String username;
  private String stu_id;
  private String password;
  private String repassword;
  private String question;
  private String answer;
  private int photo;
  private String email;
  private Date birthday;
  private String randCode;

  static
  {
    ConvertUtils.register(new DateConverter(), Date.class);
  }

  public String getAnswer() {
    return this.answer;
  }
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  public Date getBirthday() {
    return this.birthday;
  }
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  public String getEmail() {
    return this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return this.password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public int getPhoto() {
    return this.photo;
  }
  public void setPhoto(int photo) {
    this.photo = photo;
  }
  public String getQuestion() {
    return this.question;
  }
  public void setQuestion(String question) {
    this.question = question;
  }
  public String getRandCode() {
    return this.randCode;
  }
  public void setRandCode(String randCode) {
    this.randCode = randCode;
  }
  public String getRepassword() {
    return this.repassword;
  }
  public void setRepassword(String repassword) {
    this.repassword = repassword;
  }
  public String getStu_id() {
    return this.stu_id;
  }
  public void setStu_id(String stu_id) {
    this.stu_id = stu_id;
  }
  public String getUsername() {
    return this.username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public void reset(ActionMapping mapping, HttpServletRequest rquest)
  {
    this.username = null;
    this.stu_id = null;
    this.password = null;
    this.repassword = null;
    this.question = null;
    this.answer = null;
    this.photo = 0;
    this.email = null;
    this.randCode = null;
  }

  public User getUser() {
    User user = null;
    user = new User(this.username, this.password, this.question, this.answer, this.photo, this.email, this.birthday);
    return user;
  }
}