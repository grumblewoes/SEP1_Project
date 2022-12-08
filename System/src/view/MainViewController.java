package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import model.BoardGamesModel;

import java.io.Serializable;

/**
 * MainViewController is a class extending a ViewController abstract class
 * Main purpose is to navigate to the other parts of the system as this being the first page after starting it
 *
 * @author Jakub Cerovsky
 * @version 1.0 - 03 December 2022
 */
public class MainViewController extends  ViewController
{
  /**
   * Method that initialises the controller alongside the rest of its components.
   * 
   * @param viewHandler  - ViewHandler connecting other packages
   *        
   * @param model - BoardGamesModel being used
   *        
   * @param root - Region
   */
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    reset();
  }

  /**
   * Method used to reset displayed data of the view
   */
  public void reset()
  {
  }

  /**
   * Method that opens another view by given string id when button is clicked
   */
  public void gamesBtnClicked()
  {
    viewHandler.openView("gameList");
  }

  /**
   * Method that opens another view by given string id when button is clicked
   */
  public void clubAssociateBtnClicked()
  {
    viewHandler.openView("clubAssociateList");
  }

  /**
   * Method that opens another view by given string id when button is clicked
   */
  public void wishListBtnClicked()
  {
    viewHandler.openView("wishList");
  }

  /**
   * Method that opens another view by given string id when button is clicked
   */
  public void eventsBtnClicked()
  {
    viewHandler.openView("eventList");
  }

  /**
   * Method that closes the system when button is clicked
   */
  public void exitBtnClicked()
  {
    viewHandler.closeView();
  }

}
