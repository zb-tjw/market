 package cn.lee.market.model;
 
 import java.util.HashSet;
 import java.util.Set;
 
 public class Student extends BaseModel
 {
   private Clazz MClass;
   private String stu_name;
   private short sex;
   private Set TUsers = new HashSet(0);
 
   public Student()
   {
   }
 
   public Student(Clazz MClass, String stu_name, short sex)
   {
     this.MClass = MClass;
     this.stu_name = stu_name;
     this.sex = sex;
   }
 
   public Student(Clazz MClass, String stu_name, short sex, Set TUsers)
   {
     this.MClass = MClass;
     this.stu_name = stu_name;
     this.sex = sex;
     this.TUsers = TUsers;
   }
 
   public Clazz getMClass()
   {
     return this.MClass;
   }
 
   public void setMClass(Clazz MClass) {
     this.MClass = MClass;
   }
 
   public String getStu_name() {
     return this.stu_name;
   }
 
   public void setStu_name(String stu_name) {
     this.stu_name = stu_name;
   }
 
   public short getSex() {
     return this.sex;
   }
 
   public void setSex(short sex) {
     this.sex = sex;
   }
 
   public Set getTUsers() {
     return this.TUsers;
   }
 
   public void setTUsers(Set TUsers) {
     this.TUsers = TUsers;
   }
 }