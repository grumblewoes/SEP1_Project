package view.wish;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import view.ViewController;
import view.ViewHandler;
import model.Wish;

/**
* A class extending ViewController that controls the GUI side of allowing the user to add games to the wishlist.
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
  }

  /**
   * Method that resets the screen to its default values.
   */
  public void reset () {
    wishTextField.setText("");
    errorLabel.setText("");
  }

  /**
   * Method that connects with the WishList in the model to add a wish to the
   * wishlist.
   */
  @FXML
  private void addWishSubmit() {
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

  /**
   * Method that exits the screen to add a wish.
   */
  @FXML
  private void goBack() {
    viewHandler.openView("wishList");
  }

}
