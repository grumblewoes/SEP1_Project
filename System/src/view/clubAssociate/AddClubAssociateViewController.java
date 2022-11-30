package view.clubAssociate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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


  public AddClubAssociateViewController() {
  }
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
  {
    setModel(model);
    setViewHandler(viewHandler);
    setRoot(root);
  }
  public void reset() {
    nameField.setText("");
    surnameField.setText("");
    idField.setText("");
    errorLabel.setText("");
  }

  @FXML private void addClubAssociateButton()
  {
    errorLabel.setText("");
    try
    {
      ClubAssociate associate = new ClubAssociate(new Name(nameField.getText(),
          surnameField.getText()), Integer.parseInt(idField.getText()));
      model.addClubAssociate(associate);
      errorLabel.setText("Success");
      getViewHandler().openView("clubAssociateList");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
    @FXML private void cancelClubAssociateButton() {
      getViewHandler().openView("clubAssociateList");
    }
  }
