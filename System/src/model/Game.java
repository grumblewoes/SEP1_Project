package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class representing a game in board games collection
 * Is responsible for answering question : what game, what type, to whom it is borrowed and when and who is the owner
 * 
 * @author Catarina de Jesus
 * @version 1.0 - 03 December 2022
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
   * @param title  title of the game
   *        
   * @param owner owner of the game
   *        
   * @param type type of the game
   *        
   * @param numberOfPlayers number of players in the game
   *        
   * @param description description of the game
   *        
   */
  public Game(String title, ClubAssociate owner, String type, String numberOfPlayers, String description)
  {
    //validate the input:
    //1.game must have a title
    //2.the owner cannot be null
    //3.type cannot be empty
    //4.string numberOfPlayers ? why not integer??
    //5.description can posibbly be empty? idk
    // throw proper exceptions
    setTitle(title);
    setOwner(owner);
    setType(type);
    setNumberOfPlayers(numberOfPlayers);
    setDescription(description);
    ratings=new ArrayList<Rating>();
    this.borrowedTo=null;
    this.borrowedFrom=null;
  }

  /**
   * 
   * Methods that returns whether the game is available or not
   *
   * @return boolean depending on if the game is available or not
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
   * Method that returns the title of the game as a String
   *
   * @return title of the game
   *        
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * 
   * Method that returns the number of players in game as a String
   *
   * @return number of players
   *        
   */
  public String getNumberOfPlayers()
  {
    return numberOfPlayers;
  }

  public void setTitle(String title)
  {
    if(title==null){
      throw new IllegalArgumentException("Title cannot be null.");
    }
    this.title = title;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setNumberOfPlayers(String numberOfPlayers)
  {

    this.numberOfPlayers = numberOfPlayers;
  }

  public void setOwner(ClubAssociate owner)
  {
    if(owner==null){
      throw new IllegalArgumentException("Owner has to be declared.");
    }
    this.owner=owner.copy();
  }

  public void setType(String type) {
    switch (type){
      case DEDUCTION:
        this.type = DEDUCTION;
        break;
      case DECK_BUILDING:
        this.type = DECK_BUILDING;
        break;
      case CITY_BUILDING:
        this.type = CITY_BUILDING;
        break;
      case CARDS:
        this.type = CARDS;
        break;
      default:
        this.type = ABSTRACT;
    }
  }
  /**
   *
   * Method that returns the type of the game as a String
   *
   * @return type of the game
   *
   */
  public String getType()
  {
    return type;
  }

  /**
   *
   * Method that returns the description of the game as a String
   *
   * @return description of the game
   *
   */
  public String getDescription(){
    return description;
  }

  /**
   *
   * Method that returns whether the game is available or borrowed, if so, by whom.
   *
   * @return depending on whether the game is available or borrowed
   *
   */
  public String getBorrowedToName()
  {
    if(borrowedTo==null)
      return "Available";
    return "Borrowed by "+borrowedTo.getFullName();
  }
  /**
   *
   * Method that returns the ID of a person by whom the game is borrowed
   *
   * @return if the game is borrowed, then person's ID, if not, then 0
   *
   */
  public int getBorrowedToID(){
    if(borrowedTo==null){
      return 0;
    }
    return borrowedTo.getSchoolId();
  }

  public void setBorrowedTo(ClubAssociate borrowedTo)
  {
    this.borrowedTo=borrowedTo;
  }
  public void setBorrowedFrom(LocalDate borrowedFrom)
  {
    this.borrowedFrom=borrowedFrom;
  }

  /**
   * 
   * Method that returns the name and surname of the game's owner as a String
   *
   * @return Full Name
   *        
   */
  //getOwner would indicate clubAssociate => change name that would indicate their name or String value
  public String getOwnerFullName()
  {
    return owner.getFullName();
  }
  /**
   *
   * Method that returns the owner of the game
   *
   * @return owner
   *
   */
  //getOwner would indicate clubAssociate => change name that would indicate their name or String value
  public ClubAssociate getOwner()
  {
    return owner;
  }
  /**
   * 
   * Method that returns the date from which the game was borrowed as LocalDate
   *
   * @return borrowed from (date)
   *        
   */
  public LocalDate getBorrowedFrom()
  {
    return borrowedFrom;
  }

  /**
   * Method that adds the given rating to the ratings list
   * 
   * @param rating 
   *        
   */
  public void addRatings(Rating rating){
    ratings.add(rating);
  }

  /**
   *
   * Method that calculates the average rating of the game
   *
   * @return average rating
   *        
   */
  public double calculateAverageRating(){
    double totalRating = 0.0;
    for(int i=0; i<ratings.size(); i++){
        totalRating += ratings.get(i).getRating();
      }
    if (ratings.size() > 0)
      return (double)(totalRating/ratings.size());
    return -1;
  }

  /**
   * 
   * Method that compares an object to the current one
   *
   * @param obj 
   *
   * @return boolean depending on if the objects passed as a parameter has the same content as the current one
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
  * Method that returns the string representation of the game
  *
  * @return string of game's information
  *        
  */
 public String toString()
 {
    return "This game is called " + title + " and it belongs to " + owner + ". It is from the type " + type +
        " and it supports a maximum of " + numberOfPlayers + " players. " + " Description: " + description;
 }

  /**
   * Method that returns the list of ratings
   * 
   *
   * @return ratings from the list
   *        
   */
  public ArrayList<Rating> getRatings() { return ratings; }
}
