package view.clubAssociate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;

public class ClubAssociateListViewController extends ViewController
{
    @FXML private TableView<ClubAssociateViewModel> clubAssociatesListTable;
    @FXML private TableColumn<ClubAssociateViewModel, String> nameColumn;
    @FXML private TableColumn<ClubAssociateViewModel, String> surnameColumn;
    @FXML private TableColumn<ClubAssociateViewModel, String> statusColumn;
    @FXML private Label errorLabel;
    private ClubAssociateListViewModel viewModel;

    public ClubAssociateListViewController() {

    }
    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
    {
        this.viewHandler=viewHandler;
        this.model=model;
        this.root=root;

        this.viewModel = new ClubAssociateListViewModel(model);
    }

    public void reset(){
        errorLabel.setText("");
        viewModel.update();
    }

    public void addAssociateBtnClicked()
    {
        viewHandler.openView("addClubAssociate");
    }

    public void toggleMembershipBtnClicked()
    {

    }

    public void detailsBtnClicked()
    {

    }

    public void returnBtnClicked()
    {
        viewHandler.openView("menu");
    }
}

