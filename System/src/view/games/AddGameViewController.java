package view.games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import view.ViewController;
import view.ViewHandler;
import model.Game;

public class AddGameViewController extends ViewController
{

  @FXML
  private TextArea descriptionBox;

  @FXML
  private Label errorLabel;

  @FXML
  private TextField genreBox;

  @FXML
  private TextField ownerBox;

  @FXML
  private TextField playersBox;

  @FXML
  private TextField titleBox;

  @FXML
  void cancelGame(ActionEvent event) {
    viewHandler.openView("gameList");
    reset();
  }

  @FXML
  void submitGame(ActionEvent event) {
    String title = titleBox.getText();
    String players = playersBox.getText();
    try {
      int owner = Integer.parseInt(ownerBox.getText());
      ClubAssociate clubAssociate = model.getClubAssociate(owner);

    }
    catch (NumberFormatException e)
    {
      errorLabel.setText("That owner's ID does not exist in the system. Check that you entered the ID correctly.");
    }
    String description = descriptionBox.getText();
    String genre = genreBox.getText();



  }

  @Override public void reset()
  {
    titleBox.setText("");
    ownerBox.setText("");
    playersBox.setText("");
    descriptionBox.setText("");
    genreBox.setText("");
  }

  @Override public void init(ViewHandler viewHandler, BoardGamesModel model,
      Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }
}


