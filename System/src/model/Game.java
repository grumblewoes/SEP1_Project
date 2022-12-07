package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
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

  /**
   * 5-argument constructor 
   * 
   * 
   * @param title 
   *        
   * @param owner 
   *        
   * @param type 
   *        
   * @param numberOfPlayers 
   *        
   * @param description 
   *        
   */
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

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public boolean isAvailable()
  {
    if(borrowedTo==null)
      {
        return true;
      }
    return false;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getNumberOfPlayers()
  {
    return numberOfPlayers;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getType()
  {
    return type;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getDescription(){
    return description;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getBorrowedTo()
  {
    if(borrowedTo==null)
      return "Available";
    return "Borrowed by "+borrowedTo.getFullName();
  }

  /**
   * 
   * 
   * @param borrowedTo 
   *        
   */
  public void setBorrowedTo(ClubAssociate borrowedTo)
  {
    this.borrowedTo=borrowedTo;
  }
  /**
   * 
   * 
   * @param borrowedFrom 
   *        
   */
  public void setBorrowedFrom(LocalDate borrowedFrom)
  {
    this.borrowedFrom=borrowedFrom;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getOwner()
  {
    return owner.getFullName();
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public LocalDate getBorrowedFrom()
  {
    return borrowedFrom;
  }

  /**
   * 
   * 
   * @param rating 
   *        
   */
  public void addRatings(Rating rating){
    ratings.add(rating);
  }


  /**
   *
   *        
   *
   * @return 
   *        
   */
  public double calculateAverageRating(){
    double totalRating = 0.0;
    for(int i=0; i<ratings.size(); i++){
        totalRating = ratings.get(i).getRating();
        i++;
      }
    if (ratings.size() > 0)
      return (double)(totalRating/ratings.size());
    return -1;
  }

  /**
   * 
   * 
   * @param obj 
   *        
   *
   * @return 
   *        
   */
  public boolean equals(Object obj){
    if (obj==null ||this.getClass()!=obj.getClass()){
      return false;
    }
    Game g1= (Game)obj;
    return this.title.equals(g1.title) &&  this.description.equals(g1.description) &&
        this.numberOfPlayers.equals(g1.numberOfPlayers) && this.owner.equals(g1.owner) &&
        this.type.equals(g1.type);
  }

 /**
  * 
  * 
  *
  * @return 
  *        
  */
 public String toString()
 {
    return "This game is called " + title + " and it belongs to " + owner + ". It is from the type " + type +
        " and it supports a maximum of " + numberOfPlayers + " players. " + " Description: " + description;
 }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Rating> getRatings() { return ratings; }
}
