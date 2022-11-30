package view.wish;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Region;
import view.ViewController;
import view.ViewHandler;
import model.BoardGamesModel;

public class WishListViewController extends ViewController {

    @FXML
    private Button addVoteBtn;

    @FXML
    private Button addWishBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TableColumn<?, ?> tableView;

    @FXML
    void addVote(ActionEvent event) {

    }

    @FXML
    void addWish(ActionEvent event) {
        viewHandler.openView("addWish");
    }

    @FXML
    void goBack(ActionEvent event) {
        viewHandler.openView("menu");
    }

    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
        this.viewHandler=viewHandler;
        this.model=model;
        this.root=root;
    }

    public void reset () {

    }
}
