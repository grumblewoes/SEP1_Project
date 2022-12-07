package view.games;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import model.Wish;
import view.ViewController;
import view.ViewHandler;
import model.Game;

import static model.Game.*;

/**
 * A class extending ViewController that controls the GUI side of adding a game to the game list
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
  private ChoiceBox<String> typeBox;

  @FXML
  private TextField ownerBox;

  @FXML
  private TextField playersBox;

  @FXML
  private TextField titleBox;

  @FXML
  void cancelGame() {
    viewHandler.openView("gameList");
    //why reset after canceling? no need
    reset();
  }

  private boolean formatNumberOfPlayers(String value){
    value = playersBox.getText();

    if(!value.matches("[1-9]\\d*-[1-9]\\d*")&&value.charAt(0)<value.charAt(1)) {
      return false;
    }
    return true;
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
      System.out.println(clubAssociate);
      String description = descriptionBox.getText();
      //fetch selected value
      String type = typeBox.getValue();

      if (title.equals("") || formatNumberOfPlayers(players) || owner == 0 || description.equals("") || type == null)
        errorLabel.setText("Make sure all fields are filled before submission.");

      else
      {
        //ur still adding the game to the model even tho clubAssociate doesnt exsit
        //thats because there no validation for Game
        //and then theres the assumption that the clubAssociate is not null in one of the functions that return name of the owner like owner.getFullName() but owner is null
        //so "NullPointerException e" happens not because the clubAssociate by given id doesnt exist but because we have no validation in Game

        Game game = new Game(title, clubAssociate, type, players, description);
        model.addGame(game);
        System.out.println("the game was added");

        //check if game is on the wishlist. if it is, remove it
        //covers [ALT2] in RegisterNewGame
        Wish wish = model.getWishByTitle(game.getTitle());
        if ( wish != null){
          //confirmation that the wish will be removed would be useful here
          model.removeWish(wish);
        }
        viewHandler.openView("gameList");
      }
    }
    catch (NumberFormatException e)
    {
      errorLabel.setText("Make sure to enter the owner using their ID.");
    }
    catch (NullPointerException e)
    {
      errorLabel.setText("No owner by that ID exists in the system.");
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
  }

  @Override public void init(ViewHandler viewHandler, BoardGamesModel model,
      Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    typeBox.getItems().addAll(ABSTRACT, DECK_BUILDING, CITY_BUILDING, DEDUCTION);
    typeBox.setValue(ABSTRACT);
    reset();
  }
}


