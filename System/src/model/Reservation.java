package model;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation
{
  private LocalDate dateFrom;
  private LocalDate dateTo;

  public Reservation(LocalDate dateFrom){
    setDateFrom(dateFrom);
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