package view.games;

import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;
import model.Game;

/**
 * A class extending ViewController that controls the GUI side of allowing the user to view details of a selected game from the game list.
 *
 *
 * @author Anna P, Catarina J
 * @version 1.0 - 04 December 2022
 */

public class GameDetailsViewController extends ViewController {

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
    titleField.setText("");
    ownerField.setText("");
    playersField.setText("");
    genreField.setText("");
    descriptionField.setText("");
  }

  //needs info from GameListViewController, but can't get it
  public void setFields(Game game) {
    titleField.setText(game.getTitle());
    ownerField.setText(game.getOwner());
    playersField.setText(game.getNumberOfPlayers());
    genreField.setText(game.getType());
    descriptionField.setText(game.getDescription());
  }

  @Override public void init(ViewHandler viewHandler, BoardGamesModel model,
      Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }
}
