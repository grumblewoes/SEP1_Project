package model;

import java.io.Serializable;

public class ClubAssociate extends Person
{
  private int schoolId;
  private Name name;
  private boolean isMember;


  public ClubAssociate(Name name, int schoolId, boolean isMember)
      throws Exception
  {
    super(name);

    // if the ID is not a six digit number as is supposed to be, throw an exception
    if (!(schoolId > 0 && Integer.toString(schoolId).length() == 6))
    {
      throw new IllegalArgumentException("Invalid ID");
    }


    this.schoolId = schoolId;
    this.isMember = isMember;
  }
  public String getName()
  {
    return getFullName();
  }
  public boolean isMember() {
    return isMember;
  }
  public int getSchoolId() {
    return schoolId;
  }
  public void setMember() {
    isMember = true;
  }
  public void setGuest() {
    isMember = false;
  }
  public boolean equals (Object obj) {
      if(obj ==null || getClass() != obj.getClass() )
    {
        return false;
    }
      ClubAssociate other = (ClubAssociate)obj;
      return this.name.equals(other.name)  && this.schoolId == other.schoolId && this.isMember == other.isMember;
  }
  public String toString () {
    return schoolId + " " + name + " " + isMember;
  }
}
