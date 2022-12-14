package view.event;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Event;
import model.Game;

import java.io.Serializable;

/**
 * A class that converts the event from model to the one that can be used from GUI.
 * 
 * 
 * @author Damian Trafiałek
 * @version 1.0 - 03 December 2022
 */
public class EventViewModel implements Serializable
{
  private Event event;
  private StringProperty
      titleProperty,
      descriptionProperty,
      dateProperty,
      locationProperty;
private IntegerProperty participantsProperty;
  /**
   * 1-argument constructor that sets up the eventViewModel based on the Event.
   * It converts the event to the structure that is understood by GUI.
   *
   * @param event 
   *        the instance of the Event that is to be converted
   */
  public EventViewModel(Event event){
    this.event=event;
      titleProperty = new SimpleStringProperty(event.getTitle());
    descriptionProperty = new SimpleStringProperty(event.getDescription());
    dateProperty = new SimpleStringProperty(event.getStringDate());
    locationProperty=new SimpleStringProperty(event.getLocation());
    participantsProperty=new SimpleIntegerProperty(event.getNumberOfParticipants());
  }
  /**
   * 
   * Method that returns the event that is being converted as Event type
   *
   * @return event that is being converted
   *        
   */
  public Event getEvent(){
    return event;
  }
  /**
   * A method that returns the title property.
   * 
   *
   * @return titleProperty
   *        the simpleStringProperty of the eventViewModel title
   */
  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  /**
   * A method that returns the description property.
   *
   *
   * @return descriptionProperty
   *        the simpleStringProperty of the eventViewModel description
   */
  public StringProperty getDescriptionProperty(){ return descriptionProperty; }

  /**
   * A method that returns the date property.
   *
   *
   * @return dateProperty
   *        the simpleStringProperty of the eventViewModel date
   */
  public StringProperty getDateProperty()
  {
    return dateProperty;
  }
  /**
   * A method that returns the location property.
   *
   *
   * @return locationProperty
   *        the simpleStringProperty of the eventViewModel location
   */

  public StringProperty getLocationProperty()
  {
    return locationProperty;
  }
  /**
   * A method that returns the participants' property.
   *
   *
   * @return participantsProperty
   *        the simpleIntegerProperty of the eventViewModel participants
   */


  public IntegerProperty getParticipantsProperty()
  {
    return participantsProperty;
  }
}
