package view.wish;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
  void cancelWish(ActionEvent event) {
    //show WishListView
    viewHandler.openView("wishList");
  }

  @FXML
  void submitWish() { //submits a wish to the list, initialized with 1 vote
    String name = wishTextField.getText();
    Wish wish = new Wish(name);
    model.addWish(wish);
    viewHandler.openView("wishList");
  }

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
  }

  public void reset () {
    wishTextField.setText("");
  }


}
