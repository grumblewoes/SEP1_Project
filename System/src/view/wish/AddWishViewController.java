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
    getViewHandler().openView("wishList");
  }

  @FXML
  void submitWish(ActionEvent event) { //submits a wish to the list, initialized with 1 vote
    String name = wishTextField.getText();
    Wish wish = new Wish(name);
    model.addWish(wish);
  }

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
    setRoot(root);
    setViewHandler(viewHandler);
    setModel(model);
  }

  public void reset () {
    wishTextField.setText("");
  }


}
