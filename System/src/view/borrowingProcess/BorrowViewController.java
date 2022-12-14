package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import model.Game;
import view.ViewController;
import view.ViewHandler;
import view.clubAssociate.ClubAssociateListViewModel;
import view.clubAssociate.ClubAssociateViewModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * BorrowViewController is a class extending ViewController abstract class
 * Main purpose is to mark game as borrow so no other associate can borrow it.
 *
 * @author Jakub Cerovsky
 * @version 2.0 - 07 December 2022
 */
public class BorrowViewController extends ViewController
{

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
   * @param viewHandler  - ViewHandler connecting other packages
   *
   * @param model - BoardGamesModel being used
   *
   * @param root - Region
   */
  @Override public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
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
   * Method used to reset displayed data of the view
   */
  @Override public void reset()
  {
    errorLabel.setText("");
    viewModel.update();
  }

  @FXML private void borrowGameSubmit()
  {
    errorLabel.setText("");
    try
    {
      ClubAssociateViewModel clubAssociate=clubAssociatesListTable.getSelectionModel().getSelectedItem();
      if(clubAssociate==null){
        throw new IllegalStateException("No Club associate selected.");
      }
      ClubAssociate associate = clubAssociate.getClubAssociate();
          if (!associate.isMember())
          {
            ArrayList<Game> gameList = model.getAllGames();
            int size = gameList.size();
            for (int i = 0; i < size ; i++)
            {
              if (associate.getSchoolId()==gameList.get(i).getBorrowedToID())
              {
                throw new IllegalArgumentException(
                    "Guest cannot borrow more then one game. Please return game first.");
              }
            }
            checkBorrowedDate(model.getSelectedGame(), associate);
          }
          else
          {
            checkBorrowedDate(model.getSelectedGame(), associate);
          }
          model.borrowGame(model.getSelectedGame(),associate, LocalDate.now());
      errorLabel.setText("Success");
      viewHandler.openView("gameList");
    }
    catch (Exception e){
      errorLabel.setText(e.getMessage());
    }
  }

  private void checkBorrowedDate(Game game, ClubAssociate clubAssociate){
    if(!game.isAvailable()){
      throw new IllegalStateException("Game is already borrowed.");
    }
    if(model.isReserved(game)){
      for(int i=0;i<model.numberOfReservations();i++){
        if(LocalDate.now().isEqual(model.getAllReservation().get(i).getDate())&&game.getTitle().equals(model.getAllReservation().get(i).getGameTitle())){
          if(clubAssociate.getSchoolId()==model.getAllReservation().get(i).getAssociateId()){
              break;
          }
          throw new IllegalStateException("Game is reserved for today by somebody else. Come again and try tomorrow.");
        }
      }
    }
  }
  @FXML private void goBack()
  {
    viewHandler.openView("gameList");
  }
}
