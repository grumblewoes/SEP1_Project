package model;

import java.io.Serializable;
import java.util.ArrayList;

public class EventList implements Serializable
{
  private ArrayList<Event> events;

  public EventList(){
    events = new ArrayList<>();
  }

  public void addEvent(Event event){ events.add(event); }

  public void removeEvent(String title){ events.removeIf(
      event -> event.getTitle().equals(title) // beacuse title cant be null for event
  );}

  public int getNumberOfEvents(){ return events.size(); }

  public ArrayList<Event> getAllEvents(){ return events; }
  @Override public String toString(){
    String ans="";
    for(Event event : events)
      ans+=event;
    return ans;
  }
}
