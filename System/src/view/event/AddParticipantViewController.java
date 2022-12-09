package view.event;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;
import view.clubAssociate.ClubAssociateListViewModel;
import view.clubAssociate.ClubAssociateViewModel;

public class AddParticipantViewController extends ViewController
{
  @FXML private TableView<ClubAssociateViewModel> clubAssociatesListTable;
  @FXML private TableColumn<ClubAssociateViewModel, String> nameColumn;
  @FXML private TableColumn<ClubAssociateViewModel, Number> schoolIdColumn;
  @FXML private TableColumn<ClubAssociateViewModel, String> statusColumn;
  @FXML private Label errorLabel;
  private ClubAssociateListViewModel viewModel;

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    this.viewModel = new ClubAssociateListViewModel(model);
    nameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    schoolIdColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSchoolIdProperty());
    statusColumn.setCellValueFactory(cellData -> cellData.getValue().getIsMemberProperty());

    clubAssociatesListTable.setItems(viewModel.getList());
    reset();
  }
  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }
  @FXML public void addParticipantSubmit(){
    errorLabel.setText("");
    try
    {
      for(int i=0;i<model.getAllClubAssociates().size();i++){
        if(clubAssociatesListTable.getSelectionModel().getSelectedItem().getSchoolIdProperty().get()==model.getAllClubAssociates().get(i).getSchoolId()){
          model.getSelectedEvent().addParticipant(model.getAllClubAssociates().get(i));
        }
      }
      viewHandler.openView("eventList");
    }
    catch (Exception e){
      errorLabel.setText(e.getMessage());
      e.printStackTrace();
    }
  }

  @FXML public void goBack(){
    viewHandler.openView("eventList");
  }
}
