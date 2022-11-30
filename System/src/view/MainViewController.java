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

  public void gamesBtnClicked(ActionEvent actionEvent)
  {
    getViewHandler().openView("gameList");
  }

  public void clubAssociateBtnClicked(ActionEvent actionEvent)
  {
    getViewHandler().openView("clubAssociateList");
  }

  public void wishListBtnClicked(ActionEvent actionEvent)
  {
    getViewHandler().openView("wishList");
  }

  public void eventsBtnClicked(ActionEvent actionEvent)
  {
    getViewHandler().openView("eventList");
  }

  public void updateWebsiteBtnClicked(ActionEvent actionEvent)
  {
    getViewHandler().openView("updateWebsite");
  }

  public void exitBtnClicked(ActionEvent actionEvent)
  {
    getViewHandler().closeView();
  }
}
