package view.games;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Game;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class GameViewModel implements Serializable
{
  private Game game;
  private StringProperty titleProperty, ownerProperty, typeProperty, numberOfPlayersProperty, descriptionProperty, borrowedToProperty;
  /**
   * 1-argument constructor 
   * 
   * 
   * @param game 
   *        
   */
  public GameViewModel(Game game)
  {
    this.game = game;
    this.titleProperty=new SimpleStringProperty(game.getTitle());
    this.ownerProperty=new SimpleStringProperty(game.getOwner());
    this.typeProperty=new SimpleStringProperty(game.getType());
    this.numberOfPlayersProperty=new SimpleStringProperty(game.getNumberOfPlayers());
    this.descriptionProperty=new SimpleStringProperty(game.getDescription());
    this.borrowedToProperty=new SimpleStringProperty(game.getBorrowedTo());
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public Game getGame() { return game; }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public StringProperty getOwnerProperty()
  {
    return ownerProperty;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public StringProperty getTypeProperty()
  {
    return typeProperty;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public StringProperty getNumberOfPlayersProperty()
  {
    return numberOfPlayersProperty;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public StringProperty getDescriptionProperty()
  {
    return descriptionProperty;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public StringProperty getBorrowedToProperty()
  {
    return borrowedToProperty;
  }
}
