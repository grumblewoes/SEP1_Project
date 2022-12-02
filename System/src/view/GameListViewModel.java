package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.Game;

import java.util.ArrayList;

public class GameListViewModel
{
  private ObservableList<GameViewModel> list;
  private BoardGamesModel model;

  public GameListViewModel(BoardGamesModel model){
    this.model=model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public ObservableList<GameViewModel> getList(){
    return list;
  }
  public void update(){
    list.clear();
    ArrayList<Game> games = model.getAllGames();
    for(Game game : games)
      list.add(new GameViewModel(game));
  }
  public void add(Game game){list.add(new GameViewModel(game));}
  public void remove(Game game){list.remove(game);}
}
