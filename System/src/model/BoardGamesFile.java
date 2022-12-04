package model;

import java.io.*;
import java.util.ArrayList;

/**
 * A class that is responsible for importing and exporting the BoardGamesModel to and from local file (local database).
 * While exporting the model (saving the data) it also creates/overwrite xml file with data that is to be used on the website (events,wishes,games).
 * 
 * 
 * @author Damian Trafiałek
 * @version 2.0 - 03 December 2022
 */
public class BoardGamesFile implements Serializable
{
  private final static String XML_FILE_PATH = "xml.xml";
  private final static String DATABASE_FILE_PATH = "database.bin";
  private BoardGamesModel model;

  /**
   * 1-argument constructor creating a new BoardGamesFile instance. Taking model reference as a parameter it will be used to change it - import/export.
   * 
   * 
   * @param model 
   *        the current instance of the BoardGamesModel
   */
  public BoardGamesFile(BoardGamesModel model){
    this.model = model;
  }

  /**
   * A method returning the model that is to be used for this run of the application.
   *
   * @return imported/previous BoardGamesModel with all its data or a new instance of the model if one doesn't exist
   *        
   */
  public BoardGamesModel importModelFromDatabase(){
    FileInputStream fis = null;
    ObjectInputStream in = null;
    BoardGamesModel newModel = null;

    try{
      File file = new File(DATABASE_FILE_PATH);
      fis=new FileInputStream(file);
      in=new ObjectInputStream(fis);

      newModel = (BoardGamesModel) in.readObject();

    }catch (IOException e){
      System.out.println("ALLERT : No previous or current model exists in database. Generating a new model...");
      System.out.println("NOTE   : Every slightest change in the code may result that the previous model will be redundant thus impossible to import: ");
      System.out.println("         EXAMPLE : A new model has a method that the old one didn't have. They are incompatible and a new model must be created.");
      System.out.println("");
    }
    catch (ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
    finally
    {
      try{
        if(in!=null)
          in.close();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    return newModel==null ? new BoardGamesModelManager() : newModel;
  }

  /**
   * A method that saves the current model with its data to the local binary file.
   * 
   */
  public void exportModelToDatabase(){
    FileOutputStream fos = null;
    ObjectOutputStream out = null;

    try{
      File file = new File(DATABASE_FILE_PATH);
      fos=new FileOutputStream(file);
      out=new ObjectOutputStream(fos);

      out.writeObject(model);

    }catch (IOException e){
      System.out.println("Unable to save the model: "+e.getMessage());
    }
    finally
    {
      try{
        out.close();
      }catch (IOException e){
        e.printStackTrace();
      }
      createXMLFile();
    }
  }


  private String addGame(Game game,String xml){
    String search = "<games>";
    int index = xml.indexOf(search);

    String ratingsTemp = "";
    ArrayList<Rating> ratings = game.getRatings();
    for(Rating rating : ratings)
      ratingsTemp+="\n  <rating>"+rating.getRating()+"</rating>";

    String temp = "\n <game>"+
        "\n   <title>"+game.getTitle()+"</title>"+
        "\n   <numberOfPlayers>"+game.getNumberOfPlayers()+"</numberOfPlayers>"+
        "\n   <type>"+game.getType()+"</type>"+
        "\n   <description>"+game.getDescription()+"</description>"+
        "\n   <borrowedTo>"+game.getBorrowedTo()+"</borrowedTo>"+
        "\n   <owner>"+game.getOwner()+"</owner>"+
        "\n   <ratings>"+ratingsTemp+"</ratings>"+
        "\n </game>";

    xml=xml.substring(0,index+search.length())+temp+xml.substring(index+search.length());
    return xml;
  }

  private String addWish(Wish wish,String xml){
    String search = "<wishes>";
    int index = xml.indexOf(search);

    String temp = "\n <wish>"+
        "\n   <title>"+wish.getTitle()+"</title>"+
        "\n   <votes>"+wish.getVotes()+"</votes>"+
        "\n  </wish>";

    xml=xml.substring(0,index+search.length())+temp+xml.substring(index+search.length());
    return xml;
  }


  private String addEvent(Event event,String xml){
    String search = "<events>";
    int index = xml.indexOf(search);

    String temp = "\n <event>"+
        "\n   <title>"+event.getTitle()+"</title>"+
        "\n   <description>"+event.getDescription()+"</description>"+
        "\n   <date>"+event.getStringDate()+"</date>"+
        "\n </event>";

    xml=xml.substring(0,index+search.length())+temp+xml.substring(index+search.length());
    return xml;
  }



  private String prepareFileContent(){
    ArrayList<Game> games = model.getAllGames();
    ArrayList<Wish> wishes = model.getAllWishes();
    ArrayList<Event> events = model.getAllEvents();

    String xml = xml =
        "<root>" +
        "\n <games>"+
        "\n  </games>"+
        "\n  <wishes>"+
        "\n  </wishes>"+
        "\n  <events>"+
        "\n  </events>"+
        "\n  </root>";
    for(Game game : games) xml=addGame(game,xml);
    for(Wish wish : wishes) xml=addWish(wish,xml);
    for(Event event : events) xml=addEvent(event,xml);

    return xml;
  }


  private boolean createXMLFile(){
    File file = new File(XML_FILE_PATH);
    PrintWriter out = null;

    String xml = prepareFileContent();

    System.out.println("creating the file...");
    try{
      out=new PrintWriter(file);
      out.print(xml);
      out.flush();
      System.out.println("successfully created the file...");
      return true;
    }
    catch (Exception e){
      System.out.println("exception occured: "+ e.getMessage());
      return false;
    }
  }


}
