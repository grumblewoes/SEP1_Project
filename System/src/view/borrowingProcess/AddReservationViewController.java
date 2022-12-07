package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import model.Reservation;
import view.ViewController;
import view.ViewHandler;
import view.clubAssociate.ClubAssociateListViewModel;
import view.clubAssociate.ClubAssociateViewModel;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class AddReservationViewController extends ViewController
{
  @FXML private DatePicker datePicker;
  @FXML private TableView<ClubAssociateViewModel> clubAssociatesListTable;
  @FXML private TableColumn<ClubAssociateViewModel, String> nameColumn;
  @FXML private TableColumn<ClubAssociateViewModel, Number> schoolIdColumn;
  @FXML private TableColumn<ClubAssociateViewModel, String> statusColumn;
  @FXML private Label errorLabel;
  private ClubAssociateListViewModel viewModel;


  /**
   * 0-argument constructor 
   * 
   * 
   */
  public AddReservationViewController()
  {
    // Called by FXMLLoader
  }

  /**
   * 
   * 
   * @param viewHandler 
   *        
   * @param model 
   *        
   * @param root 
   *        
   */
  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new ClubAssociateListViewModel(model);
    nameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    schoolIdColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSchoolIdProperty());
    statusColumn.setCellValueFactory(cellData -> cellData.getValue().getIsMemberProperty());

    clubAssociatesListTable.setItems(viewModel.getListOfMembers());
    reset();
  }

  /**
   * 
   * 
   */
  public void reset()
  {
    errorLabel.setText("");
  }


  @FXML private void addReservationButton()
  {
    errorLabel.setText("");
    try
    {
      ClubAssociateViewModel clubAssociate=clubAssociatesListTable.getSelectionModel().getSelectedItem();
      if(clubAssociate==null){
        throw new IllegalStateException("No Club associate selected.");
      }
      LocalDate reservationDate=datePicker.getValue();
      if (reservationDate==null){
        throw new IllegalStateException("Choose a date please.");
      }
      for(int i=0;i<model.getAllClubAssociates().size();i++){
        if(clubAssociate.getSchoolIdProperty().get()==model.getAllClubAssociates().get(i).getSchoolId()){
          Reservation reservation = new Reservation(model.getSelectedGame(),model.getAllClubAssociates().get(i),reservationDate);
          model.addReservation(reservation);
        }
      }
      errorLabel.setText("Success");
      viewHandler.openView("gameList");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }

  }
  @FXML private void goBack()
  {
    viewHandler.openView("menu");
  }
}