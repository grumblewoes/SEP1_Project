package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import model.BoardGamesModel;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class MainViewController extends  ViewController
{
  /**
   * 
   * 
   * @param viewHandler 
   *        
   * @param model 
   *        
   * @param root 
   *        
   */
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }

  /**
   * 
   * 
   */
  public void reset()
  {

  }

  /**
   * 
   * 
   */
  public void gamesBtnClicked()
  {
    viewHandler.openView("gameList");
  }

  /**
   * 
   * 
   */
  public void clubAssociateBtnClicked()
  {
    viewHandler.openView("clubAssociateList");
  }

  /**
   * 
   * 
   */
  public void wishListBtnClicked()
  {
    viewHandler.openView("wishList");
  }

  /**
   * 
   * 
   */
  public void eventsBtnClicked()
  {
    viewHandler.openView("eventList");
  }



  /**
   * 
   * 
   */
  public void exitBtnClicked()
  {
    viewHandler.closeView();
  }

}
