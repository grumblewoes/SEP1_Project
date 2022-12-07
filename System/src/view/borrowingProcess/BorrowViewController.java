package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.ClubAssociate;
import model.Game;
import model.Reservation;
import view.ViewController;
import view.ViewHandler;
import view.clubAssociate.ClubAssociateListViewModel;
import view.clubAssociate.ClubAssociateViewModel;

import java.io.Serializable;
import java.time.LocalDate;

public class BorrowViewController extends ViewController
{

  @FXML private TableView<ClubAssociateViewModel> clubAssociatesListTable;
  @FXML private TableColumn<ClubAssociateViewModel, String> nameColumn;
  @FXML private TableColumn<ClubAssociateViewModel, Number> schoolIdColumn;
  @FXML private TableColumn<ClubAssociateViewModel, String> statusColumn;
  @FXML private Label errorLabel;
  private ClubAssociateListViewModel viewModel;
  @Override public void reset()
  {
    errorLabel.setText("");
  }

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

  public Region getRoot()
  {
    return root;
  }

  @FXML private void borrowGameButton()
  {
    errorLabel.setText("");
    try
    {
      for (int x = 0; x < model.getAllClubAssociates().size(); x++)
      {
        if (clubAssociatesListTable.getSelectionModel().getSelectedItem()
            .getSchoolIdProperty().get() == model.getAllClubAssociates().get(x)
            .getSchoolId())
        {
          if (!model.getAllClubAssociates().get(x).isMember())
          {
            for (int i = 0; i < model.getAllGames().size(); i++)
            {
              if (model.getAllClubAssociates().get(x)
                  .equals(model.getAllGames().get(i).getBorrowedTo()))
              {
                throw new IllegalArgumentException(
                    "Guest cannot borrow more then one game.\nPlease return game first.");
              }
            }
            checkBorrowedDate(model.getSelectedGame(), model.getAllClubAssociates().get(x));
          }
          else
          {
            checkBorrowedDate(model.getSelectedGame(), model.getAllClubAssociates().get(x));
          }
          model.getSelectedGame().setBorrowedTo(model.getAllClubAssociates().get(x));
          model.getSelectedGame().setBorrowedFrom(LocalDate.now());
        }
      }
      errorLabel.setText("Success");
      viewHandler.openView("gameList");
    }
    catch (Exception e){
      errorLabel.setText("Something went wrong: "+e);
    }

  }

  private void checkBorrowedDate(Game game, ClubAssociate clubAssociate){
    if(!game.isAvailable()){
      throw new IllegalStateException("Game is already borrowed.");
    }
    if(model.isReserved(game)){
      for(int i=0;i<model.getAllReservation().size();i++){
        if(LocalDate.now().isEqual(model.getAllReservation().get(i).getDateFrom())&&game.getTitle().equals(model.getAllReservation().get(i).getGameTitle())){
          if(clubAssociate.getName().equals(model.getAllReservation().get(i).getAssociateName())){
              break;
          }
          throw new IllegalStateException("Game is reserved for today by somebody else. Come again and try tomorrow.");
        }
      }
    }
  }
  @FXML private void goBack()
  {
    viewHandler.openView("menu");
  }
}
