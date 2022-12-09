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
   * @param model the model that allows the JavaFX classes to interface with
   *              the base classes.
   */
  public WishListViewModel(BoardGamesModel model){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  /**
   * Method that returns a list of WishViewModel objects that will be displayed
   * on screen.
   *
   * @return returns a list of WishViewModels
   */
  public ObservableList<WishViewModel> getList(){
    return list;
  }

  /**
   * Updates the list of wishViewModels depending on changes in the model.
   */
  public void update(){
    list.clear();
    ArrayList<Wish> wishes = model.getAllWishes();
    for (Wish wish : wishes)
      list.add(new WishViewModel(wish));
  }

  /**
   * Method that adds a wishViewModel to the WishListViewModel.
   * 
   * @param wish the wish in the model that will be added as a WishViewModel
   *        
   */
  public void add(Wish wish){
    list.add(new WishViewModel(wish));
  }

  /**
   * Method that removes a WishViewModel from the WishListViewModel depending
   * on changes in the model.
   * @param wish the wish from the model that is to be removed.
   *        
   */
  public void remove(Wish wish){
    for(WishViewModel wvm : list)
      if( wvm.getWish().equals(wish)){
        list.remove(wvm);
        break;
      }
  }

}
