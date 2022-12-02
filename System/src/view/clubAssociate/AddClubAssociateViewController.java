package view.clubAssociate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import model.Name;
import view.ViewController;
import view.ViewHandler;


public class AddClubAssociateViewController extends ViewController
{
  @FXML private TextField nameField;
  @FXML private TextField surnameField;
  @FXML private TextField idField;
  @FXML private Label errorLabel;
  @FXML private ToggleGroup membershipGroup;


  public AddClubAssociateViewController() {
  }
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;

    reset();
  }
  public void reset() {
    nameField.setText("");
    surnameField.setText("");
    idField.setText("");
    errorLabel.setText("");
  }

  @FXML private void addClubAssociateBtnClicked()
  {
    errorLabel.setText("");
    try
    {
      //to be updated...
      RadioButton membershipGroupBtn = (RadioButton) membershipGroup.getSelectedToggle();

      ClubAssociate associate = new ClubAssociate(
          new Name(
              nameField.getText(),
              surnameField.getText()
              ),
          Integer.parseInt(idField.getText()),
          !"guestRadioBtn".equals(membershipGroupBtn.getId())
        );
//
      model.addClubAssociate(associate);
      errorLabel.setText("Success");
      viewHandler.openView("clubAssociateList");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
    @FXML private void cancelClubAssociateBtnClicked() {
      viewHandler.openView("clubAssociateList");
    }

}
