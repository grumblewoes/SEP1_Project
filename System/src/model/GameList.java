package model;
import java.util.ArrayList;

//
public class GameList
{
  private ArrayList<Game> games;

  public GameList() {
    games = new ArrayList<Game>();
  }

  public void addGame(Game g) {
    games.add(g);
  }

  public String toString() {
    String txt = "";
    for (Game game : games) {
      txt = txt + game.toString() + "\n";
    }
    return txt;
  }

  public void removeGame(String title){
    //to be changed
  }

  public ArrayList<Game> getAllGames(){ return games; }

  public Game getGameByTitle(String title){
    //to be changed
    return null;
  }

}
