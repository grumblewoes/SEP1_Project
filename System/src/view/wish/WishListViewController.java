package view.wish;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import view.ViewController;
import view.ViewHandler;
import model.BoardGamesModel;



/**
 * A class extending ViewController that controls the GUI side of viewing/modifying the wishlist.
 *
 * @author Anna Pomerantz
 * @version 1.0 - 04 December 2022
 */
public class WishListViewController extends ViewController
{
    @FXML
    private Label errorLabel;
    @FXML
    private TableColumn<WishViewModel, String> wishName;
    @FXML
    private TableView<WishViewModel> wishTable;
    @FXML
    private TableColumn<WishViewModel, Integer> wishVotes;

    private WishListViewModel viewModel;

    /**
     * Method that is run once when the controller is first loaded. Facilitates
     * easy controller load
     *
     * @param viewHandler connects to viewHandler class that contains a method to
     *                    switch controllers easily
     *
     * @param model connects to model to grant access to model methods
     *
     * @param root connects to screen to switch scenes
     */
    public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
        this.viewHandler=viewHandler;
        this.model=model;
        this.root=root;

        this.viewModel = new WishListViewModel(model);

        //sets all table values to ones fetched from the model
        wishName.setCellValueFactory( cellData -> cellData.getValue()
                .getTitleProperty());
        wishVotes.setCellValueFactory( cellData -> cellData.getValue()
                .getVotesProperty().asObject()); //won't take IntegerProperty, needs object type to work

        wishTable.setItems(viewModel.getList());
        reset();
    }

    /**
     * Method that adds a vote to the currently selected wish.
     */
    @FXML
    private void addVote() {
        WishViewModel wishView = wishTable.getSelectionModel().getSelectedItem();
        //display error if voting with a null selection. not the right way to do it currently
        if (wishView == null) {
            errorLabel.setText("Please select a wish to vote for.");
        }
        else {
            errorLabel.setText("");
            model.voteForWish(wishView.getWish());
            viewModel.update();
        }
    }

    /**
     * Method that adds a wish to the wishlist. Connects to WishList model
     */
    @FXML
    private void goToAddWish() {
        viewHandler.openView("addWish");
    }

    /**
     * Method that removes a wish from the list. Connects to WishList model
     */
    @FXML
    private void removeWish() {
        try{
            WishViewModel wishView = wishTable.getSelectionModel().getSelectedItem();
            if (wishView == null) {
                errorLabel.setText("Please select a wish to delete.");
            }
            else {
                errorLabel.setText("");
                model.removeWish(wishView.getWish());
                viewModel.remove(wishView.getWish());
                wishTable.getSelectionModel().clearSelection();
                viewModel.update();
            }
        }
        catch(Exception e){
            errorLabel.setText("Exception:" + e.getMessage());
        }
    }

    /**
     * Method that returns to the menu screen
     */
    @FXML
    private void goBack() {
        viewHandler.openView("menu");
    }

    /**
     * Method that resets the screen to its default values.
     */
    public void reset () {
        errorLabel.setText("");
        viewModel.update();
    }
}
