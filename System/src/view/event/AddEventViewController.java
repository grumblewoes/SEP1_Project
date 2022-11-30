package view.event;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Event;
import view.ViewController;
import view.ViewHandler;

import java.time.LocalDate;

public class AddEventViewController extends ViewController
{

  @FXML private TextField
      titleField,
      startHourField,
      endHourField;

  @FXML private TextArea descriptionArea;

  @FXML private DatePicker datePicker;
  @FXML private Label errorLabel;


  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }

  public void reset(){
    titleField.setText("");
    startHourField.setText("");
    endHourField.setText("");
    descriptionArea.setText("");
    errorLabel.setText("");
    datePicker.getEditor().setText("");
  }


  @FXML private void submitBtnClicked(){
    String title = titleField.getText();
    String startHour = startHourField.getText();
    String endHour = endHourField.getText();
    String description = descriptionArea.getText();
    LocalDate date = datePicker.getValue();

    try{
      model.addEvent( new Event(title,description,date) );

      cancelBtnClicked();
    }catch (Exception e){
      errorLabel.setText("Exception: " +e.getMessage());
    }
  }

  @FXML private void cancelBtnClicked(){
    viewHandler.openView("eventList");
  }

}
