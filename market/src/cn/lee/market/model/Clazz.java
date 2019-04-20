 package cn.lee.market.model;
 
 import java.util.HashSet;
 import java.util.Set;
 
 public class Clazz extends BaseModel
 {
   private Department MDep;
   private String clazz_name;
   private String clazz_desc;
   private Set MStudents = new HashSet(0);
 
   public Clazz()
   {
   }
 
   public Clazz(Department MDep, String clazz_name)
   {
     this.MDep = MDep;
     this.clazz_name = clazz_name;
   }
 
   public Clazz(Department MDep, String clazz_name, String clazz_desc, Set MStudents)
   {
     this.MDep = MDep;
     this.clazz_name = clazz_name;
     this.clazz_desc = clazz_desc;
     this.MStudents = MStudents;
   }
 
   public Department getMDep()
   {
     return this.MDep;
   }
 
   public void setMDep(Department MDep) {
     this.MDep = MDep;
   }
 
   public String getClazz_name() {
     return this.clazz_name;
   }
 
   public void setClazz_name(String clazz_name) {
     this.clazz_name = clazz_name;
   }
 
   public String getClazz_desc() {
     return this.clazz_desc;
   }
 
   public void setClazz_desc(String clazz_desc) {
     this.clazz_desc = clazz_desc;
   }
 
   public Set getMStudents() {
     return this.MStudents;
   }
 
   public void setMStudents(Set MStudents) {
     this.MStudents = MStudents;
   }
 }