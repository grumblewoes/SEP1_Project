package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Reservation;
import view.ViewController;
import view.ViewHandler;

import java.io.Serializable;

public class AddReservationViewController extends ViewController
{
  @FXML private DatePicker datePicker;
  @FXML private Label errorLabel;


  public AddReservationViewController()
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


  @FXML private void addReservationButton()
  {
    errorLabel.setText("");
    try
    {
      Reservation reservation = new Reservation(null,null,datePicker.getValue());
      model.addReservation(reservation);
      errorLabel.setText("Success");
      viewHandler.openView("reservationsList");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }

  }
}