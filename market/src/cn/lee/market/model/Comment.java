 package cn.lee.market.model;
 
 import java.util.Date;
 
 public class Comment extends BaseModel
 {
   private User TUser;
   private Message TMessage;
   private String content;
   private Date create_time;
 
   public Comment()
   {
   }
 
   public Comment(User TUser, Message TMessage, String content, Date create_time)
   {
     this.TUser = TUser;
     this.TMessage = TMessage;
     this.content = content;
     this.create_time = create_time;
   }
 
   public User getTUser()
   {
     return this.TUser;
   }
 
   public void setTUser(User TUser) {
     this.TUser = TUser;
   }
 
   public Message getTMessage() {
     return this.TMessage;
   }
 
   public void setTMessage(Message TMessage) {
     this.TMessage = TMessage;
   }
 
   public String getContent() {
     return this.content;
   }
 
   public void setContent(String content) {
     this.content = content;
   }
 
   public Date getCreate_time() {
     return this.create_time;
   }
 
   public void setCreate_time(Date create_time) {
     this.create_time = create_time;
   }
 }