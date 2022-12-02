package model;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation
{
  private Game game;
  private ClubAssociate associate;
  private LocalDate dateFrom;
  private LocalDate dateTo;

  public Reservation(Game game, ClubAssociate associate, LocalDate dateFrom){
    setDateFrom(dateFrom);
    this.game=game;
    this.associate=associate;
  }

  public String getAssociateName()
  {
    return associate.getFullName();
  }

  public String getGameTitle()
  {
    return game.getTitle();
  }

  public LocalDate getDateFrom()
  {
    return dateFrom;
  }

  public LocalDate getDateTo()
  {
    return dateTo = dateFrom.plusDays(1);
  }

  public void setDateFrom(LocalDate dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  @Override public String toString()
  {
    return "Reservation{" + "dateFrom=" + dateFrom + ", dateTo=" + dateTo + '}';
  }

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