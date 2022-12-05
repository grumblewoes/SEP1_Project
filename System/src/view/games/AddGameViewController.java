package view.games;
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

/**
 * A class extending ViewController that controls the GUI side of adding a game to the game list
 *
 *
 * @author Anna P, Catarina J
 * @version 1.0 - 04 December 2022
 */


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
  void cancelGame() {
    viewHandler.openView("gameList");
    reset();
  }

  //submits game to game list. first checks that all fields are set. try-catch catches number formatting exceptions, fx.
  //if a name gets submitted in the owner field instead of an id.
  @FXML
  void submitGame() {
    try
    {
      String title = titleBox.getText();
      String players = playersBox.getText();
      int owner = Integer.parseInt(ownerBox.getText());
      ClubAssociate clubAssociate = model.getClubAssociate(owner);
      String description = descriptionBox.getText();
      String genre = genreBox.getText();

      if (title.equals("") || players.equals("") || owner == 0 || description.equals("") || genre.equals(""))
        errorLabel.setText("Make sure all fields are filled before submission.");

      else
      {
        Game game = new Game(title, clubAssociate, genre, players, description);
        model.addGame(game);
        viewHandler.openView("gameList");
      }
    }
    catch (NumberFormatException e)
    {
      errorLabel.setText("Make sure to enter the owner using their ID.");
    }
  }

  /**
   * 
   * 
   */
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


