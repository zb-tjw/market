 package cn.lee.market.dao;
 
 import cn.lee.market.model.Clazz;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class ClazzDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(ClazzDAO.class);
   public static final String CLAZZ_NAME = "clazz_name";
   public static final String CLAZZ_DESC = "clazz_desc";
 
   public void save(Clazz transientInstance)
   {
     log.debug("saving Clazz instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Clazz persistentInstance) {
     log.debug("deleting Clazz instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Clazz findById(String id) {
     log.debug("getting Clazz instance with id: " + id);
     try {
       return (Clazz)getSession()
         .get(Clazz.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Clazz instance)
   {
     log.debug("finding Clazz instance by example");
     try {
       List results = getSession()
         .createCriteria(Clazz.class)
         .add(Example.create(instance))
         .list();
       log.debug("find by example successful, result size: " + results.size());
       return results;
     } catch (RuntimeException re) {
       log.error("find by example failed", re);
       throw re;
     }
   }
 
   public List findByProperty(String propertyName, Object value) {
     log.debug("finding Clazz instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Clazz as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByClazz_name(Object clazz_name) {
     return findByProperty("clazz_name", clazz_name);
   }
 
   public List findByClazz_desc(Object clazz_desc) {
     return findByProperty("clazz_desc", clazz_desc);
   }
 
   public Clazz merge(Clazz detachedInstance) {
     log.debug("merging Clazz instance");
     try {
       Clazz result = (Clazz)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Clazz instance) {
     log.debug("attaching dirty Clazz instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Clazz instance) {
     log.debug("attaching clean Clazz instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 }
