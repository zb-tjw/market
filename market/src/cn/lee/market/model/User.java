 package cn.lee.market.model;
 
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 
 public class User extends BaseModel
 {
   private Student MStudent;
   private String username;
   private String password;
   private Date birthday;
   private short photo;
   private String question;
   private String answer;
   private String email;
   private String qq;
   private Date create_time;
   private short status;
   private short role;
   private Set TMessages = new HashSet(0);
   private Set TComments = new HashSet(0);
 
   public User()
   {
   }
 
   public User(Student MStudent, String username, String password, Date birthday, short photo, String question, String answer, Date create_time, short status, short role)
   {
     this.MStudent = MStudent;
     this.username = username;
     this.password = password;
     this.birthday = birthday;
     this.photo = photo;
     this.question = question;
     this.answer = answer;
     this.create_time = create_time;
     this.status = status;
     this.role = role;
   }
 
   public User(Student MStudent, String username, String password, Date birthday, short photo, String question, String answer, String email, String qq, Date create_time, short status, short role, Set TMessages, Set TComments)
   {
     this.MStudent = MStudent;
     this.username = username;
     this.password = password;
     this.birthday = birthday;
     this.photo = photo;
     this.question = question;
     this.answer = answer;
     this.email = email;
     this.qq = qq;
     this.create_time = create_time;
     this.status = status;
     this.role = role;
     this.TMessages = TMessages;
     this.TComments = TComments;
   }
   public User(String username2, String password2, String question2, String answer2, int photo2, String email2, Date birthday2) {
     this.username = username2;
     this.password = password2;
     this.birthday = birthday2;
     this.photo = (short)photo2;
     this.question = question2;
     this.answer = answer2;
     this.email = email2;
     this.status = 0;
     this.role = 1;
   }
 
   public Student getMStudent()
   {
     return this.MStudent;
   }
 
   public void setMStudent(Student MStudent) {
     this.MStudent = MStudent;
   }
 
   public String getUsername() {
     return this.username;
   }
 
   public void setUsername(String username) {
     this.username = username;
   }
 
   public String getPassword() {
     return this.password;
   }
 
   public void setPassword(String password) {
     this.password = password;
   }
 
   public Date getBirthday() {
     return this.birthday;
   }
 
   public void setBirthday(Date birthday) {
     this.birthday = birthday;
   }
 
   public short getPhoto() {
     return this.photo;
   }
 
   public void setPhoto(short photo) {
     this.photo = photo;
   }
 
   public String getQuestion() {
     return this.question;
   }
 
   public void setQuestion(String question) {
     this.question = question;
   }
 
   public String getAnswer() {
     return this.answer;
   }
 
   public void setAnswer(String answer) {
     this.answer = answer;
   }
 
   public String getEmail() {
     return this.email;
   }
 
   public void setEmail(String email) {
     this.email = email;
   }
 
   public String getQq() {
     return this.qq;
   }
 
   public void setQq(String qq) {
     this.qq = qq;
   }
 
   public Date getCreate_time() {
     return this.create_time;
   }
 
   public void setCreate_time(Date create_time) {
     this.create_time = create_time;
   }
 
   public short getStatus() {
     return this.status;
   }
 
   public void setStatus(short status) {
     this.status = status;
   }
 
   public short getRole() {
     return this.role;
   }
 
   public void setRole(short role) {
     this.role = role;
   }
 
   public Set getTMessages() {
     return this.TMessages;
   }
 
   public void setTMessages(Set TMessages) {
     this.TMessages = TMessages;
   }
 
   public Set getTComments() {
     return this.TComments;
   }
 
   public void setTComments(Set TComments) {
     this.TComments = TComments;
   }
 }