package model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing the overall list of wishes, and manages them (adding, removing, and voting).
 * 
 * @author Anna Pomerantz
 * @version 1
 */
public class WishList implements Serializable
{
  private ArrayList<Wish> wishes;

  /**
   * 0-argument constructor initializing the empty list of wishes.
   */
  public WishList() {
    wishes = new ArrayList<Wish>();
  }

  /**
   * Method that returns an int for the number of votes for a wish given its
   * title.
   * @param title of the wish in question
   * @return the int value of the number of votes
   */
  public int getVotesForWish(String title) {
    //loops through list for the specified wish's title
    for (Wish wish : wishes)
    {
      if (wish.getTitle().equals(title))
        return wish.getVotes();
    }
    return -1;
  }

  /**
   * A method that calls the Wish class's increment method for the given wish.
   * @param wish for the wish to be incremented
   */
  public void voteForWish(Wish wish){
    wish.incrementVoteBy1();
  }

  /**
   *  Method that returns the list of wishes.
   * @return arraylist wishes
   */
  public ArrayList<Wish> getAllWishes() { return wishes; }

  /**
   * Method that adds a given wish to the list
   * @param wish the wish to be added
   */
  public void addWish(Wish wish) {
    wishes.add(wish);
  }

  /**
   * Method that removes a wish from the wishlist
   * @param wish wish to be removed
   */
  public void removeWish(Wish wish) { wishes.remove(wish); }

  /**
   * Method that returns a Wish object given its title
   * @param title the title of the Wish to be returned.
   *
   * @return Wish object
   *        
   */
  public Wish getWishByTitle(String title) {
    for (Wish wish : wishes)
    {
      if (wish.getTitle().equals(title))
        return wish;
    }
    return null;
  }

  /**
   * Method that loops through each wish in the wishlist and concatenates it to a string
   * @return arraylist wishes as a String
   *        
   */
  public String toString() {
    String txt = "";
    for (Wish wish : wishes)
    {
      txt = txt + wish + "\n";
    }
    return txt;
  }
}
