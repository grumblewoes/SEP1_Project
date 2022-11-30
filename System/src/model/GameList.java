package model;
import java.util.ArrayList;

public class GameList
{
  private ArrayList<Game> games;

  public GameList() {
    games = new ArrayList<Game>();
  }

  public void addGame(Game game) {
    games.add(game);
  }

  public void removeGame(Game game){
          games.remove(game);
  }

  public ArrayList<Game> getAllGames(){ return games; }

  public Game getGameByTitle(String title){
   if(title!=null){
    for(int i=0; i<games.size();i++){
      if(title==games.get(i).getTitle()){
        return games.get(i);
      }
    }
  }
    return null;
}
  public String toString() {
    String txt = "";
    for (Game game : games) {
      txt = txt + game.toString() + "\n";
    }
    return txt;
  }
}
