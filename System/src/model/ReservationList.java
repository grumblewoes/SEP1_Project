package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a reservation list with all reservations made for all games
 * Answer questions - Is the game reserved, number of reservation
 * Purpose - adding and storing reservations for of the system
 *
 * @author Jakub Cerovsky
 * @version 2.0 - 07 December 2022
 */
public class ReservationList implements Serializable
{
  private ArrayList<Reservation> reservations;

  /**
   * 0-argument constructor 
   * 
   * creating a reservation list
   */
  public ReservationList(){
    this.reservations=new ArrayList<>();
  }

  /**
   * Method that adds a given reservation to the reservation list in case it passes all exceptions
   *
   * @throws IllegalStateException - in case that associate has already made the reservation with the same game and date
   * @throws IllegalStateException - in case that parameter is already on the list
   * @throws IllegalArgumentException - in case that parameter is already on the list
   * @param reservation - Reservation
   *        
   */
  public void addReservation(Reservation reservation){
    if(reservation!=null)
    {
      for (int i = 0; i < numberOfReservations(); i++)
      {
        if (reservation.equals(reservations.get(i)))
        {
          if(reservation.getAssociateId()==reservations.get(i).getAssociateId()){
            throw new IllegalStateException("Associate has already reserved this game for chosen date.");
          }
          throw new IllegalStateException(
              "Another person has already reserved this game for given date. Please pick a new date.");
        }
      }
      reservations.add(reservation);
    }
    else{
      throw new IllegalArgumentException("Select all information needed to finish the reservation... (Associate, Date)");
    }
  }
  /**
   * Method that check the whole reservation list and return true or false, whether the game is or is not reserved
   * 
   * @param game - Game
   * @return the status of the game, whether it is reserved or not
   *        
   */
  public boolean isReserved(Game game)
  {
    if(reservations.size()!=0)
    {
      for (int i = 0; i < reservations.size(); i++)
      {
        if (game.getTitle().equals(reservations.get(i).getGameTitle()))
        {
          return true;
        }
        return false;
      }
    }
    return false;
  }
  /**
   * Method returning the size of the reservation list as an Integer
   * @return the size of the reservation list
   */
  public int numberOfReservations(){
    return reservations.size();
  }
  /**
   * 
   * 
   */
  public void removeExpiredReservation(){
    // System version 3.0
  }
  /**
   * Method that returns all reservations as a list of Reservations
   *
   * @return all reservations
   */
  public ArrayList<Reservation> getAllReservations(){
    return reservations;
  }
  /**
   * Method that returns string value for each reservation on the list
   *
   * @return a string representation of the list
   */
  public String toString() {
    String text = "";
    for (Reservation reservation: reservations) {
      text += reservation;
    }
    return text;
  }

}