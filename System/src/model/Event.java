package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A class representing an event - game board organised event in VIA.
 * Is responsible for answering question : what event, when does it happen.
 *
 * @author Damian Trafiałek
 * @version 2.0 - 03 December 2021
 */
public class Event implements Serializable
{

  private String title, description, location;
  private LocalDateTime dateTime;
  private ArrayList<ClubAssociate> participants;
  public static final String CANTEEN = "Canteen";
  public static final String CLASSROOM = "C05.16b";
  public static final String ASK_BOB = "Bob will decide...";

  /**
   * Three-argument constructor.
   * Illegal title and dateTime value will throw the IllegalArgumentException.
   *
   * @throws IllegalArgumentException
   * @param title - the name of the event
   * @param description - the description of the event
   * @param dateTime - the date of the event (including starting hour)
   */
  public Event( String title, String description, LocalDateTime dateTime, String location){
    setTitle(title);
    setDescription(description);
    setDateTime(dateTime);
    setLocation(location);
    participants=new ArrayList<>();
  }

  /**
   * Methods that returns the events' title as a String
   *
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
   * A method that returns events' date.
   *
   * @return the localDateTime variable stroring the beginning of the event
   */
  public LocalDateTime getDateTime(){ return dateTime; }

  /**
   * Methods that converts LocalDateTime to readable String in a wanted patten - D/M/Y hh:mm
   *
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

  public ArrayList<ClubAssociate> getParticipants()
  {
    return participants;
  }

  public String getLocation() { return this.location; }

  public void setLocation(String location) {
    switch (location){
      case CANTEEN :
        this.location = CANTEEN;
        break;
      case CLASSROOM:
        this.location = CLASSROOM;
        break;
      default:
        this.location = ASK_BOB;
    }
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
  /**
   * A method that returns the string representation of the event
   *
   * @return the string representation of the event -> MyEvent | Description D/M/Y hh:mm
   *        
   */
  @Override public String toString(){
    return title + " | " + description + " | "
        + getStringDate();
  }
  public void addParticipant(ClubAssociate participant){
    for (int i=0;i< participants.size();i++){
      if(participant.getSchoolId()==participants.get(i).getSchoolId()){
        throw new IllegalStateException("Associate is already on participation list.");
      }
    }
    participants.add(participant);
  }

  /**
   * Comparing an object to the current one
   *
   * @param obj - the object that is to be compared to the current one
   * @return boolean depending on if the objects passed as a parameter has the same content as the current one
   */
  public boolean equals(Object obj){
    if(obj==null || !(obj instanceof Event) ) return false;
    Event other = (Event) obj;

    if( description == null )
      return title.equals(other.title) && dateTime.compareTo(other.dateTime)==0;
    return title.equals(other.title) && description.equals(other.description) && dateTime.compareTo(other.dateTime)==0;
  }
}
