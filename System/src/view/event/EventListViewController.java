package view.event;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;

import java.io.Serializable;
import java.util.Optional;

/**
 * A class extending viewController which controls/manages the GUI regarding the display of events.
 *
 * @author Damian Trafiałek
 * @version 1.0 - 03 December 2022
 */
public class EventListViewController extends ViewController
{
  @FXML private TableView<EventViewModel> eventListTable;
  @FXML private TableColumn<EventViewModel,String> titleColumn;
  @FXML private TableColumn<EventViewModel,String> dateColumn;
  @FXML private TableColumn<EventViewModel,String> descriptionColumn;
  @FXML private Label errorLabel;


  private EventListViewModel viewModel;

  /**
   * A method that initialises the controller alongside the rest of its components.
   * Creates the connection with the viewModel and list of events displayed in the view.
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

    this.viewModel = new EventListViewModel(model);

    titleColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getTitleProperty());
    descriptionColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getDescriptionProperty());
    dateColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getDateProperty());

    eventListTable.setItems(viewModel.getList());
  }

  /**
   * A method that resets the data displayed in the view and updates it.
   *
   */
  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }


  @FXML private void returnBtnClicked(){
    viewHandler.openView("menu");
  }

  @FXML private void addEventBtnPressed() {
    viewHandler.openView("addEvent");
  }

  @FXML private void removeEventBtnPressed() {
    errorLabel.setText("");
    try{
      EventViewModel selectedItem = eventListTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if(remove){
        model.removeEvent(selectedItem.getTitleProperty().get());
        viewModel.remove(selectedItem.getTitleProperty().get());
        eventListTable.getSelectionModel().clearSelection();
      }
    }catch(Exception e){
      errorLabel.setText("Exception:" + e.getMessage());
    }
  }

  private boolean confirmation(){
    int index = eventListTable.getSelectionModel().getSelectedIndex();
    EventViewModel selectedItem= eventListTable.getItems().get(index);
    if (index < 0 || index >= eventListTable.getItems().size())  return false;

    Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing event {" + selectedItem.getTitleProperty().get() + ": "+ selectedItem.getDateProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent())&&(result.get()==ButtonType.OK);
  }
}
