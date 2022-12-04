package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that stores the events and manages them (addition, removal, getting).
 * 
 * 
 * @author Damian Trafiałek
 * @version 1.0 - 03 December 2022
 */
public class EventList implements Serializable
{
  private ArrayList<Event> events;

  /**
   * 0-argument constructor initializing the empty list of events.
   *
   */
  public EventList(){
    events = new ArrayList<>();
  }

  /**
   * A method that adds the event to the list.
   * 
   * @param event 
   *        event object that is to be added to the list.
   */
  public void addEvent(Event event){ events.add(event); }

  /**
   * A method that removes the event with the certain id.
   * 
   * @param title 
   *        the unique title of the event that is to be removed
   */
  public void removeEvent(String title){ events.removeIf(
      event -> event.getTitle().equals(title) // beacuse title cant be null for event
  );}

  /**
   * A method that returns the size of the event list
   *
   *
   * @return size
   *        the number of events in the list
   */
  public int getNumberOfEvents(){ return events.size(); }

  /**
   * A method that returns the list of all events.
   *
   * @return events
   *        the list of all events
   */
  public ArrayList<Event> getAllEvents(){ return events; }
  /**
   * A method that converts the list of all events to readable string value.
   * 
   *
   * @return string
   *        the string representation of the events in the list
   */
  @Override public String toString(){
    String ans="";
    for(Event event : events)
      ans+=event;
    return ans;
  }
}
