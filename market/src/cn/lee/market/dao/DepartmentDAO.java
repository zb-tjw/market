 package cn.lee.market.dao;
 
 import cn.lee.market.model.Department;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class DepartmentDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(DepartmentDAO.class);
   public static final String DEP_NAME = "dep_name";
   public static final String DEP_DESC = "dep_desc";
 
   public void save(Department transientInstance)
   {
     log.debug("saving Department instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Department persistentInstance) {
     log.debug("deleting Department instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Department findById(String id) {
     log.debug("getting Department instance with id: " + id);
     try {
       return (Department)getSession()
         .get(Department.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Department instance)
   {
     log.debug("finding Department instance by example");
     try {
       List results = getSession()
         .createCriteria(Department.class)
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
     log.debug("finding Department instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Department as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByDep_name(Object dep_name) {
     return findByProperty("dep_name", dep_name);
   }
 
   public List findByDep_desc(Object dep_desc) {
     return findByProperty("dep_desc", dep_desc);
   }
 
   public Department merge(Department detachedInstance) {
     log.debug("merging Department instance");
     try {
       Department result = (Department)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Department instance) {
     log.debug("attaching dirty Department instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Department instance) {
     log.debug("attaching clean Department instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 }