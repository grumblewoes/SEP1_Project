package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Game implements Serializable
{
  private String title, numberOfPlayers, type, description;
  private ClubAssociate borrowedTo;
  private LocalDate borrowedFrom;
  private ClubAssociate owner;
  public static final String DEDUCTION="Deduction";
  public static final String ABSTRACT="Abstract";
  public static final String CITY_BUILDING="City Building";
  public static final String DECK_BUILDING="Deck Building";
  public static final String CARDS="Cards";
  private ArrayList<Rating> ratings;

  public Game(String title, ClubAssociate owner, String type, String numberOfPlayers, String description)
  {
    this.title = title;
    this.owner = owner;
    this.type=type;
    this.numberOfPlayers = numberOfPlayers;
    this.description = description;
    ratings=new ArrayList<Rating>();
    this.borrowedTo=null;
    this.borrowedFrom=null;
  }

  public boolean isAvailable()
  {
    if(borrowedTo==null)
      {
        return true;
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

  public String getBorrowedTo()
  {
    if(borrowedTo==null)
      return "Nobody borrows it";
    return borrowedTo.getFullName();
  }

  public void setBorrowedTo(ClubAssociate borrowedTo)
  {
    if(borrowedTo.isMember()==false){
      if(borrowedTo.equals(borrowedTo)){
        throw new IllegalArgumentException("Guest cannot borrow more then one game.\nPlease return game first.");
      }
    }
    this.borrowedTo=borrowedTo;
  }
  public void setBorrowedFrom(LocalDate borrowedFrom)
  {
    this.borrowedFrom=borrowedFrom;
  }

  public String getOwner()
  {
    return owner.getFullName();
  }

  public LocalDate getBorrowedFrom()
  {
    return borrowedFrom;
  }

  public void addRatings(Rating rating){
    ratings.add(rating);
  }


  public double calculateAverageRating(Game game){
    double totalRating = 0.0;
    for(int i=0; i<ratings.size(); i++){
        totalRating = ratings.get(i).getRating();
        i++;
      }
      return (double)(totalRating/ratings.size());
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

  public ArrayList<Rating> getRatings() { return ratings; }
}
