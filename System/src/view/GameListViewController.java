package view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.clubAssociate.ClubAssociateListViewModel;
import view.clubAssociate.ClubAssociateViewModel;

import java.io.Serializable;

public class GameListViewController extends ViewController implements
    Serializable
{
    @FXML private TableView<GameViewModel> gameListTable;
    @FXML private TableColumn<GameViewModel, String> titleColumn;
    @FXML private TableColumn<GameViewModel, String> ownerColumn;
    @FXML private TableColumn<GameViewModel, String> typeColumn;

    private GameListViewModel viewModel;
    public GameListViewController(){
    }
    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
    {
        this.viewHandler=viewHandler;
        this.model=model;
        this.root=root;

        this.viewModel = new GameListViewModel(model);
        titleColumn.setCellValueFactory(
            cellData -> cellData.getValue().getTitleProperty());
        ownerColumn.setCellValueFactory(
            cellData -> cellData.getValue().getOwnerProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());

        gameListTable.setItems(viewModel.getList());
    }

    public void reset(){
        viewModel.update();
    }
    @FXML
    public void addGame(ActionEvent event) {
        viewHandler.openView("addGame");
    }

    @FXML
    public void borrowGame(ActionEvent event) {

    }

    @FXML
    public void goBack(ActionEvent event) {
        viewHandler.openView("menu");
    }

    @FXML
    public void reserveGame(ActionEvent event) {

    }

    @FXML
    public void returnGame(ActionEvent event) {

    }

}
