package model;

import java.util.ArrayList;

public class BoardGamesModelManager implements BoardGamesModel
{
  private WishList wishList;
  private GameList gameList;
  private ReservationList reservationList;
  private ClubAssociateList clubAssociateList;
  private EventList eventList;

  public BoardGamesModelManager(){
    wishList = new WishList();
    gameList = new GameList();
    reservationList = new ReservationList();
    clubAssociateList = new ClubAssociateList();
    eventList = new EventList();
  }

  public void addWish(Wish wish){ wishList.addWish(wish); }

  public void voteForWish(String title){ wishList.getVotesForWish(title); }

  public Wish getWishByTitle(String title){ return wishList.getWishByTitle(title); }

  public ArrayList<Wish> getAllWishes(){ return wishList.getAllWishes(); }

  public void addGame(Game game){ gameList.addGame(game); }

  public void removeGame(Game game){ gameList.removeGame(game); }

  public ArrayList<Game> getAllGames(){ return gameList.getAllGames(); }

  public Game getGameByTitle(String title){ return gameList.getGameByTitle(title); }

  public void addReservation(Reservation reservation){ reservationList.addReservation(reservation); }

  public void removeExpiredReservations(){ reservationList.removeExpiredReservation(); }
  public boolean isReserved(Game game){return reservationList.isReserved(game);}

  public ArrayList<Reservation> getAllReservation(){ return reservationList.getAllReservation(); }

  public void addClubAssociate(ClubAssociate associate){ clubAssociateList.addClubAssociate( associate ); }

  public void updateClubAssociate(int id){ clubAssociateList.updateClubAssociate(id); }

  public ClubAssociate getClubAssociate(int id){ return clubAssociateList.getClubAssociate(id); }

  public ArrayList<ClubAssociate> getAllClubAssociates(){ return clubAssociateList.getAllClubAssociates(); }

  public void addEvent(Event event){ eventList.addEvent(event); }

  public void removeEvent(String title){ eventList.removeEvent(title); }

  public ArrayList<Event> getAllEvents(){ return eventList.getAllEvents(); }

  public int getNumberOfEvents(){ return eventList.getNumberOfEvents(); }
}
