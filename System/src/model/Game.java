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
    if(games.size()!=0)
      {
        for (int i = 0; i < games.size(); i++)
        {
          if (this.title.equals(games.get(i)))
          {
            return true;
          }
          return false;
        }
      }
      return false;
  }

  public boolean isReserved()
 {
   if(reservations.size()!=0)
      {
        for (int i = 0; i < reservations.size(); i++)
        {
          if (this.title.equals(reservations.get(i)))
          {
            return true;
          }
          return false;
        }
      }
      return false;

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
    for(int i=0; i<games.size(); i++)
    {
      if (rating.isLegalRating())
      {
        ratings.add(rating);
      }
    }
  }

 double totalRatings=0.0;


  public double calculateAverageRating(){
      for(int i=0; i<ratings.size()-1; i++){
        totalRatings += ratings.get(i);
        i++;
      }
      return (double)(totalRatings/ratings.size());
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
