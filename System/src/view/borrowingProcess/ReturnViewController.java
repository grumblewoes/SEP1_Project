package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Rating;
import view.ViewController;
import view.ViewHandler;

import java.awt.*;

public class ReturnViewController extends ViewController
{
  @Override public void reset()
  {

  }

  @Override public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    setRoot(root);
    setViewHandler(viewHandler);
    setModel(model);
  }
  @FXML private int oneStar(){
    return Rating.LEGAL_RATINGS[0];
  }
  @FXML private int twoStars(){
    return Rating.LEGAL_RATINGS[1];
  }
  @FXML private int threeStars(){
    return Rating.LEGAL_RATINGS[2];
  }
  @FXML private int fourStars(){
    return Rating.LEGAL_RATINGS[3];
  }
  @FXML private int fiveStars(){
    return Rating.LEGAL_RATINGS[4];
  }

  @FXML private void returnGameButton(){
  }
  @FXML private void cancelButton(){}
}
