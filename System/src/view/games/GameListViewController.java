package view.games;
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
 * @author Jakub C and Anna P
 * @version 1.0
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
     */
    public GameListViewController(){
    }
    /**
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
     * resets the screen to its initial state
     */
    public void reset(){
        errorLabel.setText("");
        viewModel.update();
    }

    @FXML
    /**
     * 
     * adds a game to the game list
     */
    public void addGame() {
        viewHandler.openView("addGame");
    }

    @FXML
    /**
     * 
     * removes game from the game list
     */
    public void removeGame() {
        errorLabel.setText("");
        try{
            GameViewModel selectedItem = gameListTable.getSelectionModel().getSelectedItem();
            if(selectedItem==null) {
                throw new IndexOutOfBoundsException("Please select a game to remove.");
            }
            boolean remove = confirmation();

                if (remove)
                {
                    model.removeGame(selectedItem.getGame());
                    viewModel.remove(selectedItem.getTitleProperty().get());
                    gameListTable.getSelectionModel().clearSelection();
                    viewModel.update();
                }
            }
        catch (IndexOutOfBoundsException i) {
            errorLabel.setText(i.getMessage());
        }
        catch(Exception e){
            errorLabel.setText("Exception:" + e.getMessage());
            e.printStackTrace();
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
     * returns to menu screen
     */
    public void goBack() {
        viewHandler.openView("menu");
    }

    @FXML
    /**
     *  get details of a selected game
     */
    public void getDetails() {
        GameViewModel selected = gameListTable.getSelectionModel().getSelectedItem();
        if (selected == null)
            errorLabel.setText("Please select a game to fetch information on.");
        else
        {
            model.setSelectedGame(selected.getGame());
            viewHandler.openView("gameDetails");
        }
    }

}
