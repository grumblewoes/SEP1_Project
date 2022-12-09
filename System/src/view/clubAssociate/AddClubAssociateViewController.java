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

import java.io.Serializable;
import java.util.InputMismatchException;

/**
 * A class extending ViewController, which controls the GUI side of adding a club associate to the club associate list
 * 
 * 
 * @author Julia Gramovicha
 * @version 1.0 - 06 December 2022
 */
public class AddClubAssociateViewController extends ViewController
{
  @FXML private TextField nameField;
  @FXML private TextField surnameField;
  @FXML private TextField idField;
  @FXML private Label errorLabel;
  @FXML private ToggleGroup membershipGroup;

  /**
   *  Method that initialises the controller and its components
   * 
   * @param viewHandler 
   *      the current viewHandler that connects view and model packages
   * @param model
   *      the model of board games system that is being used
   * @param root
   *      the root of the region
   *        
   */
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;

    reset();
  }
  /**
   *  A method that resets the data displayed in the view.
   * 
   */
  public void reset() {
    nameField.setText("");
    surnameField.setText("");
    idField.setText("");
    errorLabel.setText("");
  }
// Method to add a club associate to the list. Try-catch catches number formatting expression,
// in case if the ID was entered incorrectly(not right format and not an integer). Also, it catches Illegal Argument
// Exception, if the Name and Surname were not entered at all.
  @FXML private void addClubAssociateBtnClicked()
  {
    errorLabel.setText("");
    try
    {
      // to be updated
      RadioButton membershipGroupBtn = (RadioButton) membershipGroup.getSelectedToggle();
      if(idField.getText().equals("")){
        throw new IllegalStateException("ID is required.");
      }
      ClubAssociate associate = new ClubAssociate(
          new Name(nameField.getText(), surnameField.getText()),
          Integer.parseInt(idField.getText()), !"guestRadioBtn".equals(membershipGroupBtn.getId()));
      model.addClubAssociate(associate);
      errorLabel.setText("Success");
      viewHandler.openView("clubAssociateList");
    }
    catch (NumberFormatException n)
    {
      errorLabel.setText("ID should be an integer.");
    }
    catch (IllegalArgumentException i) {
      errorLabel.setText(i.getMessage());
    }
    catch (Exception e) {
      errorLabel.setText(e.getMessage());
    }
  }
    @FXML private void cancelClubAssociateBtnClicked() {
      viewHandler.openView("clubAssociateList");
    }

}
