package model;

import java.util.ArrayList;

public class ReservationList
{
  private ArrayList<Reservation> reservations;

  public ReservationList(){
    this.reservations=new ArrayList<>();
  }

  public void addReservation(Reservation reservation){
    reservations.add(reservation);
  }

  public void removeExpiredReservation(){
    // System version 2.0
  }
  public ArrayList<Reservation> getAllReservation(){
    return reservations;
  }

}