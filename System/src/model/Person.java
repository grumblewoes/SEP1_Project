package model;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public abstract class Person implements Serializable
{
  private Name name;

  /**
   * 1-argument constructor 
   * 
   * 
   * @param name 
   *        
   */
  public Person(Name name) {
    this.name=name;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getFullName(){
    return name.getFullName();
  }

  public Name getName()
  {
    return name;
  }

  public boolean equals (Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Person other = (Person)obj;
    return this.name.equals(other.name);
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String toString() {
    return name.getFullName();
  }

}
