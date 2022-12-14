package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * An interface used as a connection between the view and model of the system
 * 
 * @author Jakub Cerovsky
 * @version 2.0 - 08 December 2022
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
   * @param selectedGame 
   *        
   * @param owner 
   *        
   * @param title 
   *        
   * @param description 
   *        
   * @param type 
   *        
   * @param numberOfPlayers 
   *        
   */
  public void editGame(Game selectedGame,ClubAssociate owner ,String title,String description, String type,String numberOfPlayers);

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

  /**
   * 
   * 
   * @param game 
   *        
   */
  public void setSelectedGame(Game game);

  /**
   * 
   * 
   * @param game 
   *        
   *
   * @return 
   *        
   */
  public double getAverageRating(Game game);

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public Game getSelectedGame();

  /**
   * 
   * 
   * @param event 
   *        
   */
  public void setSelectedEvent(Event event);

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public Event getSelectedEvent();

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
  public int numberOfReservations();

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
   * @param selectedEvent 
   *        
   * @param title 
   *        
   * @param description 
   *        
   * @param dateTime 
   *        
   * @param location 
   *        
   */
  public void editEvent(Event selectedEvent,String title,String description, LocalDateTime dateTime,String location);

  /**
   * 
   * 
   * @param title 
   *        
   *
   * @return 
   *        
   */
  public Event getEventByTitle(String title);

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
  public BoardGamesFileManager getFileManager();

  /**
   * 
   * 
   */
  public void removeExpiredEvents();
  /**
   * 
   * 
   * @param event 
   *        
   * @param associate 
   *        
   */
  public void addParticipantToEvent(Event event, ClubAssociate associate);
  /**
   * 
   * 
   * @param selectedGame 
   *        
   * @param associate 
   *        
   * @param now 
   *        
   */
  public void borrowGame(Game selectedGame, ClubAssociate associate, LocalDate now);
  /**
   * 
   * 
   * @param selectedGame 
   *        
   * @param ratingValue 
   *        
   */
  public void returnGame(Game selectedGame, int ratingValue);
  /**
   * 
   * 
   * @param clubAssociate 
   *        
   */
  public void setClubAssociateAsMember(ClubAssociate clubAssociate);
  /**
   * 
   * 
   * @param clubAssociate 
   *        
   */
  public void setClubAssociateAsGuest(ClubAssociate clubAssociate);
}
