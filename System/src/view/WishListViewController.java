package view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Region;
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
        getViewHandler().openView("addWishView");
    }

    @FXML
    void goBack(ActionEvent event) {
        getViewHandler().openView("menu");
    }

    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
        setRoot(root);
        setViewHandler(viewHandler);
        setModel(model);
    }

    public void reset () {

    }

}
