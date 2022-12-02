package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;

public class GameDetailsViewController extends ViewController{

  @FXML
  private Button backButton;

  @FXML
  private Label descriptionField;

  @FXML
  private Label genreField;

  @FXML
  private Label ownerField;

  @FXML
  private Label playersField;

  @FXML
  private Label titleField;

  @FXML
  void goBack(ActionEvent event) {
  viewHandler.openView("gameList");
  }

  @Override public void reset()
  {

  }

  @Override public void init(ViewHandler viewHandler, BoardGamesModel model,
      Region root)
  {
    this.viewHandler= viewHandler;
    this.model=model;
    this.root=root;
  }
}
