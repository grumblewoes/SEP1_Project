package view.games;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewHandler;
import view.ViewController;

import java.util.Optional;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class GameListViewController extends ViewController
{
    @FXML private Label errorLabel;
    @FXML private TableView<GameViewModel> gameListTable;
    @FXML private TableColumn<GameViewModel, String> titleColumn;
    @FXML private TableColumn<GameViewModel, String> ownerColumn;
    @FXML private TableColumn<GameViewModel, String> statusColumn;

    private GameListViewModel viewModel;
    /**
     * 0-argument constructor 
     * 
     * 
     */
    public GameListViewController(){
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
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

        this.viewModel = new GameListViewModel(model);
        titleColumn.setCellValueFactory(
            cellData -> cellData.getValue().getTitleProperty());
        ownerColumn.setCellValueFactory(
            cellData -> cellData.getValue().getOwnerProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getBorrowedToProperty());

        gameListTable.setItems(viewModel.getList());
        reset();
    }

    /**
     * 
     * 
     */
    public void reset(){
        errorLabel.setText("");
        viewModel.update();
    }

    @FXML
    /**
     * 
     * 
     */
    public void addGame() {
        viewHandler.openView("addGame");
    }

    @FXML
    /**
     * 
     * 
     */
    public void removeGame() {
        errorLabel.setText("");
        try{
            GameViewModel selectedItem = gameListTable.getSelectionModel()
                .getSelectedItem();
            boolean remove = confirmation();
            for(int i=0;i<model.getAllGames().size();i++) {
                if (remove && selectedItem.equals(model.getAllGames().get(i)))
                {
                    model.removeGame(model.getAllGames().get(i));
                    viewModel.remove(selectedItem.getTitleProperty().get());
                    gameListTable.getSelectionModel().clearSelection();
                }
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
    /**
     * 
     * 
     */
    public void goBack() {
        viewHandler.openView("menu");
    }

    @FXML
    /**
     * 
     * 
     * @param event 
     *        
     */
    public void getDetails(ActionEvent event) {
        model.setSelectedGame(gameListTable.getSelectionModel().getSelectedItem().getGame());
        viewHandler.openView("gameDetails");
    }


}
