package cn.lee.market.test;

import cn.lee.market.dao.TypeDAO;
import cn.lee.market.model.Type;
import cn.lee.market.util.HibernateSessionFactory;
import java.io.PrintStream;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class Test
{
  public static void main(String[] args)
  {
    HibernateSessionFactory.rebuildSessionFactory();
    SessionFactory sf = HibernateSessionFactory.getSessionFactory();
    Session session = sf.openSession();
    session.beginTransaction();
    TypeDAO tDao = new TypeDAO();
    Type type = tDao.findById("1");
    System.out.println(type.getType_desc());
    session.getTransaction().commit();
  }
}