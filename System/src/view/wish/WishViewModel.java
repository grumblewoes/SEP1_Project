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
 * @author Anna Pomerantz
 * @version 1.0 - 04 December 2022
 */
public class WishViewModel implements Serializable
{
  private StringProperty titleProperty;
  private IntegerProperty votesProperty;
  private Wish wish;

  /**
   * 1-arg constructor
   * @param wish the wish to be initialized as a WishViewModel in JavaFX
   */
  public WishViewModel (Wish wish){
    this.wish = wish;
    titleProperty = new SimpleStringProperty(wish.getTitle());
    votesProperty = new SimpleIntegerProperty(wish.getVotes());
  }

  /**
   * Method that returns the SimpleStringProperty of the title of the wish.
   *
   * @return returns the StringProperty title
   *        
   */
  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  //requires casting, returns error otherwise.
  /**
   * Method that returns the SimpleIntegerProperty for the votes for the wish.
   *
   * @return returns the SimpleIntegerProperty votesProperty
   *        
   */
  public SimpleIntegerProperty getVotesProperty(){ return (SimpleIntegerProperty) votesProperty; }

  /**
   * Method that returns the wish object associated with the WishViewModel
   *
   * @return the Wish object associated
   *        
   */
  public Wish getWish() { return wish; }
}
