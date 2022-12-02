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
import model.BoardGamesFile;

import java.io.Serializable;

//Anna P
//for extra: add logic to submitWish where it scans for items in the list. if there is, show an error.
public class AddWishViewController extends ViewController implements
    Serializable
{
  @FXML
  private Button cancelButton;
  @FXML
  private Button submitButton;
  @FXML
  private TextField wishTextField;
  @FXML
  private Label errorLabel;

  private BoardGamesFile file;

  public void init(ViewHandler viewHandler, BoardGamesModel model, Region root) {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    file = new BoardGamesFile(this.model);
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
      Wish wish = new Wish(name);
      model.addWish(wish);

      viewHandler.openView("wishList");
      reset();
    }
    else if (name.equals(""))
      errorLabel.setText("Input is blank. Try again.");

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
