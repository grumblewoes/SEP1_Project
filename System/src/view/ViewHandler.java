package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BoardGamesModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private BoardGamesModel model;
  private AddReservationViewController addReservationViewController;

  public ViewHandler(BoardGamesModel model)
  {
    this.model=model;
    this.currentScene= new Scene(new Region());
  }
  public void start(Stage primaryStage){
    this.primaryStage= primaryStage;
    openView();
  }
  public void openView(){
    Region root = loadAddGradeView("Reservation.fxml");
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }
  private Region loadAddGradeView(String fxmlFile)
  {
    if (addReservationViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addReservationViewController = loader.getController();
        addReservationViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addReservationViewController.reset();
    }
    return addReservationViewController.getRoot();
  }

}
