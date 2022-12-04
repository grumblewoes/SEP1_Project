package model;

import java.io.Serializable;

public class Name implements Serializable
{
  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  public String getFullName() {
    return firstName + " " + lastName;
  }
  public String getFirstName() {
    return firstName;
  }
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
  public String toString() {
    return getFullName();
  }

}
