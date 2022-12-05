package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable
{
  private ArrayList<Reservation> reservations;

  public ReservationList(){
    this.reservations=new ArrayList<>();
  }

  public void addReservation(Reservation reservation){
    if(reservation!=null)
    {
      for (int i = 0; i < reservations.size(); i++)
      {
        if (reservation.equals(reservations.get(i)))
        {
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
  public void removeExpiredReservation(){
    // System version 2.0
  }
  public ArrayList<Reservation> getAllReservation(){
    return reservations;
  }
  public String toString() {
    String text = "";
    for (Reservation reservation: reservations) {
      text += reservation;
    }
    return text;
  }

}