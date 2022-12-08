package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A class implementing the BoardGamesModel interface
 * 
 * 
 * @author Damian Trafiałek
 * @version 2.0 - 03 December 2022
 */
public class BoardGamesModelManager implements BoardGamesModel, Serializable
{
  private WishList wishList;
  private GameList gameList;

  private Game selectedGame;

  private Event selectedEvent;
  private ReservationList reservationList;
  private ClubAssociateList clubAssociateList;
  private EventList eventList;
  private BoardGamesFileManager fileManager;

  /**
   * 0-argument constructor that sets up the entire boardGamesModel.
   * 
   */
  public BoardGamesModelManager(){
    wishList = new WishList();
    gameList = new GameList();
    reservationList = new ReservationList();
    clubAssociateList = new ClubAssociateList();
    eventList = new EventList();
    fileManager = new BoardGamesFileManager(this);
    selectedGame=null;
    selectedEvent=null;
  }

  /**
   * A method that returns fileManager - class that manages the usage of local files.
   *
   * @return fileManager
   *        the boardGamesFile instance that imports/exports current model and sets xml file
   */
  public BoardGamesFileManager getFileManager(){ return fileManager; }

  /**
   * A method that calls the wishList to add the wish and the fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param wish 
   *        wish to be added
   */
  public void addWish(Wish wish){ wishList.addWish(wish); fileManager.exportModelToDatabase(); }

  /**
   * A method that calls wishList to vote for the wish and calls the fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param wish
   *        wish that is to be voted for
   */

  public void removeWish(Wish wish) { wishList.removeWish(wish); fileManager.exportModelToDatabase(); }
  /**
   * A method that calls wishList to remove the wish and calls the fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param wish
   *        wish that is to be removed
   */
  public void voteForWish(Wish wish){ wishList.voteForWish(wish); fileManager.exportModelToDatabase();}
  /**
   * A method calls the wishList asking for the number of votes that the wish of a certain title have and fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param title
   *        the string value by which the wish is to be found
   *
   * @return numberOfVotes
   *        the number of votes that the wish of a given title has or -1 if the wish doesn't exist
   */
  public int getVotesForWish(String title){ return wishList.getVotesForWish(title); }

  /**
   * A method that calls the wishList asking for the wish of a certain title.
   * 
   * @param title 
   *        the string value by which the wish is to be found
   *
   * @return wish
   *        the wish which title matches with the query or null
   */
  public Wish getWishByTitle(String title){ return wishList.getWishByTitle(title); }

  /**
   * A method that calls wishList asking for the list of all wishes.
   *
   * @return wishes
   *        the list of all wishes
   */
  public ArrayList<Wish> getAllWishes(){ return wishList.getAllWishes(); }

  /**
   * A method that calls gameList to add a game and fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param game 
   *        game to be added
   */
  public void addGame(Game game){ gameList.addGame(game);fileManager.exportModelToDatabase(); }

  public void setSelectedGame(Game game) { selectedGame = game; }

  public double getAverageRating(Game game) { return gameList.getGameByTitle(game.getTitle()).calculateAverageRating();}

  public void removeExpiredEvents(){
    eventList.removeExpiredEvents();
  }
  public Game getSelectedGame() { return selectedGame; }
  /**
   * A method that calls the gameList to remove the games and fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param game 
   *        game to be removed
   */
  public void removeGame(Game game){ gameList.removeGame(game); fileManager.exportModelToDatabase(); }

  /**
   * A method that returns the list of all games.
   *
   * @return games
   *        the list of all games in the model
   */
  public ArrayList<Game> getAllGames(){ return gameList.getAllGames(); }

  /**
   * A method that calls the gameList asking for the game of a certain title.
   * 
   * @param title 
   *        the string value by which the game is to be found
   *
   * @return game
   *        the Game instance that matches the query or null
   */
  public Game getGameByTitle(String title){ return gameList.getGameByTitle(title); }

  /**
   * A method that calls the reservationsList to add the reservation and fileManager to save the model.
   * 
   * @param reservation 
   *        the reservation that is to be added
   */
  public void addReservation(Reservation reservation){ reservationList.addReservation(reservation); fileManager.exportModelToDatabase(); }

  /**
   * A method that calls reservationsList to remove all expired reservations - the ones which date is in the past in comparison to the current date
   *
   */
  public void removeExpiredReservations(){ reservationList.removeExpiredReservation(); fileManager.exportModelToDatabase(); }
  /**
   * A method checking if the given game is reserved
   * 
   * @param game 
   *        the game that is to be checked if is reserved
   *
   * @return boolean
   *        true or false that indicates if the games is reserved
   */
  public boolean isReserved(Game game){return reservationList.isReserved(game);}
  public int numberOfReservations(){return reservationList.numberOfReservations();}
  /**
   * A method that calls the reservationsList and returns the list of all reservations.
   *
   * @return reservations
   *        the list of all reservations
   */
  public ArrayList<Reservation> getAllReservation(){ return reservationList.getAllReservations(); }

  /**
   * A method that calls clubAssociateList to add the associate to the list and fileManager to save the model.
   * 
   * @param associate 
   *        a new associate that is to be added to the clubAssociateList
   */
  public void addClubAssociate(ClubAssociate associate){ clubAssociateList.addClubAssociate(associate); fileManager.exportModelToDatabase(); }

  /**
   * A method that calls the clubAssociateList to toggle the membership status of an associate with the given id.
   * 
   * @param id
   *        the unique id of the associate whose status is to be toggled
   */
  public void updateClubAssociate(int id){ clubAssociateList.updateClubAssociate(id); fileManager.exportModelToDatabase(); }

  /**
   * A method that calls clubAssociateList and gets the associate.
   * 
   * @param id 
   *        the unique id of the associate that is to be returned
   *
   * @return associate
   *        the instance of the clubAssociate with the id that matches the query or null
   */
  public ClubAssociate getClubAssociate(int id){ return clubAssociateList.getClubAssociate(id); }

  /**
   * A method that calls the clubAssociateList and asks for all associates.
   *
   * @return clubAssociates
   *        the list of all club associates
   */
  public ArrayList<ClubAssociate> getAllClubAssociates(){ return clubAssociateList.getAllClubAssociates(); }

  /**
   * A method that calls eventList to add the and calls the fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param event 
   *        the event that is to be added
   */
  public void addEvent(Event event){ eventList.addEvent(event); fileManager.exportModelToDatabase(); }


  public Event getEventByTitle(String title){
    return eventList.getEventByTitle(title);
  }
  /**
   * A method that calls the eventList to remove the event and fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param title 
   *        the unique title of the event that is to be removed
   */
  public void removeEvent(String title){ eventList.removeEvent(title); fileManager.exportModelToDatabase(); }


  public void setSelectedEvent(Event event) { selectedEvent = event; }

  public Event getSelectedEvent() { return selectedEvent; }

  /**
   * A method that calls eventList to return a list of all events.
   *
   * @return events
   *        list of all events
   */
  public ArrayList<Event> getAllEvents(){ return eventList.getAllEvents(); }

  /**
   * A method that calls the eventList asking for its size.
   *
   * @return numberOfEvents
   *        the size of the eventList
   */
  public int getNumberOfEvents(){ return eventList.getNumberOfEvents(); }

  public void editEvent(Event selectedEvent,String title,String description, LocalDateTime dateTime,String location){
    Event listEvent = eventList.getEventByTitle(selectedEvent.getTitle());
    if(listEvent==null)return;
    listEvent.setTitle(title);
    listEvent.setDescription(description);
    listEvent.setDateTime(dateTime);
    listEvent.setLocation(location);

    fileManager.exportModelToDatabase();
  }

}
