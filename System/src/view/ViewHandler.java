package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BoardGamesModel;
import view.event.AddEventViewController;
import view.event.EventListViewController;

import java.io.Serializable;

/**
 * A class that connects the view and model packages together.
 * Handles the usage of the GUI.
 * 
 * 
 * @author Damian Trafiałek
 * @version 03 December 2022
 */
public class ViewHandler implements Serializable
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
      wishListViewController,
      borrowViewController,
      returnViewController;


  /**
   * 1-argument constructor. Connects the model to view package. Creates the current scene.
   * 
   * 
   * @param model 
   *        the model of the board games system
   */
  public ViewHandler(BoardGamesModel model)
  {
    this.model=model;
    this.currentScene= new Scene(new Region());
  }


  /**
   * A method that start the GUI.
   * 
   * @param primaryStage 
   *        the stage which displays GUI.
   */
  public void start(Stage primaryStage){
    this.primaryStage= primaryStage;
    openView("menu");
  }
  /**
   * A method handling the opening of different views. Takes the unique id and chooses the correct controller and fxml file to open/load.
   * 
   * @param id 
   *        the unique id based on which different views open
   */
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
        wishListViewController = loadViewController("WishListView.fxml", wishListViewController);
        root = wishListViewController.getRoot();
        break;
      case "addWish":
        addWishViewController = loadViewController("AddWishView.fxml", addWishViewController);
        root = addWishViewController.getRoot();
        break;
      case "addGame":
        addGameViewController = loadViewController("AddGameView.fxml", addGameViewController);
        root = addGameViewController.getRoot();
        break;
      case "gameList":
        gameListViewController = loadViewController("GameListView.fxml", gameListViewController);
        root = gameListViewController.getRoot();
        break;
      case "addReservation":
        addReservationViewController = loadViewController("AddReservationView.fxml", addReservationViewController);
        root = addReservationViewController.getRoot();
        break;
      case "return":
        returnViewController = loadViewController("ReturnView.fxml", returnViewController);
        root = returnViewController.getRoot();
        break;
      case "borrow":
        borrowViewController = loadViewController("BorrowView.fxml", borrowViewController);
        root = borrowViewController.getRoot();
        break;
      case "gameDetails":
        gameDetailsViewController = loadViewController("GameDetailsView.fxml", gameDetailsViewController);
        root = gameDetailsViewController.getRoot();
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
      System.out.println("loading a new controller... "+controller);
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
      System.out.println("reusing a controller... "+controller);
      controller.reset();
    }
    return controller;
  }

  /**
   *  A method that closes the application, closes the view.
   *
   */
  public void closeView(){ primaryStage.close(); }

}
