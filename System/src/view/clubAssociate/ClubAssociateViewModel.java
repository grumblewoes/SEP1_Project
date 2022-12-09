package view.clubAssociate;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.stage.Stage;
import model.ClubAssociate;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;

/**
 * A class that converts the Club Associate from model to the one that can be used from GUI.
 *
 *
 * @author Julia Gramovicha
 * @version 1.0 - 03 December 2022
 */
public class ClubAssociateViewModel implements Serializable
{
  private ClubAssociate clubAssociate;
  private StringProperty nameProperty;
  private IntegerProperty schoolIdProperty;
  private StringProperty isMemberProperty;

  /**
   * 1-argument constructor that sets up the ClubAssociateVieModel based on the ClubAssociate.
   * It converts the Club Associate to the structure that can be understood by GUI.
   *
   * @param clubAssociate
   *        the instance of the Event that is to be converted
   */

  public ClubAssociateViewModel (ClubAssociate clubAssociate) {
    this.clubAssociate = clubAssociate;
    this.nameProperty = new SimpleStringProperty(clubAssociate.getFullName());
    this.schoolIdProperty = new SimpleIntegerProperty(clubAssociate.getSchoolId());
    this.isMemberProperty = new SimpleStringProperty(clubAssociate.isMember() ? "Member" :"Guest");
    // if statement in one line
  }
  /**
   * A method that returns the name property.
   *
   *
   * @return nameProperty
   *        the simpleStringProperty of the ClubAssociateViewModel title
   */
  public StringProperty getNameProperty() {
    return nameProperty;
  }

  /**
   * A method that returns the schoolId property.
   *
   *
   * @return schoolIdProperty
   *        the simpleStringProperty of the ClubAssociateViewModel title
   */
  public IntegerProperty getSchoolIdProperty() {
    return schoolIdProperty;
  }
  /**
   * A method that returns the isMember property.
   *
   *
   * @return isMemberProperty
   *        the simpleStringProperty of the ClubAssociateViewModel title
   */
  public StringProperty getIsMemberProperty() {

    return isMemberProperty;
  }
  /**
   * A method that returns the isMember property.
   *
   *
   * @return clubAssociate
   *        the simpleStringProperty of the ClubAssociateViewModel title
   */
  public ClubAssociate getClubAssociate() {
    return clubAssociate;
  }

  @Override public boolean equals(Object obj){
    if(obj==null || !(obj instanceof ClubAssociateViewModel) ) return false;

    ClubAssociateViewModel other = (ClubAssociateViewModel) obj;

    return clubAssociate.equals(other.clubAssociate) &&
        nameProperty.get().equals(other.nameProperty.get()) &&
        schoolIdProperty.get() == other.schoolIdProperty.get() &&
        isMemberProperty.get().equals( other.isMemberProperty.get());
  }
}
