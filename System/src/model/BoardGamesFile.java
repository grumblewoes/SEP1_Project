package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardGamesFile
{
  private final static String XML_FILE_PATH = "./System/src/xml/ModelData.xml";
  private final static String DATABASE_FILE_PATH = "./System/src/xml/DatabaseData.xml";
  private BoardGamesModel model;

  public BoardGamesFile(BoardGamesModel model){
    this.model = model;
  }

  public void getDobeDabaDatabase(){
    FileInputStream fos = null;
    ObjectInputStream in = null;
    BoardGamesModel newModel = null;

    try{
      File file = new File(DATABASE_FILE_PATH);
      fos=new FileInputStream(file);
      in=new ObjectInputStream(fos);

      newModel = (BoardGamesModel) in.readObject();

    }catch (IOException e){
      System.out.println("You are fucked up...3.1");
    }
    catch (ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
    finally
    {
      try{
        in.close();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
  }

  public void dobeDabaDatabase(){
    FileOutputStream fos = null;
    ObjectOutputStream out = null;

    try{
      File file = new File(DATABASE_FILE_PATH);
      fos=new FileOutputStream(file);
      out=new ObjectOutputStream(fos);

      out.writeObject(model);

    }catch (IOException e){
      System.out.println("You are fucked up...3.1");
    }
    finally
    {
      try{
        out.close();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
  }

  private String getContextFromDatabase(){

    String xml = "";

    File file= new File(XML_FILE_PATH);

    try{
      Scanner in = new Scanner(file);
      while( in.hasNext() )
        xml+=in.nextLine();
    }catch (Exception e){
      xml = "<root>"
          + "\n <games>"+
          "\n  </games>"+
          "\n  <wishes>"+
          "\n  </wishes>"+
          "\n  <events>"+
          "\n  </events>"+
          "\n  </root>";
    }


    return xml;
  }

  public void addGame(Game game){
    String xml = getContextFromDatabase();
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
    createFile();
  }
  public void addWish(Wish wish){
    String xml = getContextFromDatabase();
    String search = "<wishes>";
    int index = xml.indexOf(search);

    String temp = "\n <wish>"+
        "\n   <title>"+wish.getTitle()+"</title>"+
        "\n   <votes>"+wish.getVotes()+"</votes>"+
        "\n  </wish>";

    xml=xml.substring(0,index+search.length())+temp+xml.substring(index+search.length());
    createFile();
  }

  public void addEvent(Event event){
    String xml = getContextFromDatabase();
    String search = "<events>";
    int index = xml.indexOf(search);

    String temp = "\n <event>"+
        "\n   <title>"+event.getTitle()+"</title>"+
        "\n   <description>"+event.getDescription()+"</description>"+
        "\n   <date>"+event.getStringDate()+"</date>"+
        "\n </event>";

    xml=xml.substring(0,index+search.length())+temp+xml.substring(index+search.length());
    createFile();
  }

  private void prepareFileContent(){
    ArrayList<Game> games = model.getAllGames();
    ArrayList<Wish> wishes = model.getAllWishes();
    ArrayList<Event> events = model.getAllEvents();

    for(Game game : games)addGame(game);
    for(Wish wish : wishes)addWish(wish);
    for(Event event : events)addEvent(event);
  }

  public boolean createFile(){
    File file = new File(XML_FILE_PATH);
    PrintWriter out = null;

    String xml = getContextFromDatabase();
    prepareFileContent();

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
