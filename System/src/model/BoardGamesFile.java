package model;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BoardGamesFile
{
  private String xml;
  private BoardGamesModel model;

  public BoardGamesFile(BoardGamesModel model){
    this.model = model;
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
  }

  private void prepareFileContent(){
    ArrayList<Game> games = model.getAllGames();
    ArrayList<Wish> wishes = model.getAllWishes();
    ArrayList<Event> events = model.getAllEvents();

    for(Game game : games)addGame(game);
    for(Wish wish : wishes)addWish(wish);
    for(Event event : events)addEvent(event);
  }

  public boolean createFile(String filename){
    File file = new File(filename);
    PrintWriter out = null;

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
