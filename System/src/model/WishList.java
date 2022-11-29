package model;
import java.util.ArrayList;

public class WishList
{
  //getVotesForWish moved from Wish
  //add addWish to the class diagram
  private ArrayList<Wish> wishes;

  public WishList() {
    wishes = new ArrayList<Wish>();
  }

  public int getVotesForWish(String title) {
    //loops through list for the specified wish's title
    for (Wish wish : wishes)
    {
      if (wish.getTitle().equals(title))
        return wish.getVotes();
    }
    return -1;
  }

  public ArrayList<Wish> getAllWishes() { return wishes; }

  public void addWish(Wish w) {
    wishes.add(w);
  }

  public Wish getWishByTitle(String title) {
    for (Wish wish : wishes)
    {
      if (wish.getTitle().equals(title))
        return wish;
    }
    return null;
  }

  public String toString() {
    String txt = "";
    for (Wish wish : wishes)
    {
      txt = txt + wish + "\n";
    }
    return txt;
  }
}
