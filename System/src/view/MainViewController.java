package view;

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
}
