package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Reservation;
import view.ViewHandler;

import java.time.LocalDate;

public class BorrowViewController
{
  private Region root;
  private BoardGamesModel model;
  private ViewHandler viewHandler;

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

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addReservationButton()
  {
//    errorLabel.setText("");
    try
    {
      Reservation reservation = new Reservation(LocalDate.now());
      model.addReservation(reservation);
//      errorLabel.setText("Success");
      viewHandler.openView("reservationsList");
    }
    catch (Exception e)
    {
//      errorLabel.setText(e.getMessage());
    }

  }
}
