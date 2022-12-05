package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Reservation;
import view.ViewController;
import view.ViewHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class BorrowViewController extends ViewController
{
  @Override public void reset()
  {

  }

  @Override public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void borrowGameButton()
  {

  }
}
