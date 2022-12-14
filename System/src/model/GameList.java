package model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * A class that stores the games and manages them (addition, removal, getting).
 * 
 * @author ????
 * @version ???????
 */
public class GameList implements Serializable
{
  private ArrayList<Game> games;

  /**
   * 0-argument constructor initializing the empty list of games.
   *
   */
  public GameList() {
    games = new ArrayList<Game>();
  }

  /**
   * A method that adds the game to the list.
   *
   * @param game
   *        game object that is to be added to the list.
   */
  public void addGame(Game game) {
    games.add(game);
  }

  /**
   * A method that removes the game to the list.
   * 
   * @param game 
   *        game object that is to be removed from the list
   */
  public void removeGame(Game game){
          games.remove(game);
  }

  /**
   * A method that returns the list of all games.
   *
   * @return games
   *        the list of all games
   */
  public ArrayList<Game> getAllGames(){ return games; }

  /**
   *
   * Method that returns the game with the given title
   * @param title
   * @return game with the given title
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
   * A method that converts the list of all games to readable string value.
   *
   *
   * @return string
   *        the string representation of the games in the list
   */
  public String toString() {
    String txt = "";
    for (Game game : games) {
      txt = txt + game.toString() + "\n";
    }
    return txt;
  }
}
