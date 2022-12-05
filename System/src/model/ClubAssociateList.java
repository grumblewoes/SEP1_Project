package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class ClubAssociateList implements Serializable
{
  private ArrayList<ClubAssociate> clubAssociates;

  /**
   * 0-argument constructor 
   * 
   * 
   */
  public ClubAssociateList() {
   this.clubAssociates = new ArrayList<ClubAssociate>();
  }

  /**
   * 
   * 
   * @param associate 
   *        
   */
  public void addClubAssociate(ClubAssociate associate) {
    clubAssociates.add(associate);
  }

  /**
   * 
   * 
   * @param id 
   *        
   */
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

  /**
   * 
   * 
   * @param id 
   *        
   *
   * @return 
   *        
   */
  public ClubAssociate getClubAssociate(int id) {
    for (int i =0; i < clubAssociates.size(); i++) {
      if (clubAssociates.get(i).getSchoolId() == id) {
        return clubAssociates.get(i);
      }
    }
    return null;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<ClubAssociate> getAllClubAssociates()
  {
    return clubAssociates;
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String toString() {
    String text = "";
    for (ClubAssociate clubAssociate: clubAssociates) {
      text += clubAssociate;
    }
    return text;
  }

}

