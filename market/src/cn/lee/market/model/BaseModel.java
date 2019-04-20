 package cn.lee.market.model;
 
 import java.io.Serializable;
 import org.apache.commons.lang.builder.EqualsBuilder;
 import org.apache.commons.lang.builder.HashCodeBuilder;
 import org.apache.commons.lang.builder.ReflectionToStringBuilder;
 
 public class BaseModel
   implements Serializable
 {
   private static final long serialVersionUID = 7766184319541530720L;
   private String id;
 
   public String getId()
   {
     return this.id;
   }
 
   public void setId(String id) {
     this.id = id;
   }
 
   public boolean equals(Object obj)
   {
     if (this == obj) return true;
 
     if (!(obj instanceof BaseModel)) {
       return false;
     }
     BaseModel target = (BaseModel)obj;
 
     if ((getId() != null) && (getId().length() > 0))
     {
       return getId().equals(target.getId());
     }
 
     if ((target.getId() != null) && (target.getId().length() > 0))
     {
       return false;
     }
 
     return EqualsBuilder.reflectionEquals(this, obj);
   }
 
   public int hashCode()
   {
     if ((getId() != null) && (getId().length() > 0))
     {
       return getId().hashCode();
     }
 
     return HashCodeBuilder.reflectionHashCode(this);
   }
 
   public String toString()
   {
     return ReflectionToStringBuilder.toString(this);
   }
 }