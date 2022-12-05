package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class Reservation implements Serializable
{
  private Game game;
  private ClubAssociate associate;
  private LocalDate dateFrom;
  private LocalDate dateTo;

  /**
   * 3-argument constructor 
   * 
   * 
   * @param game 
   *        
   * @param associate 
   *        
   * @param dateFrom 
   *        
   */
  public Reservation(Game game, ClubAssociate associate, LocalDate dateFrom){
    setDateFrom(dateFrom);
    this.game=game;
    this.associate=associate;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getAssociateName()
  {
    return associate.getFullName();
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getGameTitle()
  {
    return game.getTitle();
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public LocalDate getDateFrom()
  {
    return dateFrom;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public LocalDate getDateTo()
  {
    return dateTo = dateFrom.plusDays(1);
  }

  /**
   * 
   * 
   * @param dateFrom 
   *        
   */
  public void setDateFrom(LocalDate dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  @Override public String toString()
  {
    return "Reservation{" + "dateFrom=" + dateFrom + ", dateTo=" + dateTo + '}';
  }

  /**
   * 
   * 
   * @param o 
   *        
   *
   * @return 
   *        
   */
  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Reservation that = (Reservation) o;
    return Objects.equals(dateFrom, that.dateFrom);
  }
}