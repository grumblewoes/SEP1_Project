package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import model.BoardGamesModel;

public class MainViewController extends  ViewController
{
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    setRoot(root);
    setViewHandler(viewHandler);
    setModel(model);
  }

  public void reset()
  {

  }

  public void gamesBtnClicked()
  {
    getViewHandler().openView("gameList");
  }

  public void clubAssociateBtnClicked()
  {
    getViewHandler().openView("clubAssociateList");
  }

  public void wishListBtnClicked()
  {
    getViewHandler().openView("wishList");
  }

  public void eventsBtnClicked()
  {
    getViewHandler().openView("eventList");
  }

  public void updateWebsiteBtnClicked()
  {
    getViewHandler().openView("updateWebsite");
  }

  public void exitBtnClicked()
  {
    getViewHandler().closeView();
  }
}
