package view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewHandler;
import view.ViewController;

import java.util.Optional;

public class GameListViewController extends ViewController
{
    @FXML private Label errorLabel;
    @FXML private TableView<GameViewModel> gameListTable;
    @FXML private TableColumn<GameViewModel, String> titleColumn;
    @FXML private TableColumn<GameViewModel, String> ownerColumn;
    @FXML private TableColumn<GameViewModel, String> typeColumn;

    private GameListViewModel viewModel;
    public GameListViewController(){
    }
    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

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
    public void removeGame(ActionEvent event) {
        errorLabel.setText("");
        try{
            GameViewModel selectedItem = gameListTable.getSelectionModel().getSelectedItem();
            boolean remove = confirmation();
            if(remove){
                model.removeEvent(selectedItem.getTitleProperty().get());
                viewModel.remove(selectedItem.getTitleProperty().get());
                gameListTable.getSelectionModel().clearSelection();
            }
        }catch(Exception e){
            errorLabel.setText("Exception:" + e.getMessage());
        }
    }
    private boolean confirmation(){
        int index = gameListTable.getSelectionModel().getSelectedIndex();
        GameViewModel selectedItem= gameListTable.getItems().get(index);
        if (index < 0 || index >= gameListTable.getItems().size())  return false;

        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Removing Game {" + selectedItem.getTitleProperty().get() + ": "+ selectedItem.getOwnerProperty().get() + "}");
        Optional<ButtonType> result = alert.showAndWait();
        return (result.isPresent())&&(result.get()==ButtonType.OK);
    }

    @FXML
    public void goBack(ActionEvent event) {
        viewHandler.openView("menu");
    }

    @FXML
    public void getDetails(ActionEvent event) {
        viewHandler.openView("gameDetails");
    }

}
