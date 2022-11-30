package view.event;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.Event;

import java.util.ArrayList;

public class EventListViewModel
{
  private ObservableList<EventViewModel> list;
  private BoardGamesModel model;

  public EventListViewModel(BoardGamesModel model){
    this.model=model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public ObservableList<EventViewModel> getList(){
    return list;
  }

  public void update(){
    list.clear();
    ArrayList<Event> events = model.getAllEvents();
    for(Event event : events)
      list.add(new EventViewModel(event));
  }

  public void add(Event event){
    list.add(new EventViewModel(event));
  }

  public void remove(String title){
    for(EventViewModel evm : list)
      if( evm.getTitleProperty().get().equals(title)){
        list.remove(evm);
        break;
      }
  }




}
