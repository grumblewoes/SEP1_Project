package view.event;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Event;

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
  private StringProperty
      titleProperty,
      descriptionProperty,
      dateProperty,
      locationProperty;

  /**
   * 1-argument constructor that sets up the eventViewModel based on the Event.
   * It converts the event to the structure that is understood by GUI.
   *
   * @param event 
   *        the instance of the Event that is to be converted
   */
  public EventViewModel(Event event){
    titleProperty = new SimpleStringProperty(event.getTitle());
    descriptionProperty = new SimpleStringProperty(event.getDescription());
    dateProperty = new SimpleStringProperty(event.getStringDate());
    locationProperty=new SimpleStringProperty(event.getLocation());
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

  public StringProperty getLocationProperty()
  {
    return locationProperty;
  }
}
