package view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Reservation;

public class AddReservationViewController
{
  @FXML private DatePicker datePicker;
  @FXML private Label errorLabel;

  private Region root;
  private BoardGamesModel model;
  private ViewHandler viewHandler;

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

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addReservationButton()
  {
    errorLabel.setText("");
    try
    {
      Reservation reservation = new Reservation(datePicker.getValue());
      model.addReservation(reservation);
      errorLabel.setText("Success");
      viewHandler.openView();
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }

  }
}