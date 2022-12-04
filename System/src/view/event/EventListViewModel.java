package view.event;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.Event;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A method that handles the list of events that is displayed in the eventsListView.
 *
 * @author Damian Trafiałek
 * @version 1.0 - 03 December 2022
 */
public class EventListViewModel implements Serializable
{
  private ObservableList<EventViewModel> list;
  private BoardGamesModel model;

  /**
   * 1-argument constructor creating the observableArrayList of events and updating it.
   * 
   * 
   * @param model 
   *        the current model of board games system
   */
  public EventListViewModel(BoardGamesModel model){
    this.model=model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  /**
   * A method that returns the list of events displayed.
   *
   * @return observableList
   *        the list of events displayed in the view,
   */
  public ObservableList<EventViewModel> getList(){
    return list;
  }

  /**
   * A method that clears the observableList and updates it with all events from the model.
   * 
   */
  public void update(){
    list.clear();
    ArrayList<Event> events = model.getAllEvents();
    for(Event event : events)
      list.add(new EventViewModel(event));
  }

  /**
   * A method that takes the event and adds it to observableList as a conversion of eventViewModel,
   * 
   * @param event 
   *        the instance of the event that is to be added to observableList of events,
   */
  public void add(Event event){
    list.add(new EventViewModel(event));
  }

  /**
   * A method that removes the event of a certain title from observableList/
   * 
   * @param title 
   *        the unique title by which the event is to be found and removed from the observableList of events,
   */
  public void remove(String title){
    for(EventViewModel evm : list)
      if( evm.getTitleProperty().get().equals(title)){
        list.remove(evm);
        break;
      }
  }




}
