package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * A class that stores the Club Associates and manages them (add, update, get, get all).
 *
 * @author Julia Gramovicha
 * @version 1.0 - 03 December 2022
 */
public class ClubAssociateList implements Serializable
{
  private ArrayList<ClubAssociate> clubAssociates;
  private ClubAssociate clubAssociate;

  /**
   * 0-argument constructor initializing the empty list of Club Associates.
   * 
   */
  public ClubAssociateList() {
   this.clubAssociates = new ArrayList<>();
  }

  /**
   * A method that adds an associate to the list.
   *
   * @throws IllegalArgumentException - in case the associate with this ID is already on the list
   * @param associate
   *        associate object that is to be added to the list.
   */
  public void addClubAssociate(ClubAssociate associate) {
    for (int i=0; i<clubAssociates.size(); i++)
    {
      if (associate.getSchoolId()==clubAssociates.get(i).getSchoolId())
      {
        throw new IllegalArgumentException("The associate with this ID is already registered.");
      }
    }
    clubAssociates.add(associate);
  }

  /**
   * 
   * A method that updates status (member or not) of a club Associate with the given ID
   * @param id associate's school ID
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
   * A method that returns the Club Associate with given ID.
   * @param id  Associate's school ID
   *        
   *
   * @return the Associate or nothing if the associate with the given ID doesn't exist
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
   * Method that returns all Club Associates as a list of clubAssociates
   *
   * @return all reservations
   */
  public ArrayList<ClubAssociate> getAllClubAssociates()
  {
    return clubAssociates;
  }
  /**
   * Method that returns string value for each Club Associate on the list
   *
   * @return a string representation of the list
   */
  public String toString() {
    String text = "";
    for (ClubAssociate clubAssociate: clubAssociates) {
      text += clubAssociate;
    }
    return text;
  }

}

