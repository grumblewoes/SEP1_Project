package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A class representing a reservation of a game made by club associate on specific date
 * Answers questions - Who reserved, which game and date, and if the reservation is equal to another
 * 
 * @author Jakub Cerovsky
 * @version 2.0 - 07 December 2022
 */
public class Reservation implements Serializable
{
  private Game game;
  private ClubAssociate associate;
  private LocalDate date;

  /**
   * 3-argument constructor 
   * Illegal date, game and associate will throw the IllegalArgumentException
   *
   * @throws IllegalArgumentException
   * @param game - game that is being reserved
   * @param associate - associate that is reserving the game
   * @param dateFrom - date of the reservation
   */
  public Reservation(Game game, ClubAssociate associate, LocalDate dateFrom){
    setDate(dateFrom);
    setGame(game);
    setAssociate(associate);
  }

  /**
   * Method that returns the id of associate, that created the reservation, as an Integer.
   *
   * @return the id of club associate
   */
  public int getAssociateId()
  {
    return associate.getSchoolId();
  }

  /**
   * Method that returns the title of game, that is reserved, as a String.
   *
   * @return the title of the game
   */
  public String getGameTitle()
  {
    return game.getTitle();
  }

  /**
   * Method that returns the Date of reservation as a LocalDate.
   *
   * @return the date of reservation
   */
  public LocalDate getDate()
  {
    return date;
  }

  /**
   * Method that sets a given date to the Reservation
   *
   * @throws IllegalArgumentException - in case that parameter is null or is in the past
   * @param date - LocalDate
   */
  public void setDate(LocalDate date)
  {
    if(date ==null || date.isBefore(LocalDate.now())) throw new IllegalArgumentException("Invalid date. The date cannot be in the past.");
    this.date = date;
  }
  /**
   * Method that sets a given game to the Reservation
   *
   * @throws IllegalArgumentException - in case that parameter is null
   * @param game - Game
   */
  public void setGame(Game game)
  {
    if(game==null){
      throw new IllegalArgumentException("Game has to be selected.");
    }
    this.game = game;
  }
  /**
   * Method that sets a given associate to the Reservation
   *
   * @throws IllegalArgumentException - in case that parameter is null
   * @param associate - ClubAssociate
   */
  public void setAssociate(ClubAssociate associate)
  {
    if(associate==null){
      throw new IllegalArgumentException("Associate has to be selected.");
    }
    this.associate = associate;
  }

  /**
   *  Method that returns a String representation of the reservation
   *
   * @return the string representation of the reservation and its all values (Club associate, Game , Date)
   */
  @Override public String toString()
  {
    return "Reservation{"+ "Club associate: " + associate + ", Game: " + game + ", Date: " + date
        +" }";
  }

  /**
   * Method that compares two object and returns whether they are the same or not
   * 
   * @param obj - the object that being compared
   * @return boolean - true or false depending on if the objects are same in each parameter
   *        
   */
  @Override public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
      return false;
    Reservation other = (Reservation) obj;
    return date.equals(other.date) && associate.equals(other.associate)&& game.equals(other.game);
  }
}