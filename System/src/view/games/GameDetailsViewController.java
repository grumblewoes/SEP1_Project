package view.games;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;
import model.Game;

/**
 * A class extending ViewController that controls the GUI side of allowing the user to view details of a selected game from the game list.
 *
 * @author Anna P, Catarina J
 * @version 1.0 - 04 December 2022
 */

public class GameDetailsViewController extends ViewController
{
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
@FXML private Button returnButton;
  @FXML
  private Label avgRating;

  /**
   * Method that returns to the list of games screen.
   */
  @FXML
  void goBack() {
    viewHandler.openView("gameList");
  }

  /**
   * Method that resets the screen to its default values.
   */
  @Override public void reset()
  {
    titleField.setText("");
    ownerField.setText("");
    playersField.setText("");
    genreField.setText("");
    descriptionField.setText("");
    Game game = model.getSelectedGame();
    returnButton.setVisible(game.getBorrowedToID()!=0);
    System.out.println(game.getBorrowedToID());
    System.out.println(game.getBorrowedToName());
    if (game.calculateAverageRating() == -1)
      avgRating.setText("No ratings yet");
    else
      avgRating.setText(String.valueOf(game.calculateAverageRating()));

    setFields(game);

  }

  /**
   * Sets the label fields for the selected game from the game list.
   * @param game the game that was selected from the game list to be displayed
   */
  public void setFields(Game game) {
    titleField.setText(game.getTitle());
    ownerField.setText(game.getOwnerFullName());
    playersField.setText(game.getNumberOfPlayers());
    genreField.setText(game.getType());
    descriptionField.setText(game.getDescription());
    if (game.calculateAverageRating() == -1)
      avgRating.setText("No ratings yet");
    else
      avgRating.setText(String.valueOf(game.calculateAverageRating()));
  }

  /**
   * Method that switches to the borrow screen
   */
  @FXML
  void borrowGame() {
    viewHandler.openView("borrow");
  }

  /**
   * Method that switches to the reserve screen
   */
  @FXML
  void reserveGame() {
    viewHandler.openView("addReservation");
  }


  @FXML
  void returnGame() {
    viewHandler.openView("returnGame");
  }

  /**
   * Method that is run once when the controller is first loaded. Facilitates
   * easy controller load
   *
   * @param viewHandler connects to viewHandler class that contains a method to
   *                    switch controllers easily
   *
   * @param model connects to model to grant access to model methods
   *
   * @param root connects to screen to switch scenes
   */
  //game and setFields() needs to be in both init() and reset() because otherwise, it wouldn't refresh upon switch
  @Override public void init(ViewHandler viewHandler, BoardGamesModel model,
      Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;

    reset();
  }

}
