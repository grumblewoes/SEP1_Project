package model;

import java.io.Serializable;

/**
 * 
 * An abstract class that is used as a base that is extended by Club Associate
 *
 * allows to write a binary object to the file
 * 
 * @author Julia Gramovicha
 * @version 1.0 - 03 December 2022
 */
public abstract class Person implements Serializable
{
  private Name name;

  /**
   * 1-argument constructor 
   * 
   * 
   * @param name name of the Person
   *        
   */
  public Person(Name name) {
    this.name=name;
  }
  /**
   *
   * Method that returns name
   *
   * @return name
   *
   */
  public Name getName()
  {
    return name;
  }
  /**
   * 
   * Method that returns full name
   *
   * @return full name
   *        
   */
  public String getFullName(){
    return name.getFullName();
  }
  /**
   * Method that compares objects and returns whether they are the same or not
   *
   * @param obj - the object that is being compared
   * @return boolean - whether true or false, if the objects' parameters are the same or not
   *
   */
  public boolean equals (Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Person other = (Person)obj;
    return this.name.equals(other.name);
  }
  /**
   *  Method that returns a String representation of the Full Name
   *
   * @return the string with Full Name
   */
  public String toString() {
    return name.getFullName();
  }

}
