package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Reservation;
import view.ViewController;
import view.ViewHandler;
import view.clubAssociate.ClubAssociateListViewModel;
import view.clubAssociate.ClubAssociateViewModel;

import java.time.LocalDate;

/**
 * AddReservationViewController is a class extending ViewController abstract class
 * Main purpose is to add reservation to the list, taking the selected game, associate and date.
 *
 * @author Jakub Cerovsky
 * @version 2.0 - 07 December 2022
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
   * Method that initialises the controller alongside the rest of its components.
   * It sets values inside the Club Associate Table
   *
   * @param viewHandler 
   *        
   * @param model 
   *        
   * @param root
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
   * Method used to reset displayed data of the view
   */
  public void reset()
  {
    errorLabel.setText("");
  }

  /**
   * Method that adds reservation through the model to the reservation list when the button is clicked and all exceptions passed
   *
   * @throws IllegalStateException - in case that associate is not selected
   * @throws IllegalStateException - in case that date is not chosen
   * @throws IllegalStateException - in case that date is today and the game is already borrowed
   */
  @FXML private void addReservationSubmitButton()
  {
    errorLabel.setText("");
    try
    {
      ClubAssociateViewModel clubAssociate=clubAssociatesListTable.getSelectionModel().getSelectedItem();
      if(clubAssociate==null){
        throw new IllegalStateException("No Club associate selected.");
      }
      LocalDate reservationDate=datePicker.getValue();
      if (reservationDate!=null)
      {
        if (reservationDate.isEqual(LocalDate.now())&&!model.getSelectedGame().isAvailable()){
          throw new IllegalStateException("Game is borrowed for today.");
        }
        for (int i = 0; i < model.getAllClubAssociates().size(); i++)
        {
          if (clubAssociate.getSchoolIdProperty().get() == model.getAllClubAssociates().get(i).getSchoolId())
          {
            Reservation reservation = new Reservation(model.getSelectedGame(),
                model.getAllClubAssociates().get(i), reservationDate);
            model.addReservation(reservation);
          }
        }
        errorLabel.setText("Success");
        viewHandler.openView("gameList");
      }
      {
        throw new IllegalStateException("Choose a date please.");
      }
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }

  }
  /**
   * Method that opens another view by given string id when button is clicked
   */
  @FXML private void goBack()
  {
    model.setSelectedGame(null);
    viewHandler.openView("gameList");
  }
}