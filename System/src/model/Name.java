package model;

import java.io.Serializable;

/**
 * 
 * A class representing associate's first name and last name
 * 
 * @author Julia Gramovicha
 * @version 1.0 - 03 December 2022
 */
public class Name implements Serializable
{
  private String firstName;
  private String lastName;

  /**
   * 2-argument constructor 
   * 
   * @throws IllegalArgumentException in case if either name or surname wasn't entered
   * @param firstName name of the Associate
   * @param lastName surname of the Associate
   *        
   */
  public Name(String firstName, String lastName) {
    if (firstName == null || firstName.isEmpty()) {
      throw new IllegalArgumentException("Make sure to enter the name.");
    }

    if (lastName == null || lastName.isEmpty()) {
      throw new IllegalArgumentException("Make sure to enter the surname.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
  }
  /**
   * 
   * Method that returns full name which consists of a name and surname
   *
   * @return Full Name (first name and last name)
   *        
   */
  public String getFullName() {
    return firstName + " " + lastName;
  }
  /**
   * 
   * Method that returns first name
   *
   * @return first name
   *        
   */
  public String getFirstName() {
    return firstName;
  }
  /**
   * 
   * Method that returns last name
   *
   * @return last name
   *        
   */
  public String getLastName() {
    return lastName;
  }
  /**
   * Method that compares objects and returns whether they are the same or not
   *
   * @param obj - the object that is being compared
   * @return boolean - whether true or false, if the objects' parameters are the same or not
   *
   */
  public boolean equals (Object obj) {
    if(obj ==null || getClass() != obj.getClass() )
    {
      return false;
    }
    Name other = (Name)obj;
    return this.firstName.equals(other.firstName)  && this.lastName.equals(other.lastName);

  }
  /**
   *  Method that returns a String representation of the Full Name
   *
   * @return the string with Full Name
   */
  public String toString() {
    return getFullName();
  }

}
