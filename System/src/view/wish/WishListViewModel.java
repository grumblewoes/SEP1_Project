package view.wish;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.Wish;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that defines the javafx table of wishes that corresponds to WishList
 *
 *
 * @author Anna Pomerantz
 * @version 1.0 - 04 December 2022
 */
public class WishListViewModel implements Serializable
{
  private ObservableList<WishViewModel> list;
  private BoardGamesModel model;

  /**
   * 1-argument constructor 
   * 
   * 
   * @param model 
   *        
   */
  public WishListViewModel(BoardGamesModel model){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ObservableList<WishViewModel> getList(){
    return list;
  }

  /**
   * 
   * 
   */
  //refreshes the table shown on screen
  public void update(){
    list.clear();
    ArrayList<Wish> wishes = model.getAllWishes();
    for (Wish wish : wishes)
      list.add(new WishViewModel(wish));
  }

  /**
   * 
   * 
   * @param wish 
   *        
   */
  public void add(Wish wish){
    list.add(new WishViewModel(wish));
  }

  /**
   * 
   * 
   * @param wish 
   *        
   */
  //removes wish models from the table
  public void remove(Wish wish){
    for(WishViewModel wvm : list)
      if( wvm.getWish().equals(wish)){
        list.remove(wvm);
        break;
      }
  }

}
