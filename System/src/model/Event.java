package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A class representing an event - game board organised event in VIA.
 * Is responsible for answering question : what event, when does it happen.
 *
 * @author Damian Trafiałek
 * @version 1.0 - 02.12.2021
 */
public class Event implements Serializable
{

  private String title, description;
  private LocalDateTime dateTime;

  /**
   * Three-argument constructor.
   * Illegal title and dateTime value will throw the IllegalArgumentException.
   *
   * @throws IllegalArgumentException
   * @param title - the name of the event
   * @param description - the description of the event
   * @param dateTime - the date of the event (including starting hour)
   */
  public Event( String title, String description, LocalDateTime dateTime){
    setTitle(title);
    setDescription(description);
    setDateTime(dateTime);
  }

  /**
   *  Methods that returns the events' title as a String
   * @return the title of the event
   */
  public String getTitle(){ return title; }

  /**
   * Methods that returns the events' description as a String
   *
   * @return the event description
   */
  public String getDescription(){ return description; }

  /**
   *  Methods that converts LocalDateTime to readable String in a wanted patten - D/M/Y hh:mm
   * @return the date as a readable string
   */
  public String getStringDate(){
    String hourString = "0"+dateTime.getHour();
    String minuteString = "0"+dateTime.getMinute();
    return
      dateTime.getDayOfMonth()+"/"
      + dateTime.getMonthValue()+"/"
      + dateTime.getYear()+" "
      + hourString.substring( hourString.length()-2 )+":"
      + minuteString.substring( minuteString.length()-2);
  }
  private void setDateTime(LocalDateTime dateTime) {
    if(dateTime==null || dateTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("Invalid date. The date cannot be in the past.");
    this.dateTime=dateTime;
  }
  private void setTitle(String title){
    if(title==null || title.equals(""))
      throw new IllegalStateException("Title cannot be left blank!");

    this.title = title;
  }

  private void setDescription(String description){ this.description = description; }
  @Override public String toString(){
    return title + " | " + description + " | "
        + getStringDate();
  }

  /**
   * Comparing an object to the current one
   *
   * @param obj - the object that is to be compared to the current one
   * @return true/false depending on if the objects passed as a parameter has the same content as the current one
   */
  public boolean equals(Object obj){
    if(obj==null || !(obj instanceof Event) ) return false;
    Event other = (Event) obj;

    if( description == null )
      return title.equals(other.title) && dateTime.compareTo(other.dateTime)==0;
    return title.equals(other.title) && description.equals(other.description) && dateTime.compareTo(other.dateTime)==0;
  }
}
