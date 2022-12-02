package view.wish;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.Wish;

import java.io.Serializable;
import java.util.ArrayList;

public class WishListViewModel implements Serializable
{
  private ObservableList<WishViewModel> list;
  private BoardGamesModel model;

  public WishListViewModel(BoardGamesModel model){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public ObservableList<WishViewModel> getList(){
    return list;
  }

  public void update(){
    list.clear();
    ArrayList<Wish> wishes = model.getAllWishes();
    for (Wish wish : wishes)
      list.add(new WishViewModel(wish));
  }

  public void add(Wish wish){
    list.add(new WishViewModel(wish));
  }

  public void remove(String title){
    for(WishViewModel wvm : list)
      if( wvm.getTitleProperty().get().equals(title)){
        list.remove(wvm);
        break;
      }
  }

}
