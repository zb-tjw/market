package cn.lee.market.util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.beanutils.Converter;

public class DateConverter
  implements Converter
{
  private static SimpleDateFormat df = new SimpleDateFormat();

  private static Set<String> patterns = new HashSet();

  static {
    patterns.add("yyyy-MM-dd");
    patterns.add("yyyy-MM-dd HH:mm");
    patterns.add("yyyy-MM-dd HH:mm:ss");
    patterns.add("yyyy/MM/dd HH:mm:ss");
  }

  public Object convert(Class type, Object value)
  {
    if (value == null)
      return null;
    if ((value instanceof String))
    {
      Object dateObj = null;
      Iterator it = patterns.iterator();

      while (it.hasNext())
      {
        String pattern = (String)it.next();
        df.applyPattern(pattern);
        try {
          dateObj = df.parse((String)value);
        }
        catch (ParseException e)
        {
          continue;
        }
        break;
      }
      return dateObj;
    }

    return null;
  }
  public static void main(String[] args) {
    DateConverter dc = new DateConverter();
    String str = "2028-12-12";
    System.out.println(dc.convert(Date.class, str));
  }
}