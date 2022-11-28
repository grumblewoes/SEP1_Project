package view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;

public class AddWishViewController {

  @FXML
  private Button cancelButton;

  @FXML
  private Button submitButton;

  @FXML
  private TextField wishTextField;

  private Region root;
  private BoardGamesModel model;
  private ViewHandler viewHandler;

  @FXML
  void cancelWish(ActionEvent event) {

  }

  @FXML
  void submitWish(ActionEvent event) {

  }

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
  }

  public void reset () {
    wishTextField.setText("");
  }

  public Region getRoot() {
    return root;
  }

}
