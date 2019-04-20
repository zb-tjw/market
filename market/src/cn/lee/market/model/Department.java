 package cn.lee.market.model;
 
 import java.util.HashSet;
 import java.util.Set;
 
 public class Department extends BaseModel
 {
   private String dep_name;
   private String dep_desc;
   private Set MClasses = new HashSet(0);
 
   public Department()
   {
   }
 
   public Department(String dep_name)
   {
     this.dep_name = dep_name;
   }
 
   public Department(String dep_name, String dep_desc, Set MClasses)
   {
     this.dep_name = dep_name;
     this.dep_desc = dep_desc;
     this.MClasses = MClasses;
   }
 
   public String getDep_name()
   {
     return this.dep_name;
   }
 
   public void setDep_name(String dep_name) {
     this.dep_name = dep_name;
   }
 
   public String getDep_desc() {
     return this.dep_desc;
   }
 
   public void setDep_desc(String dep_desc) {
     this.dep_desc = dep_desc;
   }
 
   public Set getMClasses() {
     return this.MClasses;
   }
 
   public void setMClasses(Set MClasses) {
     this.MClasses = MClasses;
   }
 }