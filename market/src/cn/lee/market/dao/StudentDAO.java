 package cn.lee.market.dao;
 
 import cn.lee.market.model.Student;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class StudentDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(StudentDAO.class);
   public static final String STU_NAME = "stu_name";
   public static final String SEX = "sex";
 
   public void save(Student transientInstance)
   {
     log.debug("saving Student instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Student persistentInstance) {
     log.debug("deleting Student instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Student findById(String id) {
     log.debug("getting Student instance with id: " + id);
     try {
       return (Student)getSession()
         .get(Student.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Student instance)
   {
     log.debug("finding Student instance by example");
     try {
       List results = getSession()
         .createCriteria(Student.class)
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
     log.debug("finding Student instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Student as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByStu_name(Object stu_name) {
     return findByProperty("stu_name", stu_name);
   }
 
   public List findBySex(Object sex) {
     return findByProperty("sex", sex);
   }
 
   public Student merge(Student detachedInstance) {
     log.debug("merging Student instance");
     try {
       Student result = (Student)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Student instance) {
     log.debug("attaching dirty Student instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Student instance) {
     log.debug("attaching clean Student instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 }