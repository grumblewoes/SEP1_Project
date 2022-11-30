package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import model.BoardGamesModel;

public class MainViewController extends  ViewController
{
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }

  public void reset()
  {

  }

  public void gamesBtnClicked()
  {
    viewHandler.openView("gameList");
  }

  public void clubAssociateBtnClicked()
  {
    viewHandler.openView("clubAssociateList");
  }

  public void wishListBtnClicked()
  {
    viewHandler.openView("wishList");
  }

  public void eventsBtnClicked()
  {
    viewHandler.openView("eventList");
  }

  public void updateWebsiteBtnClicked()
  {
    model.generateModelDataFile();
  }

  public void exitBtnClicked()
  {
    viewHandler.closeView();
  }
}
