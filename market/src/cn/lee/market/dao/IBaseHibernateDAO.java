package cn.lee.market.dao;

import org.hibernate.Session;

public abstract interface IBaseHibernateDAO
{
  public abstract Session getSession();
}
