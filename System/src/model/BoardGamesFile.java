package model;

public class BoardGamesFile
{
  private String xml;

  public BoardGamesFile(){
    this.xml="<root>"
        + "\n<games>"+
         "\n</games>"+
         "\n<wishes>"+
         "\n</wishes>"+
         "\n<events>"+
         "\n</events>"+
         "\n</root>";

  }

  public void addGame(Game game){
    int index = xml.indexOf("<games>");
    String temp = "<\ngame>"+
        "\n<title>"+game.getTitle()+"</title>"+
        "\n<numberOfPlayers>"+game.getTitle()+"</numberOfPlayers>"+
        "\n<type>"+game.getTitle()+"</type>"+
        "\n<description>"+game.getTitle()+"</description>"+
        "\n<borrowedTo>"+game.getTitle()+"</borrowedTo>"+
        "\n<owner>"+game.getTitle()+"</owner>"+
        "\n<ratings>"+game.getTitle()+"</ratings>"+
        "\n<game>";

  }


}
