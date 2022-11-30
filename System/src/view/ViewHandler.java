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
    openView("eventList");
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


//  private Region loadAddEventViewController(String fxmlFile)
//  {
//    if (addEventViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        addEventViewController = loader.getController();
//        addEventViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      addEventViewController.reset();
//    }
//    return addEventViewController.getRoot();
//  }
//  private Region loadAddWishViewController(String fxmlFile)
//  {
//    if (addWishViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        addWishViewController = loader.getController();
//        addWishViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      addWishViewController.reset();
//    }
//    return addWishViewController.getRoot();
//  }
//  private Region loadAddGameViewController(String fxmlFile)
//  {
//    if (addGameViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        addGameViewController = loader.getController();
//        addGameViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      addGameViewController.reset();
//    }
//    return addGameViewController.getRoot();
//  }
//  private Region loadAddClubAssociateViewController(String fxmlFile)
//  {
//    if (addClubAssociateViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        addClubAssociateViewController = loader.getController();
//        addClubAssociateViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      addClubAssociateViewController.reset();
//    }
//    return addClubAssociateViewController.getRoot();
//  }
//  private Region loadEventListViewController(String fxmlFile)
//  {
//    if (eventListViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        eventListViewController = loader.getController();
//        eventListViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      eventListViewController.reset();
//    }
//    return eventListViewController.getRoot();
//  }
//  private Region loadGameListViewController(String fxmlFile)
//  {
//    if (gameListViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        gameListViewController = loader.getController();
//        gameListViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      gameListViewController.reset();
//    }
//    return gameListViewController.getRoot();
//  }
//  private Region loadClubAssociateListViewController(String fxmlFile)
//  {
//    if (clubAssociateListViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        clubAssociateListViewController = loader.getController();
//        clubAssociateListViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      clubAssociateListViewController.reset();
//    }
//    return clubAssociateListViewController.getRoot();
//  }
//  private Region loadGameDetailsViewController(String fxmlFile)
//  {
//    if (gameDetailsViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        gameDetailsViewController = loader.getController();
//        gameDetailsViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      gameDetailsViewController.reset();
//    }
//    return gameDetailsViewController.getRoot();
//  }
//  private Region loadWishListViewController(String fxmlFile)
//  {
//    if (wishListViewController == null)
//    {
//      try
//      {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(fxmlFile));
//        Region root = loader.load();
//        wishListViewController = loader.getController();
//        wishListViewController.init(this, model, root);
//      }
//      catch (Exception e)
//      {
//        e.printStackTrace();
//      }
//    }
//    else
//    {
//      wishListViewController.reset();
//    }
//    return wishListViewController.getRoot();
//  }



}
