package view.wish;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Wish;

import java.io.Serializable;

/**
 * A class that defines the javafx wish that corresponds to Wishes in the WishList
 *
 *
 * @author Anna Pomerantz
 * @version 1.0 - 04 December 2022
 */
public class WishViewModel implements Serializable
{
  private StringProperty titleProperty;
  private IntegerProperty votesProperty;
  private Wish wish;
  public WishViewModel (Wish wish){
    this.wish = wish;
    titleProperty = new SimpleStringProperty(wish.getTitle());
    votesProperty = new SimpleIntegerProperty(wish.getVotes());
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  //collection of get methods for all field properties
  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  //requires casting, returns error otherwise.
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public SimpleIntegerProperty getVotesProperty(){ return (SimpleIntegerProperty) votesProperty; }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public Wish getWish() { return wish; }
}
