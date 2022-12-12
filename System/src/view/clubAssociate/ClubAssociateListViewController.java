package view.clubAssociate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import view.ViewController;
import view.ViewHandler;

/**
 * A class extending ViewController, which controls the GUI side of displaying the club associates' list.
 * 
 * 
 * @author  Julia Gramovicha
 * @version 1.0 - 03 December 2022
 */
public class ClubAssociateListViewController extends ViewController
{
    @FXML private TableView<ClubAssociateViewModel> clubAssociatesListTable;
    @FXML private TableColumn<ClubAssociateViewModel, String> nameColumn;
    @FXML private TableColumn<ClubAssociateViewModel, Number> schoolIdColumn;
    @FXML private TableColumn<ClubAssociateViewModel, String> statusColumn;
    @FXML private Label errorLabel;
    private ClubAssociateListViewModel viewModel;

    /**
     * Method that initialises the controller and its components.
     * Creates the connection with the viewModel and list of club associates displayed in the view as a table.
     *
     * @param viewHandler the current viewHandler that connects view and model packages
     * @param model       the model of board games system that is being used
     * @param root        the root of the region
     */
    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

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
     * A method that resets the data displayed in the view and updates it.
     */
    public void reset()
    {
        errorLabel.setText("");
        viewModel.update();
    }


    @FXML private void goToAddClubAssociate()
    {
        viewHandler.openView("addClubAssociate");
    }


    @FXML private void toggleMembership() {
        try
        {
        ClubAssociateViewModel selected = clubAssociatesListTable.getSelectionModel().getSelectedItem();
        if (selected == null)
        {
            throw new IllegalStateException("No associate was selected.");
        }
       ClubAssociate clubAssociate = selected.getClubAssociate();
        if(!clubAssociate.isMember()){
            model.setClubAssociateAsMember(clubAssociate);
        }
        else{
            int numberOfBorrows=0;
            for (int i=0; i< model.getAllGames().size(); i++) {
                if (clubAssociate.getSchoolId()==model.getAllGames().get(i).getBorrowedToID()) {
                    numberOfBorrows++;
                    if(numberOfBorrows>1) {
                        throw new IllegalStateException("This associate has borrowed multiple games.");
                    }
                }

            }
            if (model.numberOfReservations()!=0){
                for (int i=0; i< model.numberOfReservations();i++) {
                    if(clubAssociate.getSchoolId()==model.getAllReservation().get(i).getAssociateId()) {
                        throw new IllegalStateException("This associate has reservations.");
                    }
                }
            }

            model.setClubAssociateAsGuest(clubAssociate);
        }
        reset();
    }
        catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }
            /**
             * A method that is executed when the button "Return" is clicked. When it is, it calls ViewHandler,
             * which has a method openView() and open the view with the id "Menu", so the user goes back to the main window.
             *
             */

            @FXML private void goBack()
        {
            viewHandler.openView("menu");
        }

        }


