package view.clubAssociate;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.stage.Stage;
import model.ClubAssociate;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;

public class ClubAssociateViewModel implements Serializable
{
  private StringProperty nameProperty;
  private IntegerProperty schoolIdProperty;
  private StringProperty isMemberProperty;

  public ClubAssociateViewModel (ClubAssociate clubAssociate) {
    this.nameProperty = new SimpleStringProperty(clubAssociate.getFullName());
    this.schoolIdProperty = new SimpleIntegerProperty(clubAssociate.getSchoolId());
    this.isMemberProperty = new SimpleStringProperty(clubAssociate.isMember() ? "Member" :"Guest"); // if statement in one line
  }

  public StringProperty getNameProperty() {
    return nameProperty;
  }
  public IntegerProperty getSchoolIdProperty() {
    return schoolIdProperty;
  }
  public StringProperty getIsMemberProperty() {

    return isMemberProperty;
  }


}
