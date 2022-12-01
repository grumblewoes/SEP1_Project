package view.wish;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;
import model.Wish;

//Anna P
//for extra: add logic to submitWish where it scans for items in the list. if there is, show an error.
public class AddWishViewController extends ViewController {
  @FXML
  private Button cancelButton;
  @FXML
  private Button submitButton;
  @FXML
  private TextField wishTextField;
  @FXML
  private Label errorLabel;

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }

  public void reset () {
    wishTextField.setText("");
    errorLabel.setText("");
  }

  @FXML
  void submitWish() {
    String name = wishTextField.getText();

    //checks if wishlist already has the specified game
    if (!model.getAllWishes().contains(model.getWishByTitle(name)) && !name.equals(""))
    {
      model.addWish(new Wish(name));
      //WishList in model is updating, but screen is not. find a way to connect WishListViewModel here to update on screen
      viewHandler.openView("wishList");
      reset();
    }
    else
      errorLabel.setText("That game is already on the wishlist.");
  }

  @FXML
  void cancelWish(ActionEvent event) {
    viewHandler.openView("wishList");
    reset();
  }

  //submits a wish to the list, initialized with 1 vote







}
