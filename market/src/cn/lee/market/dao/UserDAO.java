 package cn.lee.market.dao;
 
 import cn.lee.market.model.User;
 import cn.lee.market.struts.actionform.LoginForm;
 import java.io.PrintStream;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class UserDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(UserDAO.class);
   public static final String USERNAME = "username";
   public static final String PASSWORD = "password";
   public static final String PHOTO = "photo";
   public static final String QUESTION = "question";
   public static final String ANSWER = "answer";
   public static final String EMAIL = "email";
   public static final String QQ = "qq";
   public static final String STATUS = "status";
   public static final String ROLE = "role";
 
   public void save(User transientInstance)
   {
     log.debug("saving User instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(User persistentInstance) {
     log.debug("deleting User instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public User findById(String id) {
     log.debug("getting User instance with id: " + id);
     try {
       return (User)getSession()
         .get(User.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(User instance)
   {
     log.debug("finding User instance by example");
     try {
       List results = getSession()
         .createCriteria(User.class)
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
     log.debug("finding User instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from User as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByUsername(Object username) {
     return findByProperty("username", username);
   }
 
   public List findByPassword(Object password) {
     return findByProperty("password", password);
   }
 
   public List findByPhoto(Object photo) {
     return findByProperty("photo", photo);
   }
 
   public List findByQuestion(Object question) {
     return findByProperty("question", question);
   }
 
   public List findByAnswer(Object answer) {
     return findByProperty("answer", answer);
   }
 
   public List findByEmail(Object email) {
     return findByProperty("email", email);
   }
 
   public List findByQq(Object qq) {
     return findByProperty("qq", qq);
   }
 
   public List findByStatus(Object status) {
     return findByProperty("status", status);
   }
 
   public List findByRole(Object role) {
     return findByProperty("role", role);
   }
 
   public User merge(User detachedInstance) {
     log.debug("merging User instance");
     try {
       User result = (User)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(User instance) {
     log.debug("attaching dirty User instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(User instance) {
     log.debug("attaching clean User instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public User findByUsername(String username) {
     log.debug("getting User instance with username: " + username);
     try {
       String queryString = "from User where username = '" + username.trim() + "'";
       Query queryObject = getSession().createQuery(queryString);
       List userList = queryObject.list();
       System.out.println(userList);
       if (userList == null || userList.size()==0)
       {
         System.out.println("没有些用户名!");
         return null;
       }
 
       System.out.println("找到用户：" + ((User)userList.get(0)).getUsername());
       return (User)userList.get(0);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByStu_id(String stu_id) {
     log.debug("getting User instance with stu_id: " + stu_id);
     try {
       String queryString = "from User as model where model.MStudent = '" + stu_id + "'";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public User getUser(LoginForm loginForm) {
     log.debug("getting User instance with LoginForm: " + loginForm.getUsername() + ":" + loginForm.getPassword());
     try {
       String queryString = "from User where username = '" + loginForm.getUsername().trim() + "'" + 
         " and password = '" + loginForm.getPassword() + "'";
       Query queryObject = getSession().createQuery(queryString);
       return (User)queryObject.uniqueResult();
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 }