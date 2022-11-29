package view.event;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;

import java.util.Optional;

public class EventListViewController extends ViewController
{
  @FXML private TableView<EventViewModel> eventListTable;
  @FXML private TableColumn<EventViewModel,String> titleColumn;
  @FXML private TableColumn<EventViewModel,String> dateColumn;
  @FXML private TableColumn<EventViewModel,String> descriptionColumn;
  @FXML private Label errorLabel;


  private EventListViewModel viewModel;

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    setRoot(root);
    setViewHandler(viewHandler);
    setModel(model);

    this.viewModel = new EventListViewModel(model);

    titleColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getTitleProperty());
    descriptionColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getDescriptionProperty());
    dateColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getDateProperty());

    eventListTable.setItems(viewModel.getList());
  }

  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }


  @FXML private void returnBtnClicked(){
    getViewHandler().openView("main");
  }

  @FXML  private void addEventBtnPressed() {
    getViewHandler().openView("addEvent");
  }

  @FXML private void removeEventBtnPressed() {
    errorLabel.setText("");
    try{
      EventViewModel selectedItem = eventListTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if(remove){
        getModel().removeEvent(selectedItem.getTitleProperty().get());
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