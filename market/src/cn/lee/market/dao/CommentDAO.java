 package cn.lee.market.dao;
 
 import cn.lee.market.model.Comment;
 import cn.lee.market.model.Message;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class CommentDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(CommentDAO.class);
   public static final String CONTENT = "content";
 
   public void save(Comment transientInstance)
   {
     log.debug("saving Comment instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Comment persistentInstance) {
     log.debug("deleting Comment instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Comment findById(String id) {
     log.debug("getting Comment instance with id: " + id);
     try {
       return (Comment)getSession()
         .get(Comment.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Comment instance)
   {
     log.debug("finding Comment instance by example");
     try {
       List results = getSession()
         .createCriteria(Comment.class)
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
     log.debug("finding Comment instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Comment as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByContent(Object content) {
     return findByProperty("content", content);
   }
 
   public Comment merge(Comment detachedInstance) {
     log.debug("merging Comment instance");
     try {
       Comment result = (Comment)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Comment instance) {
     log.debug("attaching dirty Comment instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Comment instance) {
     log.debug("attaching clean Comment instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public List findAllCommentOfMessage(Message message) {
     log.debug("finding Comment instance with messageid: " + message.getId());
     try {
       String queryString = "from Comment as model where model.TMessage= '" + 
         message.getId() + "'";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by messageid  failed", re);
       throw re;
     }
   }
 }