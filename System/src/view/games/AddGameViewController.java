package view.games;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import model.Wish;
import view.ViewController;
import view.ViewHandler;
import model.Game;
import view.clubAssociate.ClubAssociateListViewModel;
import view.clubAssociate.ClubAssociateViewModel;

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
  @FXML private TableView<ClubAssociateViewModel> clubAssociatesListTable;
  @FXML private TableColumn<ClubAssociateViewModel, String> nameColumn;
  @FXML private TableColumn<ClubAssociateViewModel, Number> schoolIdColumn;
  private ClubAssociateListViewModel viewModel;
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

  private boolean validNumberOfPlayers(String value){
    return value.matches("[1-9]\\d*-[1-9]\\d*|[1-9]\\d*");
  }
  //submits game to game list. first checks that all fields are set. try-catch catches number formatting exceptions, fx.
  //if a name gets submitted in the owner field instead of an id.
  @FXML
  void submitGame() {
    try
    {
      String title = titleBox.getText();
      String players = playersBox.getText();
      ClubAssociateViewModel owner = clubAssociatesListTable.getSelectionModel().getSelectedItem();
      if (owner == null){
        throw new IllegalStateException("No owner selected.");
      }
      ClubAssociate clubAssociate = model.getClubAssociate(owner.getSchoolIdProperty().get());
      String description = descriptionBox.getText();
      //fetch selected value
      String type = typeBox.getValue();

      if (title.equals("") || !validNumberOfPlayers(players) || clubAssociate == null|| type == null)
        errorLabel.setText("Make sure all fields are filled before submission.");

      else
      {
        //ur still adding the game to the model even tho clubAssociate doesn't exist
        //that's because there's no validation for Game
        //and then there's the assumption that the clubAssociate is not null in one of the functions that return name of the owner like owner.getFullName() but owner is null
        //so "NullPointerException e" happens not because the clubAssociate by given id doesn't exist but because we have no validation in Game

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
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  /**
   * Method that resets all fields to default values.
   */
  @Override public void reset()
  {
    titleBox.setText("");
    playersBox.setText("");
    descriptionBox.setText("");
    errorLabel.setText("");
    viewModel.update();
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
  @Override public void init(ViewHandler viewHandler, BoardGamesModel model,
      Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    typeBox.getItems().addAll(ABSTRACT, DECK_BUILDING, CITY_BUILDING, DEDUCTION, CARDS);
    typeBox.setValue(ABSTRACT);
    this.viewModel = new ClubAssociateListViewModel(model);
    nameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    schoolIdColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSchoolIdProperty());

    clubAssociatesListTable.setItems(viewModel.getList());
    reset();
  }
}


