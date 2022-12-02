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
  }
}
