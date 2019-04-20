 package cn.lee.market.dao;
 
 import cn.lee.market.model.Area;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class AreaDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(AreaDAO.class);
   public static final String AREA_NAME = "area_name";
   public static final String AREA_DESC = "area_desc";
 
   public void save(Area transientInstance)
   {
     log.debug("saving Area instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Area persistentInstance) {
     log.debug("deleting Area instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Area findById(String id) {
     log.debug("getting Area instance with id: " + id);
     try {
       return (Area)getSession()
         .get(Area.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Area instance)
   {
     log.debug("finding Area instance by example");
     try {
       List results = getSession()
         .createCriteria(Area.class)
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
     log.debug("finding Area instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Area as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByArea_name(Object area_name) {
     return findByProperty("area_name", area_name);
   }
 
   public List findByArea_desc(Object area_desc) {
     return findByProperty("area_desc", area_desc);
   }
 
   public Area merge(Area detachedInstance) {
     log.debug("merging Area instance");
     try {
       Area result = (Area)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Area instance) {
     log.debug("attaching dirty Area instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Area instance) {
     log.debug("attaching clean Area instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public List findAllArea() {
     log.debug("finding All Area");
     try {
       String queryString = "from Area";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find All Area failed", re);
       throw re;
     }
   }
 }