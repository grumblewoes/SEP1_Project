package model;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class ClubAssociate extends Person
{
  private int schoolId;
  private boolean isMember;


  /**
   * 3-argument constructor 
   * 
   * 
   * @param name 
   *        
   * @param schoolId 
   *        
   * @param isMember 
   *        
   */
  public ClubAssociate(Name name, int schoolId, boolean isMember) throws NumberFormatException{
    super(name);

    // if the ID is not a six digit number as is supposed to be, throw an exception
    if (!(schoolId > 0 && Integer.toString(schoolId).length() == 6) )
    {
      throw new IllegalArgumentException("Invalid ID. It should be a 6-digit number. ");
    }

    this.schoolId = schoolId;
    this.isMember = isMember;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public boolean isMember() {
    return isMember;
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public int getSchoolId() {
    return schoolId;
  }
  /**
   * 
   * 
   */
  public void setMember() {
    isMember = true;
  }
  /**
   * 
   * 
   */
  public void setGuest() {
    isMember = false;
  }
  public ClubAssociate copy(){
    ClubAssociate clubAssociate = new ClubAssociate(getName(),schoolId,isMember);
    return clubAssociate;
  }
  public boolean equals (Object obj) {
      if(obj ==null || getClass() != obj.getClass() )
    {
        return false;
    }
      ClubAssociate other = (ClubAssociate)obj;
      return this.schoolId == other.schoolId && this.isMember == other.isMember;
  }
  public String toString () {
    return schoolId + " " + isMember;
  }
}
