package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * An interface used as a connection between the view and model of the system
 * To see JavaDocs for these methods, go to BoardGamesModelManager, where all methods are implemented
 *
 * @author Jakub Cerovsky
 * @version 2.0 - 08 December 2022
 */
public interface BoardGamesModel
{
  public void addWish(Wish wish);
  public void removeWish(Wish wish);
  public void voteForWish(Wish wish);
  public int getVotesForWish(String title);
  public Wish getWishByTitle(String title);
  public ArrayList<Wish> getAllWishes();
  public void addGame(Game game);
  public void removeGame(Game game);
  public void editGame(Game selectedGame,ClubAssociate owner ,String title,String description, String type,String numberOfPlayers);
  public ArrayList<Game> getAllGames();
  public Game getGameByTitle(String title);
  public void setSelectedGame(Game game);
  public double getAverageRating(Game game);
  public Game getSelectedGame();
  public void setSelectedEvent(Event event);
  public Event getSelectedEvent();
  public void addReservation(Reservation reservation);
  public void removeExpiredReservations();
  public boolean isReserved(Game game);
   public int numberOfReservations();
  public ArrayList<Reservation> getAllReservation();
  public void addClubAssociate(ClubAssociate associate);
  public void updateClubAssociate(int id);
  public ClubAssociate getClubAssociate(int id);
  public ArrayList<ClubAssociate> getAllClubAssociates();
  public void addEvent(Event event);
  public void removeEvent(String title);
  public void editEvent(Event selectedEvent,String title,String description, LocalDateTime dateTime,String location);
  public Event getEventByTitle(String title);
  public int getNumberOfEvents();
  public ArrayList<Event> getAllEvents();
  public BoardGamesFileManager getFileManager();
  public void removeExpiredEvents();
  public void addParticipantToEvent(Event event, ClubAssociate associate);
  public void borrowGame(Game selectedGame, ClubAssociate associate, LocalDate now);
  public void returnGame(Game selectedGame, int ratingValue);
  public void setClubAssociateAsMember(ClubAssociate clubAssociate);
  public void setClubAssociateAsGuest(ClubAssociate clubAssociate);
}
