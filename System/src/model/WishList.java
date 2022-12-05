package model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class WishList implements Serializable
{
  //getVotesForWish moved from Wish
  //add addWish to the class diagram
  private ArrayList<Wish> wishes;

  /**
   * 0-argument constructor 
   * 
   * 
   */
  public WishList() {
    wishes = new ArrayList<Wish>();
  }

  /**
   * 
   * 
   * @param title 
   *        
   *
   * @return 
   *        
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
   * 
   * 
   * @param wish 
   *        
   */
  public void voteForWish(Wish wish){
    wish.incrementVoteBy1();
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ArrayList<Wish> getAllWishes() { return wishes; }

  /**
   * 
   * 
   * @param w 
   *        
   */
  public void addWish(Wish w) {
    wishes.add(w);
  }

  /**
   * 
   * 
   * @param w 
   *        
   */
  public void removeWish(Wish w) { wishes.remove(w); }

  /**
   * 
   * 
   * @param title 
   *        
   *
   * @return 
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
   * 
   * 
   *
   * @return 
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
