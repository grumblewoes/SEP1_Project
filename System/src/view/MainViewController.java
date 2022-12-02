package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

  @FXML public void gamesBtnClicked()
  {
    viewHandler.openView("gameList");
  }

  @FXML public void clubAssociateBtnClicked()
  {
    viewHandler.openView("clubAssociateList");
  }

  @FXML public void wishListBtnClicked()
  {
    viewHandler.openView("wishList");
  }

  @FXML public void eventsBtnClicked()
  {
    viewHandler.openView("eventList");
  }

  @FXML public void exitBtnClicked()
  {
    viewHandler.closeView();
  }
}
