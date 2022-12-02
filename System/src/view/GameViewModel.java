package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Game;

public class GameViewModel
{
  private StringProperty titleProperty, ownerProperty, typeProperty, numberOfPlayersProperty, descriptionProperty, borrowedToProperty;
  public GameViewModel(Game game)
  {
    this.titleProperty=new SimpleStringProperty(game.getTitle());
    this.ownerProperty=new SimpleStringProperty(game.getOwner());
    this.typeProperty=new SimpleStringProperty(game.getType());
    this.numberOfPlayersProperty=new SimpleStringProperty(game.getNumberOfPlayers());
    this.descriptionProperty=new SimpleStringProperty(game.getDescription());
    this.borrowedToProperty=new SimpleStringProperty(game.getBorrowedTo());
  }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  public StringProperty getOwnerProperty()
  {
    return ownerProperty;
  }

  public StringProperty getTypeProperty()
  {
    return typeProperty;
  }

  public StringProperty getNumberOfPlayersProperty()
  {
    return numberOfPlayersProperty;
  }

  public StringProperty getDescriptionProperty()
  {
    return descriptionProperty;
  }

  public StringProperty getBorrowedToProperty()
  {
    return borrowedToProperty;
  }
}
