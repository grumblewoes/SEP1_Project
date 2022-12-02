package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Event implements Serializable
{
  private String title, description;
  private LocalDateTime dateTime;

  public Event( String title, String description, LocalDateTime dateTime){
    setTitle(title);
    setDescription(description);

    //validation fro date ne null?
    this.dateTime = dateTime;
  }

  public String getTitle(){ return title; }

  public String getDescription(){ return description; }

  public String getStringDate(){
    return
      dateTime.getDayOfMonth()+"/"+
      + dateTime.getMonthValue()+"/"+
      + dateTime.getYear()+" "
      + dateTime.getHour()+":"+
      + dateTime.getMinute();
  }
  public void setTitle(String title){ this.title = title; }
  //some validation later? no null or empty string

  public void setDescription(String description){ this.description = description; }
  //lets say that description can be empty or null
  @Override public String toString(){
    return title + " | " + description + " | "
        + getStringDate();
  }

  public boolean equals(Object obj){
    if(obj==null || !(obj instanceof Event) ) return false;
    Event other = (Event) obj;

    if( description == null )
      return title.equals(other.title) && dateTime.compareTo(other.dateTime)==0;
    return title.equals(other.title) && description.equals(other.description) && dateTime.compareTo(other.dateTime)==0;


  }
}
