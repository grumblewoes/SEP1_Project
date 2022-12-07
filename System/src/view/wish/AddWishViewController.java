package view.wish;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;
import model.Wish;

//Anna P
//for extra: add logic to submitWish where it scans for items in the list. if there is, show an error.

/**
* A class extending ViewController that controls the GUI side of allowing the user to add games to the wishlist.
*
*
* @author Anna Pomerantz
* @version 1.0 - 04 December 2022
*/
public class AddWishViewController extends ViewController
{
  @FXML
  private TextField wishTextField;
  @FXML
  private Label errorLabel;

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
  }

  public void reset () {
    wishTextField.setText("");
    errorLabel.setText("");
  }

  //submits a wish to the list, initialized with 1 vote
  @FXML
  /**
   * 
   * 
   */
  public void submitWish() {
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
  /**
   * 
   * 
   * @param event 
   *        
   */
  public void cancelWish(ActionEvent event) {
    viewHandler.openView("wishList");
    reset();
  }

}
