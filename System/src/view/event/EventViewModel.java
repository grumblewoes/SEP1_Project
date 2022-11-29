package view.event;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Event;

public class EventViewModel
{
  private StringProperty
      titleProperty,
      descriptionProperty,
      dateProperty;

  public EventViewModel(Event event){
    titleProperty = new SimpleStringProperty(event.getTitle());
    descriptionProperty = new SimpleStringProperty(event.getDescription());
    dateProperty = new SimpleStringProperty(event.getStringDate());
  }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  public StringProperty getDescriptionProperty(){ return descriptionProperty; }

  public StringProperty getDateProperty()
  {
    return dateProperty;
  }
}
