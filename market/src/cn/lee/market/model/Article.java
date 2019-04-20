 package cn.lee.market.model;
 
 public class Article extends BaseModel
 {
   private String title;
   private String content;
 
   public Article()
   {
   }
 
   public Article(String title)
   {
     this.title = title;
   }
 
   public Article(String title, String content)
   {
     this.title = title;
     this.content = content;
   }
 
   public String getTitle()
   {
     return this.title;
   }
 
   public void setTitle(String title) {
     this.title = title;
   }
 
   public String getContent() {
     return this.content;
   }
 
   public void setContent(String content) {
     this.content = content;
   }
 }