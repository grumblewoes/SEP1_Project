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
    datePicker.setValue(null);
    datePicker.focusedProperty();
    viewModel.updateMembers();
  }

  @FXML private void addReservationSubmit()
  {
    errorLabel.setText(""); //O(1)
    try
    {
      ClubAssociateViewModel clubAssociate = clubAssociatesListTable.getSelectionModel().getSelectedItem(); //0(1)
      if(clubAssociate == null){ //0(1)
        throw new IllegalStateException("No Club associate selected."); //0(1)
      }
      LocalDate reservationDate = datePicker.getValue(); //0(1)
      if (reservationDate!=null) //0(1)
      {
        if (reservationDate.isEqual(LocalDate.now()) && !model.getSelectedGame().isAvailable()){ //0(1)
          throw new IllegalStateException("Game is borrowed for today."); //0(1)
        }
        for (int i = 0; i < model.getAllClubAssociates().size(); i++) //O(n)
        {
          if (clubAssociate.getSchoolIdProperty().get() == model.getAllClubAssociates().get(i).getSchoolId()) //0(1)
          {
            Reservation reservation = new Reservation(model.getSelectedGame(),
            model.getAllClubAssociates().get(i), reservationDate); //O(n)
            model.addReservation(reservation); //O(n)
            break;
          }
        }
        errorLabel.setText("Success"); //0(1)
        viewHandler.openView("gameList"); //0(1)
      }
      {
        throw new IllegalStateException("Choose a date please."); //0(1)
      }
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage()); //0(1)
    }
    //O(addReservationSubmitButton) = 8*O(1)+O(n)*O(1)+O(n) = O(n)  , where n is a number of clubAssociates in the list
  }

  @FXML private void goBack()
  {
    model.setSelectedGame(null);
    viewHandler.openView("gameList");
  }
}