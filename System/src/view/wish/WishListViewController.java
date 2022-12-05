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
import view.event.EventViewModel;

import java.io.Serializable;


/**
 * A class extending ViewController that controls the GUI side of viewing/modifying the wishlist.
 *
 *
 * @author Anna Pomerantz
 * @version 1.0 - 04 December 2022
 */
public class WishListViewController extends ViewController
{

    @FXML
    private Button addVoteBtn;
    @FXML
    private Button addWishBtn;
    @FXML
    private Button backBtn;
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
     * 
     * 
     * @param viewHandler 
     *        
     * @param model 
     *        
     * @param root 
     *        
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
    }

    //adds vote to currently selected table row. get() is there to convert SimpleStringProperty to String
    @FXML
    void addVote(ActionEvent event) {
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

    @FXML
    void addWish(ActionEvent event) {
        viewHandler.openView("addWish");
    }

    //removes a wish from the list
    @FXML
    void removeWish(ActionEvent event) {
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

    @FXML
    void goBack(ActionEvent event) {
        viewHandler.openView("menu");
    }

    public void reset () {
        errorLabel.setText("");
        viewModel.update();
    }
}
