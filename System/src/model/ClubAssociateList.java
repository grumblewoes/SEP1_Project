package model;

import java.util.ArrayList;

public class ClubAssociateList
{
  private ArrayList<ClubAssociate> clubAssociates;

  public ClubAssociateList() {
   this.clubAssociates = new ArrayList<ClubAssociate>();
  }

  public void addClubAssociate(ClubAssociate associate) {
    clubAssociates.add(associate);
  }

  public void updateClubAssociate(int id) {
    for (int i =0; i< clubAssociates.size(); i++ ) {
      if (clubAssociates.get(i).getSchoolId() == id) {
        if (clubAssociates.get(i).isMember() == true) {
          clubAssociates.get(i).setGuest();
        }
        clubAssociates.get(i).setMember();
      }
    }
  }

  public ClubAssociate getClubAssociate(int id) {
    for (int i =0; i < clubAssociates.size(); i++) {
      if (clubAssociates.get(i).getSchoolId() == id) {
        return clubAssociates.get(i);
      }
    }
    return null;
  }

  public ArrayList<ClubAssociate> getAllClubAssociates()
  {
    return clubAssociates;
  }
  public String toString() {
    String text = "";
    for (ClubAssociate clubAssociate: clubAssociates) {
      text += clubAssociate;
    }
    return text;
  }

}

