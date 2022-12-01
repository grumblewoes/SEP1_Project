package view.wish;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Wish;

public class WishViewModel
{
  private StringProperty titleProperty;
  private IntegerProperty votesProperty;

  public WishViewModel (Wish wish){
    titleProperty = new SimpleStringProperty(wish.getTitle());
    votesProperty = new SimpleIntegerProperty(wish.getVotes());
  }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  //requires casting, returns error otherwise.
  public SimpleIntegerProperty getVotesProperty(){ return (SimpleIntegerProperty) votesProperty; }
}
