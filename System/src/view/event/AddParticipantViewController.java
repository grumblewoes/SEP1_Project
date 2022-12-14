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
/**
 * A class extending viewController which adds participants to the event.
 *
 * @author Jakub Cerovsky
 * @version 1.0 - 08 December 2022
 */
public class AddParticipantViewController extends ViewController
{
  @FXML private TableView<ClubAssociateViewModel> clubAssociatesListTable;
  @FXML private TableColumn<ClubAssociateViewModel, String> nameColumn;
  @FXML private TableColumn<ClubAssociateViewModel, Number> schoolIdColumn;
  @FXML private TableColumn<ClubAssociateViewModel, String> statusColumn;
  @FXML private Label errorLabel;
  private ClubAssociateListViewModel viewModel;

  /**
   * A method that initialises the controller alongside the rest of its components.
   * It sets values inside the Club Associate Table.
   *
   * @param viewHandler
   *        the current viewHandler that connects view and model packages
   * @param model
   *        the model of board games system that is being used
   * @param root
   *        the root of the region
   */
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
  /**
   * A method that resets the data displayed in the view.
   *
   */
  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }
  @FXML private void addParticipantSubmit(){
    errorLabel.setText("");
    try
    {
      ClubAssociateViewModel clubAssociateViewModel = clubAssociatesListTable.getSelectionModel().getSelectedItem();
      if(clubAssociateViewModel==null ){
        throw new IllegalStateException("The participant is not selected.");
      }
      for(int i=0;i<model.getAllClubAssociates().size();i++){
        if(clubAssociateViewModel.getSchoolIdProperty().get()==model.getAllClubAssociates().get(i).getSchoolId()){
          model.addParticipantToEvent(model.getSelectedEvent(),model.getAllClubAssociates().get(i));
        }
      }
      viewHandler.openView("eventList");
    }
    catch (Exception e){
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void goBack(){
    viewHandler.openView("eventList");
  }
}
