package model;
import java.util.ArrayList;

private ArrayList <Game> games;

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
    for(int i=0; i<games.size();i++){
      if(title==games.get(i).getTitle()){
          games.remove(title);
          games.get(i)==null;
        for(int i: games){
          games[i]=games[i+1]; 
          }
         i++;
      }  
    }    
  }

  public ArrayList<Game> getAllGames(){ return games; }

  public Game getGameByTitle(String title){
   if(title!==null){
    for(int i=0; i<games.size();i++){
      if(title==games.get(i).getTitle()){
        return title;
      }
    return null;
    }
  }
}
