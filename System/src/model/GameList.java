package model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class GameList implements Serializable
{
  private ArrayList<Game> games;

  /**
   * 0-argument constructor 
   * 
   * 
   */
  public GameList() {
    games = new ArrayList<Game>();
  }

  /**
   * 
   * 
   * @param game 
   *        
   */
  public void addGame(Game game) {
    games.add(game);
  }

  /**
   * 
   * 
   * @param game 
   *        
   */
  public void removeGame(Game game){
          games.remove(game);
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Game> getAllGames(){ return games; }

  /**
   *
   * @return 
   *        
   */

  public Game getGameByTitle(String title){
   if(title!=null){
    for(int i=0; i<games.size();i++){
      if(title.equals(games.get(i).getTitle())){
        return games.get(i);
      }
    }
  }
    return null;
}
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String toString() {
    String txt = "";
    for (Game game : games) {
      txt = txt + game.toString() + "\n";
    }
    return txt;
  }
}
