package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Reservation;
import view.ViewController;
import view.ViewHandler;

import javax.swing.text.View;
import java.time.LocalDate;

public class BorrowViewController extends ViewController
{

  public BorrowViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    reset();
  }

  public void reset()
  {
  }


  @FXML private void changeBorrowButton()
  {
//    errorLabel.setText("");
    try
    {
//      Reservation reservation = new Reservation(LocalDate.now());
//      model.addReservation(reservation);
//      errorLabel.setText("Success");
      viewHandler.openView("reservationsList");
    }
    catch (Exception e)
    {
//      errorLabel.setText(e.getMessage());
    }

  }
}
