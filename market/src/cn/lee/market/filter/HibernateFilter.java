package cn.lee.market.filter;
 
 import cn.lee.market.util.HibernateSessionFactory;
 import java.io.IOException;
 import javax.servlet.Filter;
 import javax.servlet.FilterChain;
 import javax.servlet.FilterConfig;
 import javax.servlet.ServletException;
 import javax.servlet.ServletRequest;
 import javax.servlet.ServletResponse;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.hibernate.Session;
 import org.hibernate.Transaction;
 
 public class HibernateFilter
   implements Filter
 {
   public static Log log = LogFactory.getLog(HibernateFilter.class);
 
   public void destroy()
   {
   }
 
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
   {
     Session session = HibernateSessionFactory.getSession();
     try {
       log.debug("set character Encoding to GBK");
       request.setCharacterEncoding("GBK");
       log.debug("starting a database transation");
       session.beginTransaction();
 
       log.debug("Request path:\t" + 
         ((HttpServletRequest)request).getServletPath());
       chain.doFilter(request, response);
       log.debug("Committing the database transaction after exception.");
       session.getTransaction().commit();
     } catch (Throwable ex) {
       ex.printStackTrace();
       try {
         log.debug("Trying to roolback database transaction after exception.");
         session.getTransaction().rollback();
       }
       catch (Throwable rbEx)
       {
         log.error("Could not roolback transaction after exception!", rbEx);
       }
       throw new ServletException(ex);
     }
   }
 
   public void init(FilterConfig arg0)
     throws ServletException
   {
   }
 }