package model;

import java.io.Serializable;
import java.time.LocalDate;
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

  /**
   * Method that allows game info to be transferred between the gameList and gameDetails
   * controller
   * @param game the game in question
   */
  public void setSelectedGame(Game game) { selectedGame = game; }

  /**
   * Method that returns the average rating for a given game as a double
   * @param game the game to get the rating from
   * @return the double value of the average score
   */
  public double getAverageRating(Game game) { return gameList.getGameByTitle(game.getTitle()).calculateAverageRating();}

  /**
   * Method that removes expired events from the event list
   */
  public void removeExpiredEvents(){
    eventList.removeExpiredEvents();
  }
  /**
   * A method that calls the adds associate to the list for given event
   *
   * @param event
   *        the reservation that is to be added
   * @param associate
   *        the associate that is to be added as participant
   */
  public void addParticipantToEvent(Event event, ClubAssociate associate){
    event.addParticipant(associate);
    fileManager.exportModelToDatabase();
  }
  /**
   * Method that gets the selected game that was previously stored for the gameDetails
   * controller
   * @return the Game object to fetch info on
   */
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
   * A method that calls the gameList to edit the game and fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param selectedGame
   *        the game to be edited, rest of the parameter are being set into existing game
   */
  public void editGame(Game selectedGame,ClubAssociate owner ,String title,String description, String type,String numberOfPlayers){
    Game listGame = gameList.getGameByTitle(selectedGame.getTitle());
    if(listGame==null)return;
    listGame.setTitle(title);
    listGame.setDescription(description);
    listGame.setOwner(owner);
    listGame.setType(type);
    listGame.setNumberOfPlayers(numberOfPlayers);

    fileManager.exportModelToDatabase();
  }
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

  /**
   * Method that returns the number of reservations
   * @return the int value for the number of reservations
   */
  public int numberOfReservations(){return reservationList.getNumberOfReservations();}
  /**
   * A method that calls the reservationsList and returns the list of all reservations.
   *
   * @return reservations
   *        the list of all reservations
   */
  public ArrayList<Reservation> getAllReservation(){ return reservationList.getAllReservations(); }
  /**
   * A method that sets given game as borrowed with all information needed(who, when)
   *
   * @see BoardGamesFileManager
   * @param selectedGame
   *        the game that is to be modified
   * @param associate
   *        the associate that is to be set as person borrowing
   * @param date
   *        the date that is to be set
   */
  public void borrowGame(Game selectedGame, ClubAssociate associate, LocalDate date){
    selectedGame.setBorrowedTo(associate);
    selectedGame.setBorrowedFrom(date);

    fileManager.exportModelToDatabase();
  }
  /**
   * A method that adds the given rating value into given game and change its status into available.
   *
   * @see BoardGamesFileManager
   * @param selectedGame
   *        the game that is to be modified
   * @param ratingValue
   *        the rating that is to be added
   */
  public void returnGame(Game selectedGame, int ratingValue){
    if(ratingValue>=1 && ratingValue<=5)
      selectedGame.addRatings( new Rating(ratingValue) );

    selectedGame.setBorrowedTo(null);
    fileManager.exportModelToDatabase();
  }

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
   * A method that sets the given associate instance into member.
   *
   * @see BoardGamesFileManager
   * @param clubAssociate
   *        the associate that is to be modified
   */
  public void setClubAssociateAsMember(ClubAssociate clubAssociate){
    clubAssociate.setMember();
    fileManager.exportModelToDatabase();
  }
  /**
   * A method that sets the given associate instance into guest.
   *
   * @see BoardGamesFileManager
   * @param clubAssociate
   *        the associate that is to be modified
   */
  public void setClubAssociateAsGuest(ClubAssociate clubAssociate){
    clubAssociate.setGuest();
    fileManager.exportModelToDatabase();
  }

  /**
   * A method that calls eventList to add the and calls the fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param event 
   *        the event that is to be added
   */
  public void addEvent(Event event){ eventList.addEvent(event); fileManager.exportModelToDatabase(); }

  /**
   * Method that returns the Event object for a given title
   * @param title the String representation of the event in question
   * @return the Event object that has that title
   */
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

  /**
   * A method that sets given event into selectedEvent instance
   *
   * @param event
   *        the event that is to be initialised to the selectedEvent instance
   */
  public void setSelectedEvent(Event event) { selectedEvent = event; }
  /**
   * Method that gets the selected event from the event list controller
   *
   * @return the Event object to fetch info on
   */
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
  /**
   * A method that calls the eventList to edit the event and fileManager to save the model.
   *
   * @see BoardGamesFileManager
   * @param selectedEvent
   *        the event to be edited, rest of the parameter are being set into existing event
   */
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
