package view.event;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Event;
import view.ViewController;
import view.ViewHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static model.Event.*;

/**
 * A class extending viewController which controls/manages the GUI regarding the addition of the event.
 * 
 * 
 * @author Damian Trafiałek
 * @version 1.0 - 03 December 2022
 */
public class AddEventViewController extends ViewController
{

  @FXML private TextField
      titleField,
      startHourField;

  @FXML private TextArea descriptionArea;

  @FXML private DatePicker datePicker;
  @FXML private ChoiceBox<String> locationChoiceBox;
  @FXML private Label errorLabel;


  /**
   * A method that initialises the controller alongside the rest of its components.
   * 
   * @param viewHandler 
   *        the current viewHandler that connects view and model packages
   * @param model 
   *        the model of board games system that is being used
   * @param root
   *        the root of the region
   */
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;

    reset();
  }

  /**
   * A method that resets the data displayed in the view.
   *
   */
  public void reset(){
    titleField.setText("");
    startHourField.setText("");
    descriptionArea.setText("");
    errorLabel.setText("");
    datePicker.setValue(LocalDate.now());
    locationChoiceBox.getItems().add(CANTEEN);
    locationChoiceBox.getItems().add(CLASSROOM);
    locationChoiceBox.getItems().add(ASK_BOB);
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
    String location= "";

    try{
      int[] arr = convertStartInput();
      LocalTime time = LocalTime.of(arr[0],arr[1]);
      LocalDateTime dateTime = LocalDateTime.of(date,time);
      model.addEvent( new Event(title,description,dateTime,location) );

      cancelBtnClicked();
    }catch (Exception e){
      errorLabel.setText("Exception: " +e.getMessage());
    }
  }

  @FXML private void cancelBtnClicked(){
    viewHandler.openView("eventList");
  }

}
