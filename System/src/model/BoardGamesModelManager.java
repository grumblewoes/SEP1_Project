package model;

import java.io.Serializable;
import java.util.ArrayList;

public class BoardGamesModelManager implements BoardGamesModel, Serializable
{
  private WishList wishList;
  private GameList gameList;
  private ReservationList reservationList;
  private ClubAssociateList clubAssociateList;
  private EventList eventList;
  private BoardGamesFile fileManager;

  public BoardGamesModelManager(){
    wishList = new WishList();
    gameList = new GameList();
    reservationList = new ReservationList();
    clubAssociateList = new ClubAssociateList();
    eventList = new EventList();
    fileManager = new BoardGamesFile(this);
  }

  public BoardGamesFile getFileManager(){ return fileManager; }

  public void addWish(Wish wish){ wishList.addWish(wish); fileManager.exportModelToDatabase(); }

  public void voteForWish(Wish wish){ wishList.voteForWish(wish); fileManager.exportModelToDatabase();}
  public int getVotesForWish(String title){ return wishList.getVotesForWish(title); }

  public Wish getWishByTitle(String title){ return wishList.getWishByTitle(title); }

  public ArrayList<Wish> getAllWishes(){ return wishList.getAllWishes(); }

  public void addGame(Game game){ gameList.addGame(game);fileManager.exportModelToDatabase(); }

  public void removeGame(Game game){ gameList.removeGame(game); fileManager.exportModelToDatabase(); }

  public ArrayList<Game> getAllGames(){ return gameList.getAllGames(); }

  public Game getGameByTitle(String title){ return gameList.getGameByTitle(title); }

  public void addReservation(Reservation reservation){ reservationList.addReservation(reservation); fileManager.exportModelToDatabase(); }

  public void removeExpiredReservations(){ reservationList.removeExpiredReservation(); fileManager.exportModelToDatabase(); }
  public boolean isReserved(Game game){return reservationList.isReserved(game);}

  public ArrayList<Reservation> getAllReservation(){ return reservationList.getAllReservation(); }

  public void addClubAssociate(ClubAssociate associate){ clubAssociateList.addClubAssociate(associate); fileManager.exportModelToDatabase(); }

  public void updateClubAssociate(int id){ clubAssociateList.updateClubAssociate(id); fileManager.exportModelToDatabase(); }

  public ClubAssociate getClubAssociate(int id){ return clubAssociateList.getClubAssociate(id); }

  public ArrayList<ClubAssociate> getAllClubAssociates(){ return clubAssociateList.getAllClubAssociates(); }

  public void addEvent(Event event){ eventList.addEvent(event); fileManager.exportModelToDatabase(); }

  public void removeEvent(String title){ eventList.removeEvent(title); fileManager.exportModelToDatabase(); }

  public ArrayList<Event> getAllEvents(){ return eventList.getAllEvents(); }

  public int getNumberOfEvents(){ return eventList.getNumberOfEvents(); }

}
