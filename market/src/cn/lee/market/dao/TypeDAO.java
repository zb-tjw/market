 package cn.lee.market.dao;
 
 import cn.lee.market.model.Type;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class TypeDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(TypeDAO.class);
   public static final String TYPE_NAME = "type_name";
   public static final String TYPE_DESC = "type_desc";
 
   public void save(Type transientInstance)
   {
     log.debug("saving Type instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Type persistentInstance) {
     log.debug("deleting Type instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Type findById(String id) {
     log.debug("getting Type instance with id: " + id);
     try {
       return (Type)getSession()
         .get(Type.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Type instance)
   {
     log.debug("finding Type instance by example");
     try {
       List results = getSession()
         .createCriteria(Type.class)
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
     log.debug("finding Type instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Type as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByType_name(Object type_name) {
     return findByProperty("type_name", type_name);
   }
 
   public List findByType_desc(Object type_desc) {
     return findByProperty("type_desc", type_desc);
   }
 
   public Type merge(Type detachedInstance) {
     log.debug("merging Type instance");
     try {
       Type result = (Type)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Type instance) {
     log.debug("attaching dirty Type instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Type instance) {
     log.debug("attaching clean Type instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public List findAllType() {
     log.debug("finding All Type");
     try {
       String queryString = "from Type";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find All type failed", re);
       throw re;
     }
   }
 }
