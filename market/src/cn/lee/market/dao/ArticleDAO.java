 package cn.lee.market.dao;
 
 import cn.lee.market.model.Article;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class ArticleDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(ArticleDAO.class);
   public static final String TITLE = "title";
   public static final String CONTENT = "content";
 
   public void save(Article transientInstance)
   {
     log.debug("saving Article instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Article persistentInstance) {
     log.debug("deleting Article instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Article findById(String id) {
     log.debug("getting Article instance with id: " + id);
     try {
       return (Article)getSession()
         .get(Article.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Article instance)
   {
     log.debug("finding Article instance by example");
     try {
       List results = getSession()
         .createCriteria(Article.class)
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
     log.debug("finding Article instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Article as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByTitle(Object title) {
     return findByProperty("title", title);
   }
 
   public List findByContent(Object content) {
     return findByProperty("content", content);
   }
 
   public Article merge(Article detachedInstance) {
     log.debug("merging Article instance");
     try {
       Article result = (Article)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Article instance) {
     log.debug("attaching dirty Article instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Article instance) {
     log.debug("attaching clean Article instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public List getAllArticle() {
     log.debug("finding all Article instance");
     try {
       String queryString = "from Article";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("finding all Article instance failed", re);
       throw re;
     }
   }
 }