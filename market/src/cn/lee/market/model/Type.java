 package cn.lee.market.model;
 
 import java.util.HashSet;
 import java.util.Set;
 
 public class Type extends BaseModel
 {
   private String type_name;
   private String type_desc;
   private Set TMessages = new HashSet(0);
 
   public Type()
   {
   }
 
   public Type(String type_name, String type_desc)
   {
     this.type_name = type_name;
     this.type_desc = type_desc;
   }
 
   public Type(String type_name, String type_desc, Set TMessages)
   {
     this.type_name = type_name;
     this.type_desc = type_desc;
     this.TMessages = TMessages;
   }
 
   public String getType_name()
   {
     return this.type_name;
   }
 
   public void setType_name(String type_name) {
     this.type_name = type_name;
   }
 
   public String getType_desc() {
     return this.type_desc;
   }
 
   public void setType_desc(String type_desc) {
     this.type_desc = type_desc;
   }
 
   public Set getTMessages() {
     return this.TMessages;
   }
 
   public void setTMessages(Set TMessages) {
     this.TMessages = TMessages;
   }
 }