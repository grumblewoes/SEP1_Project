package view.wish;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Wish;

import java.io.Serializable;

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

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  //requires casting, returns error otherwise.
  public SimpleIntegerProperty getVotesProperty(){ return (SimpleIntegerProperty) votesProperty; }

  public Wish getWish() { return wish; }
}
