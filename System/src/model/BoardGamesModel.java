package model;

import java.io.Serializable;
import java.util.ArrayList;


public interface BoardGamesModel
{

  public void addWish(Wish wish);

  public void voteForWish(Wish wish);

  public int getVotesForWish(String title);

  public Wish getWishByTitle(String title);
  public ArrayList<Wish> getAllWishes();

  public void addGame(Game game);

  public void removeGame(Game game);
  public ArrayList<Game> getAllGames();

  public Game getGameByTitle(String title);

  public void addReservation(Reservation reservation);

  public void removeExpiredReservations();

  public boolean isReserved(Game game);
  public ArrayList<Reservation> getAllReservation();

  public void addClubAssociate(ClubAssociate associate);

  public void updateClubAssociate(int id);

  public ClubAssociate getClubAssociate(int id);
  public ArrayList<ClubAssociate> getAllClubAssociates();

  public void addEvent(Event event);

  public void removeEvent(String title);

  public int getNumberOfEvents();
  public ArrayList<Event> getAllEvents();

  public BoardGamesFile getFileManager();
}
