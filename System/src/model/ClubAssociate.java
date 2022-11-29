package model;

public class ClubAssociate extends Person
{
  private int schoolId;
  private Name name;
  private boolean isMember;

  public ClubAssociate(Name name, int schoolId) {
    super(name);
    this.schoolId = schoolId;
    this.isMember = false;
  }
  public boolean isMember() {
    return isMember;
  }
  public int getSchoolId() {
    return schoolId;
  }
  public void setSchoolId(int schoolId) {
    this.schoolId = schoolId;
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