 package cn.lee.market.model;
 
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 
 public class Message extends BaseModel
 {
   private Area MArea;
   private User TUser;
   private Type MType;
   private String message_title;
   private short old_value;
   private long price;
   private String r_user;
   private String r_email;
   private String r_phone;
   private String message_desc;
   private String message_photo;
   private short flag;
   private Integer top_value;
   private Date create_time;
   private Set TComments = new HashSet(0);
 
   public Message()
   {
   }
 
   public Message(Area MArea, User TUser, Type MType, String message_title, short old_value, long price, String r_user, String r_phone, String message_desc, short flag, Date create_time)
   {
     this.MArea = MArea;
     this.TUser = TUser;
     this.MType = MType;
     this.message_title = message_title;
     this.old_value = old_value;
     this.price = price;
     this.r_user = r_user;
     this.r_phone = r_phone;
     this.message_desc = message_desc;
     this.flag = flag;
     this.create_time = create_time;
   }
 
   public Message(Area MArea, User TUser, Type MType, String message_title, short old_value, long price, String r_user, String r_email, String r_phone, String message_desc, String message_photo, short flag, Integer top_value, Date create_time, Set TComments)
   {
     this.MArea = MArea;
     this.TUser = TUser;
     this.MType = MType;
     this.message_title = message_title;
     this.old_value = old_value;
     this.price = price;
     this.r_user = r_user;
     this.r_email = r_email;
     this.r_phone = r_phone;
     this.message_desc = message_desc;
     this.message_photo = message_photo;
     this.flag = flag;
     this.top_value = top_value;
     this.create_time = create_time;
     this.TComments = TComments;
   }
 
   public Message(String message_title, int old_value, int price, String message_desc, String r_user, String r_email, String r_phone, int flag) {
     this.message_title = message_title;
     this.old_value = (short)old_value;
     this.price = price;
     this.r_user = r_user;
     this.r_email = r_email;
     this.r_phone = r_phone;
     this.message_desc = message_desc;
     this.flag = (short)flag;
     this.top_value = Integer.valueOf(1);
   }
 
   public Area getMArea()
   {
     return this.MArea;
   }
 
   public void setMArea(Area MArea) {
     this.MArea = MArea;
   }
 
   public User getTUser() {
     return this.TUser;
   }
 
   public void setTUser(User TUser) {
     this.TUser = TUser;
   }
 
   public Type getMType() {
     return this.MType;
   }
 
   public void setMType(Type MType) {
     this.MType = MType;
   }
 
   public String getMessage_title() {
     return this.message_title;
   }
 
   public void setMessage_title(String message_title) {
     this.message_title = message_title;
   }
 
   public short getold_value() {
     return this.old_value;
   }
 
   public void setold_value(short old_value) {
     this.old_value = old_value;
   }
 
   public long getPrice() {
     return this.price;
   }
 
   public void setPrice(long price) {
     this.price = price;
   }
 
   public String getR_user() {
     return this.r_user;
   }
 
   public void setR_user(String r_user) {
     this.r_user = r_user;
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
 
   public String getMessage_desc() {
     return this.message_desc;
   }
 
   public void setMessage_desc(String message_desc) {
     this.message_desc = message_desc;
   }
 
   public String getMessage_photo() {
     return this.message_photo;
   }
 
   public void setMessage_photo(String message_photo) {
     this.message_photo = message_photo;
   }
 
   public short getFlag() {
     return this.flag;
   }
 
   public void setFlag(short flag) {
     this.flag = flag;
   }
 
   public Integer getTop_value() {
     return this.top_value;
   }
 
   public void setTop_value(Integer top_value) {
     this.top_value = top_value;
   }
 
   public Date getCreate_time() {
     return this.create_time;
   }
 
   public void setCreate_time(Date create_time) {
     this.create_time = create_time;
   }
 
   public Set getTComments() {
     return this.TComments;
   }
 
   public void setTComments(Set TComments) {
     this.TComments = TComments;
   }
 }