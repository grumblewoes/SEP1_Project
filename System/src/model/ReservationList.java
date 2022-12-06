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
public class ReservationList implements Serializable
{
  private ArrayList<Reservation> reservations;

  /**
   * 0-argument constructor 
   * 
   * 
   */
  public ReservationList(){
    this.reservations=new ArrayList<>();
  }

  /**
   * 
   * 
   * @param reservation 
   *        
   */
  public void addReservation(Reservation reservation){
    if(reservation!=null)
    {
      for (int i = 0; i < reservations.size(); i++)
      {
        if (reservation.equals(reservations.get(i)))
        {
          if(reservation.getAssociateName().equals(reservations.get(i).getAssociateName())){
            throw new IllegalStateException("Associate has already reserved this game for chosen date.");
          }
          throw new IllegalStateException(
              "Another person has already reserved this game for given date.\nPlease pick a new date.");
        }
      }
      reservations.add(reservation);
    }
    else{
      throw new IllegalArgumentException("Select all information needed to finish the reservation... (Associate, Date)");
    }
  }
  /**
   * 
   * 
   * @param game 
   *        
   *
   * @return 
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
   * 
   * 
   */
  public void removeExpiredReservation(){
    // System version 2.0
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Reservation> getAllReservation(){
    return reservations;
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String toString() {
    String text = "";
    for (Reservation reservation: reservations) {
      text += reservation;
    }
    return text;
  }

}