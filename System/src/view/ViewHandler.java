package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BoardGamesModel;
import view.event.AddEventViewController;
import view.event.EventListViewController;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private BoardGamesModel model;


  private ViewController
      mainViewController,
      addReservationViewController,
      addEventViewController,
      addWishViewController,
      addGameViewController,
      addClubAssociateViewController,
      eventListViewController,
      gameListViewController,
      clubAssociateListViewController,
      gameDetailsViewController,
      wishListViewController;


  public ViewHandler(BoardGamesModel model)
  {
    this.model=model;
    this.currentScene= new Scene(new Region());
  }
  public void start(Stage primaryStage){
    this.primaryStage= primaryStage;
    openView("menu");
  }
  public void openView(String id){
    Region root = null;

    switch (id){
      case "addEvent":
        addEventViewController = loadViewController("AddEventView.fxml", addEventViewController);
        root = addEventViewController.getRoot();
        break;
      case "eventList":
        eventListViewController = loadViewController("EventListView.fxml", eventListViewController);
        root = eventListViewController.getRoot();
        break;
      case "clubAssociateList":
        clubAssociateListViewController = loadViewController("ClubAssociateListView.fxml", clubAssociateListViewController);
        root =clubAssociateListViewController.getRoot();
        break;
      case "addClubAssociate":
        addClubAssociateViewController = loadViewController("AddClubAssociateView.fxml", addClubAssociateViewController);
        root =addClubAssociateViewController.getRoot();
        break;
      case "wishList":
        mainViewController = loadViewController("WishListView.fxml", mainViewController);
        root = mainViewController.getRoot();
        break;
      case "addWish":
        wishListViewController = loadViewController("AddWishView.fxml", wishListViewController);
        root = wishListViewController.getRoot();
        break;
      default:
        mainViewController = loadViewController("Menu.fxml", mainViewController);
        root = mainViewController.getRoot();
    }

    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null){
      title += root.getUserData();
    }

    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }


  private ViewController loadViewController(String fxmlFile, ViewController controller)
  {
    String relativePath = "./fxmlFiles/";
    if (controller == null)
    {
      System.out.println("loading a new controller..."+controller);
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(relativePath+fxmlFile));
        Region root = loader.load();
        controller = loader.getController();
        controller.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      System.out.println("reusing a controller..."+controller);
      controller.reset();
    }
    return controller;
  }

  public void closeView(){ primaryStage.close(); }

}
