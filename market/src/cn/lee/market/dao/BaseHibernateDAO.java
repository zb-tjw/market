 package cn.lee.market.dao;
 
 import cn.lee.market.util.HibernateSessionFactory;
 import org.hibernate.Session;
 
 public class BaseHibernateDAO
   implements IBaseHibernateDAO
 {
   public Session getSession()
   {
     return HibernateSessionFactory.getSession();
   }
 }