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

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.Chronology;

public class AddEventViewController extends ViewController
{

  @FXML private TextField
      titleField,
      startHourField;

  @FXML private TextArea descriptionArea;

  @FXML private DatePicker datePicker;
  @FXML private Label errorLabel;


  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    reset();
  }

  public void reset(){
    titleField.setText("");
    startHourField.setText("");
    descriptionArea.setText("");
    errorLabel.setText("");
    datePicker.setValue(LocalDate.now());
  }

  private int[] convertStartInput(){
    String value = startHourField.getText();

    if(
        !value.matches("((2[0-3])|([0-1][0-9]))[.,:]([0-5][0-9])")
    ) throw new IllegalArgumentException("Given pattern does not match the criteria!");

    //version v2.0 h:mm | hh:m
    int h = Integer.parseInt( value.substring(0, 2  ) );
    int m = Integer.parseInt( value.substring(value.length()-2) );

    return new int[]{h,m};
  }

  @FXML private void submitBtnClicked(){
    String title = titleField.getText();
    String description = descriptionArea.getText();
    LocalDate date = datePicker.getValue();


    try{
      int[] arr = convertStartInput();
      LocalTime time = LocalTime.of(arr[0],arr[1]);
      LocalDateTime dateTime = LocalDateTime.of(date,time);
      model.addEvent( new Event(title,description,dateTime) );

      cancelBtnClicked();
    }catch (Exception e){
      errorLabel.setText("Exception: " +e.getMessage());
    }
  }

  @FXML private void cancelBtnClicked(){
    viewHandler.openView("eventList");
  }

}
