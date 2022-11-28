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

}
