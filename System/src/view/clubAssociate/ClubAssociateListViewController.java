package view.clubAssociate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;

public class ClubAssociateListViewController extends ViewController
{

    private ClubAssociateListViewModel viewModel;
    @FXML private Label errorLabel;


    @FXML private TableColumn nameColumn;
    @FXML private TableColumn surnameColumn;
    @FXML private TableColumn typeColumn;

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

