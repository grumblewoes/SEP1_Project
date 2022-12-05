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
public interface BoardGamesModel
{

  /**
   * 
   * 
   * @param wish 
   *        
   */
  public void addWish(Wish wish);

  /**
   * 
   * 
   * @param wish 
   *        
   */
  public void removeWish(Wish wish);

  /**
   * 
   * 
   * @param wish 
   *        
   */
  public void voteForWish(Wish wish);

  /**
   * 
   * 
   * @param title 
   *        
   *
   * @return 
   *        
   */
  public int getVotesForWish(String title);

  /**
   * 
   * 
   * @param title 
   *        
   *
   * @return 
   *        
   */
  public Wish getWishByTitle(String title);
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Wish> getAllWishes();

  /**
   * 
   * 
   * @param game 
   *        
   */
  public void addGame(Game game);

  /**
   * 
   * 
   * @param game 
   *        
   */
  public void removeGame(Game game);
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Game> getAllGames();

  /**
   * 
   * 
   * @param title 
   *        
   *
   * @return 
   *        
   */
  public Game getGameByTitle(String title);

  public void setSelectedGame(Game game);

  public Game getSelectedGame();

  /**
   * 
   * 
   * @param reservation 
   *        
   */
  public void addReservation(Reservation reservation);

  /**
   * 
   * 
   */
  public void removeExpiredReservations();

  /**
   * 
   * 
   * @param game 
   *        
   *
   * @return 
   *        
   */
  public boolean isReserved(Game game);
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Reservation> getAllReservation();

  /**
   * 
   * 
   * @param associate 
   *        
   */
  public void addClubAssociate(ClubAssociate associate);

  /**
   * 
   * 
   * @param id 
   *        
   */
  public void updateClubAssociate(int id);

  /**
   * 
   * 
   * @param id 
   *        
   *
   * @return 
   *        
   */
  public ClubAssociate getClubAssociate(int id);
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<ClubAssociate> getAllClubAssociates();

  /**
   * 
   * 
   * @param event 
   *        
   */
  public void addEvent(Event event);

  /**
   * 
   * 
   * @param title 
   *        
   */
  public void removeEvent(String title);

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public int getNumberOfEvents();
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Event> getAllEvents();

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public BoardGamesFile getFileManager();
}
