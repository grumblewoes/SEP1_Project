package view.games;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.Game;
import view.event.EventViewModel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class GameListViewModel implements Serializable
{
  private ObservableList<GameViewModel> list;
  private BoardGamesModel model;

  /**
   * 1-argument constructor 
   * 
   * 
   * @param model 
   *        
   */
  public GameListViewModel(BoardGamesModel model){
    this.model=model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ObservableList<GameViewModel> getList(){
    return list;
  }
  /**
   * 
   * 
   */
  public void update(){
    list.clear();
    ArrayList<Game> games = model.getAllGames();
    for(Game game : games)
      list.add(new GameViewModel(game));
  }
  /**
   * 
   * 
   * @param game 
   *        
   */
  public void add(Game game){list.add(new GameViewModel(game));}
  /**
   * 
   * 
   * @param game
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
