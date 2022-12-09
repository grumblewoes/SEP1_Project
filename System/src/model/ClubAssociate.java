package model;

import java.io.Serializable;

/**
 * 
 * A class representing a club associate.
 * It answers questions - is an associate a member and what is his ID. It extends class Person, which has Name with
 * first and last names.
 * 
 * @author Julia Gramovicha
 * @version 1.0 - 03 December 2022
 */
public class ClubAssociate extends Person
{
  private int schoolId;
  private boolean isMember;


  /**
   * 3-argument constructor
   * Illegal ID will throw the IllegalArgumentException and NumberFormatException
   * 
   * @throws IllegalArgumentException
   * @throws NumberFormatException
   * @param name full name of an associate
   * @param schoolId the id of an associate
   * @param isMember whether he is a member or not
   *        
   */
  public ClubAssociate(Name name, int schoolId, boolean isMember) throws NumberFormatException{
    super(name);

    // if the ID is not a 6-digit number as is supposed to be, throw an exception
    if (!(schoolId > 0 && Integer.toString(schoolId).length() == 6) )
    {
      throw new IllegalArgumentException("Invalid ID. Enter a 6-digit number. ");
    }

    this.schoolId = schoolId;
    this.isMember = isMember;
  }

  /**
   * 
   * Method that returns whether the associate is a member or not
   *
   * @return isMember
   *        
   */
  public boolean isMember() {
    return isMember;
  }
  /**
   * 
   * Method that returns associate's ID
   *
   * @return school ID
   *        
   */
  public int getSchoolId() {
    return schoolId;
  }
  /**
   * 
   * Method that sets an associate to member
   *
   *
   */

  public void setMember() {
    isMember = true;
  }
  /**
   * 
   * Method that sets an associate to guest
   */
  public void setGuest() {
    isMember = false;
  }
  /**
   *
   * Method that makes a copy of a club associate
   */
  public ClubAssociate copy() {
    ClubAssociate clubAssociate = new ClubAssociate(getName(),schoolId,isMember);
    return clubAssociate;
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
      ClubAssociate other = (ClubAssociate)obj;
      return this.schoolId == other.schoolId && this.isMember == other.isMember;
  }
  /**
   *  Method that returns a String representation of the Club Associate
   *
   * @return the string representation of the Club Associate
   */
  public String toString () {
    return schoolId + " " + isMember;
  }
}
