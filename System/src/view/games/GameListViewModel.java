package view.games;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.Game;
import view.event.EventViewModel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * GameListViewModel class is able to display GameViewModel objects in the listViewControllers
 * 
 * @author Jakub Cerovsky
 * @version 2.0 - 08 December 2022
 */
public class GameListViewModel implements Serializable
{
  /**
   *ObservableList is an ArrayList readable by JavaFX
   */
  private ObservableList<GameViewModel> list;
  private BoardGamesModel model;

  /**
   * 1-argument constructor.
   * constructor is creating an observableArrayList and keeps it updated after addition
   * 
   * @param model - BoardGamesModel
   *        
   */
  public GameListViewModel(BoardGamesModel model){
    this.model=model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  /**
   *Method that returns the list of GameViewModels
   *
   * @return list as a ObservableList of GameViewModels
   */
  public ObservableList<GameViewModel> getList(){
    return list;
  }

  /**
   * Method that clears the list when called and add games that has been created
   * 
   */
  public void update(){
    list.clear();
    ArrayList<Game> games = model.getAllGames();
    for(Game game : games)
      list.add(new GameViewModel(game));
  }

  /**
   * Method that adds a converted game into the ObservableList
   * 
   * @param game - Game
   */
  public void add(Game game){list.add(new GameViewModel(game));}

  /**
   * Method that removes the game from the list in case it matches the title
   * 
   * @param title - String
   *        
   */
  public void remove(String title){
    for(GameViewModel gvm : list)
      if( gvm.getTitleProperty().get().equals(title)){
        list.remove(gvm);
        break;
      }
  }
}
