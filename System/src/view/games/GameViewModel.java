package view.games;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Game;

import java.io.Serializable;

/**
 * 
 * GameViewModel class converts the Game object into property that can be used by JavaFX
 * 
 * @author Jakub Cerovsky
 * @version 2.0 - 08 December 2022
 */
public class GameViewModel implements Serializable
{
  private Game game;
  private StringProperty titleProperty, ownerProperty, typeProperty, numberOfPlayersProperty, descriptionProperty, borrowedToProperty;
  /**
   * 1-argument constructor.
   * constructor converting the game object into structure understandable for JavaFX
   * 
   * @param game - Game
   *        
   */
  public GameViewModel(Game game)
  {
    this.game = game;
    this.titleProperty=new SimpleStringProperty(game.getTitle());
    this.ownerProperty=new SimpleStringProperty(game.getOwnerFullName());
    this.typeProperty=new SimpleStringProperty(game.getType());
    this.numberOfPlayersProperty=new SimpleStringProperty(game.getNumberOfPlayers());
    this.descriptionProperty=new SimpleStringProperty(game.getDescription());
    this.borrowedToProperty=new SimpleStringProperty(game.getBorrowedTo());
  }

  /**
   * 
   * Method that returns game, that is being converted, as a Game
   *
   * @return game that is being converted
   *        
   */
  public Game getGame() { return game; }

  /**
   *Method that returns converted title property as a StringProperty
   *
   * @return title property as a StringProperty
   */
  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  /**
   *Method that returns converted owner property as a StringProperty
   *
   * @return owner property as a StringProperty
   */
  public StringProperty getOwnerProperty()
  {
    return ownerProperty;
  }

  /**
   *Method that returns converted type property as a StringProperty
   *
   * @return type property as a StringProperty
   */
  public StringProperty getTypeProperty()
  {
    return typeProperty;
  }

  /**
   *Method that returns converted numberOfPlayers property as a StringProperty
   *
   * @return numberOfPlayers property as a StringProperty
   */
  public StringProperty getNumberOfPlayersProperty()
  {
    return numberOfPlayersProperty;
  }

  /**
   *Method that returns converted description property as a StringProperty
   *
   * @return description property as a StringProperty
   */
  public StringProperty getDescriptionProperty()
  {
    return descriptionProperty;
  }

  /**
   *Method that returns converted borrowedTo property as a StringProperty
   *
   * @return borrowedTo property as a StringProperty
   */
  public StringProperty getBorrowedToProperty()
  {
    return borrowedToProperty;
  }
}
