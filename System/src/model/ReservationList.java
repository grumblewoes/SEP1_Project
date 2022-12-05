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
    reservations.add(reservation);
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