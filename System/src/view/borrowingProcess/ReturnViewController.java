package view.borrowingProcess;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import model.BoardGamesModel;
import model.Game;
import model.Rating;
import view.ViewController;
import view.ViewHandler;


/**
 * A class extending viewController which controls/manages the GUI regarding the return of the game.
 *
 * 
 * @author Damian Trafiałek
 * @version 1.0 - 05 December 2022
 */
public class ReturnViewController extends ViewController
{

  @FXML private Button oneStarBtn,twoStarBtn,threeStarBtn,fourStarBtn,fiveStarBtn;

  /**
   * A method that initialises the controller alongside the rest of its components.
   *
   * @param viewHandler
   *        the current viewHandler that connects view and model packages
   * @param model
   *        the model of board games system that is being used
   * @param root
   *        the root of the region
   */
  @Override public void init(ViewHandler viewHandler, BoardGamesModel model, Region root){
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    reset();
  }

  /**
   * A method that resets the data displayed in the view.
   *
   */
  @Override public void reset()
  {
    setStars(0);
  }

  @FXML private void returnGameButton(){
    Game selectedGame = model.getSelectedGame();
    if(selectedGame != null){
      int ratingValue = 0;
      for(int i=1;i<=5;++i)
        if(getStar(i).getStyleClass().contains("yellow-star"))
          ratingValue = i;

      if(ratingValue!=0)
        model.getGameByTitle(selectedGame.getTitle()).addRatings( new Rating(ratingValue) );

      model.getGameByTitle(selectedGame.getTitle()).setBorrowedTo(null);
    }
    viewHandler.openView("gameList");
  }


  private Button getStar(int n){
    switch (n){
      case 1: return oneStarBtn;
      case 2: return twoStarBtn;
      case 3: return threeStarBtn;
      case 4: return fourStarBtn;
      case 5: return fiveStarBtn;
      default: return null;
    }
  }

  private void setStars(int n){
    if( n<=-1 && n>=6 )return;
    for(int i=1;i<=n;++i)
      if( !getStar(i).getStyleClass().contains("yellow-star") )
        getStar(i).getStyleClass().add( "yellow-star" );
    for(int i=n+1;i<=5;++i)
        getStar(i).getStyleClass().remove( "yellow-star" );
  }

  @FXML private void oneStarBtnClicked() { setStars(1); }
  @FXML private void twoStarBtnClicked() { setStars(2); }
  @FXML private void threeStarBtnClicked() { setStars(3); }
  @FXML private void fourStarBtnClicked() { setStars(4); }
  @FXML private void fiveStarBtnClicked() { setStars(5); }

  @FXML private void goBack(){
    viewHandler.openView("gameList");
  }
}
