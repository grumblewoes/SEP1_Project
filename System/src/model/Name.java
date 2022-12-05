package model;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class Name implements Serializable
{
  private String firstName;
  private String lastName;

  /**
   * 2-argument constructor 
   * 
   * 
   * @param firstName 
   *        
   * @param lastName 
   *        
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getFullName() {
    return firstName + " " + lastName;
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getFirstName() {
    return firstName;
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getLastName() {
    return lastName;
  }
  public boolean equals (Object obj) {
    if(obj ==null || getClass() != obj.getClass() )
    {
      return false;
    }
    Name other = (Name)obj;
    return this.firstName.equals(other.firstName)  && this.lastName.equals(other.lastName);

  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String toString() {
    return getFullName();
  }

}
