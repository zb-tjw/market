package cn.lee.market.model;

import java.util.HashSet;
import java.util.Set;

public class Area extends BaseModel
{
  private String area_name;
  private String area_desc;
  private Set TMessages = new HashSet(0);

  public Area()
  {
  }

  public Area(String area_name, String area_desc)
  {
    this.area_name = area_name;
    this.area_desc = area_desc;
  }

  public Area(String area_name, String area_desc, Set TMessages)
  {
    this.area_name = area_name;
    this.area_desc = area_desc;
    this.TMessages = TMessages;
  }

  public String getArea_name()
  {
    return this.area_name;
  }

  public void setArea_name(String area_name) {
    this.area_name = area_name;
  }

  public String getArea_desc() {
    return this.area_desc;
  }

  public void setArea_desc(String area_desc) {
    this.area_desc = area_desc;
  }

  public Set getTMessages() {
    return this.TMessages;
  }

  public void setTMessages(Set TMessages) {
    this.TMessages = TMessages;
  }
}