package model;

import java.util.ArrayList;

public class Game
{
  private String title;
  private String numberOfPlayers;
  private String type;
  private String description;
  private ClubAssociate owner;
  public static final String DEDUCTION="Deduction";
  public static final String ABSTRACT="Abstract";
  public static final String CITY_BUILDING="City Building";
  public static final String DECK_BUILDING="Deck Building";
  public static final String CARDS="Cards";
  private ArrayList<Rating> ratings=new ArrayList<Rating>();

  public Game(String title, ClubAssociate owner, String numberOfPlayers, String description)
  {
    this.title = title;
    this.owner = owner;
    this.numberOfPlayers = numberOfPlayers;
    this.description = description;
  }

  public boolean isAvailable()
  {
    if()
  }

  public boolean isReserved()
  {
    if()
  }

  public String getTitle()
  {
    return title;

  }

  public String getNumberOfPlayers()
  {
    return numberOfPlayers;
  }

  public String getType()
  {
    return type;
  }

  public String getDescription(){
    return description;
  }

  public Rating addRatings(){

    ratings.add();
  }

  double totalRatings;


  public double calculateAverageRating(){
    for(int index=0; index<ratings.size(); index++){
      totalRatings += ratings.get(index);
    }
    return totalRatings/ratings.size()-1;
  }

  public boolean equals(Object obj){
    if (obj==null ||this.getClass()!=obj.getClass()){
      return false;
    }
    Game g1= (Game)obj;
    return this.title.equals(g1.title) &&  this.description.equals(g1.description) &&
        this.numberOfPlayers.equals(g1.numberOfPlayers) && this.owner.equals(g1.owner) &&
        this.type.equals(g1.type);
  }

 public String toString()
 {
    return "This game is called " + title + " and it belongs to " + owner + ". It is from the type " + type +
        " and it supports a maximum of " + numberOfPlayers + " players. " + " Description: " + description;
 }

}
