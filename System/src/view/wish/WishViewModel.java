package view.wish;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Wish;

public class WishViewModel
{
  private StringProperty
      titleProperty,
      votesProperty;

  public WishViewModel (Wish wish){
    titleProperty = new SimpleStringProperty(wish.getTitle());
    votesProperty = new SimpleStringProperty(Integer.toString(wish.getVotes()));
  }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  public StringProperty getVotesProperty(){ return votesProperty; }
}
