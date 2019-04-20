 package cn.lee.market.dao;
 
 import cn.lee.market.model.Message;
 import cn.lee.market.model.User;
 import cn.lee.market.struts.actionform.SearchConditionForm;
 import java.io.PrintStream;
 import java.util.List;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Criteria;
 import org.hibernate.LockMode;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.criterion.Example;
 
 public class MessageDAO extends BaseHibernateDAO
 {
   private static final Log log = LogFactory.getLog(MessageDAO.class);
   public static final String MESSAGE_TITLE = "message_title";
   public static final String _OLD__VALUE = "OLD_VALUE";
   public static final String PRICE = "price";
   public static final String R_USER = "r_user";
   public static final String R_EMAIL = "r_email";
   public static final String R_PHONE = "r_phone";
   public static final String MESSAGE_DESC = "message_desc";
   public static final String MESSAGE_PHOTO = "message_photo";
   public static final String FLAG = "flag";
   public static final String TOP_VALUE = "top_value";
 
   public void save(Message transientInstance)
   {
     log.debug("saving Message instance");
     try {
       getSession().save(transientInstance);
       log.debug("save successful");
     } catch (RuntimeException re) {
       log.error("save failed", re);
       throw re;
     }
   }
 
   public void delete(Message persistentInstance) {
     log.debug("deleting Message instance");
     try {
       getSession().delete(persistentInstance);
       log.debug("delete successful");
     } catch (RuntimeException re) {
       log.error("delete failed", re);
       throw re;
     }
   }
 
   public Message findById(String id) {
     log.debug("getting Message instance with id: " + id);
     try {
       return (Message)getSession()
         .get(Message.class, id);
     }
     catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByExample(Message instance)
   {
     log.debug("finding Message instance by example");
     try {
       List results = getSession()
         .createCriteria(Message.class)
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
     log.debug("finding Message instance with property: " + propertyName + 
       ", value: " + value);
     try {
       String queryString = "from Message as model where model." + 
         propertyName + "= ?";
       Query queryObject = getSession().createQuery(queryString);
       queryObject.setParameter(0, value);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     }
   }
 
   public List findByMessage_title(Object message_title) {
     return findByProperty("message_title", message_title);
   }
 
   public List findByOLD_VALUE(Object OLD_VALUE) {
     return findByProperty("OLD_VALUE", OLD_VALUE);
   }
 
   public List findByPrice(Object price) {
     return findByProperty("price", price);
   }
 
   public List findByR_user(Object r_user) {
     return findByProperty("r_user", r_user);
   }
 
   public List findByR_email(Object r_email) {
     return findByProperty("r_email", r_email);
   }
 
   public List findByR_phone(Object r_phone) {
     return findByProperty("r_phone", r_phone);
   }
 
   public List findByMessage_desc(Object message_desc) {
     return findByProperty("message_desc", message_desc);
   }
 
   public List findByMessage_photo(Object message_photo) {
     return findByProperty("message_photo", message_photo);
   }
 
   public List findByFlag(Object flag) {
     return findByProperty("flag", flag);
   }
 
   public List findByTop_value(Object top_value) {
     return findByProperty("top_value", top_value);
   }
 
   public Message merge(Message detachedInstance) {
     log.debug("merging Message instance");
     try {
       Message result = (Message)getSession()
         .merge(detachedInstance);
       log.debug("merge successful");
       return result;
     } catch (RuntimeException re) {
       log.error("merge failed", re);
       throw re;
     }
   }
 
   public void attachDirty(Message instance) {
     log.debug("attaching dirty Message instance");
     try {
       getSession().saveOrUpdate(instance);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public void attachClean(Message instance) {
     log.debug("attaching clean Message instance");
     try {
       getSession().lock(instance, LockMode.NONE);
       log.debug("attach successful");
     } catch (RuntimeException re) {
       log.error("attach failed", re);
       throw re;
     }
   }
 
   public List getTypeMessages(String typeid) {
     log.debug("getting Message instance with typeid: " + typeid);
     try {
       String queryString = "from Message where MType = '" + typeid + "' order by id desc";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findBySearchCondition(SearchConditionForm searchConditionForm)
   {
     String keyword = searchConditionForm.getKeyword();
     String typeid = searchConditionForm.getTypeid();
     int flag = searchConditionForm.getFlag();
     String areaid = searchConditionForm.getAreaid();
     String debugMessage = "getting Message instance with [ keyword:" + 
       keyword + "],[typeid:" + typeid + "]";
     log.debug(debugMessage);
     System.out.println(debugMessage);
     try {
       String queryString = "from Message where (message_title like '%" + keyword + "%'" + 
         "or message_desc like '%" + keyword + "%')";
       if ((typeid != null) && (!"allType".equals(typeid)))
         queryString = queryString + " and MType = '" + typeid + "'";
       if ((flag == 1) || (flag == 0))
         queryString = queryString + " and flag = " + flag;
       if ((areaid != null) && (!"allArea".endsWith(areaid)))
         queryString = queryString + " and MArea = '" + areaid + "'";
       queryString = queryString + " order by id desc";
       System.out.println(queryString);
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List findByTop_value2() { log.debug("finding Top Message instance");
     try {
       String queryString = "from Message as model order by model.top_value desc,model.id desc";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
     } }
 
   public List<Message> getMyMessage(User user)
   {
     log.debug("getting Message instance with User: " + user.getUsername());
     try {
       String queryString = "from Message where TUser = '" + user.getId() + "' order by id desc";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 
   public List<Message> getUserMessage(User user) {
     log.debug("getting Message instance with User: " + user.getUsername());
     try {
       String queryString = "from Message where TUser <> '" + user.getId() + "' order by id desc";
       Query queryObject = getSession().createQuery(queryString);
       return queryObject.list();
     } catch (RuntimeException re) {
       log.error("get failed", re);
       throw re;
     }
   }
 }