package view.wish;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import view.ViewController;
import view.ViewHandler;
import model.BoardGamesModel;

public class WishListViewController extends ViewController {

    @FXML
    private Label errorLabel;
    @FXML
    private TableColumn<WishViewModel, String> wishName;
    @FXML
    private TableView<WishViewModel> wishTable;
    @FXML
    private TableColumn<WishViewModel, Integer> wishVotes;

    private WishListViewModel viewModel;

    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
        this.viewHandler=viewHandler;
        this.model=model;
        this.root=root;

        this.viewModel = new WishListViewModel(model);

        wishName.setCellValueFactory( cellData -> cellData.getValue()
                .getTitleProperty());
        wishVotes.setCellValueFactory( cellData -> cellData.getValue()
                .getVotesProperty().asObject()); //won't take IntegerProperty, needs object type to work

        wishTable.setItems(viewModel.getList());
    }

    //adds vote to currently selected table row. get() is there to convert SimpleStringProperty to String
    @FXML
    public void addVote() {
        WishViewModel wishView = wishTable.getSelectionModel().getSelectedItem();
        //display error if voting with a null selection. not the right way to do it currently
        if (wishView == null) {
            errorLabel.setText("Please select a wish to vote for.");
        }
        else {
            errorLabel.setText("");
            model.getWishByTitle(wishView.getTitleProperty().get()).incrementVoteBy1();
            viewModel.update();
        }
    }

    @FXML
    public void addWish() {
        viewHandler.openView("addWish");
    }

    @FXML
    public void goBack() {
        viewHandler.openView("menu");
    }



    public void reset () {
        errorLabel.setText("");
        viewModel.update();
    }
}
