package model;

import java.io.Serializable;

/**
 * A class representing a desired game that club associates could potentially
 * want to include in the association's game collection.
 *
 * @author Anna Pomerantz
 * @version 1
 */
public class Wish implements Serializable
{
  private String title;
  private int votes;

  /**
   * 1-argument constructor.
   * @param title sets the private variable to the input title
   */
  public Wish(String title) {
    this.title = title;
    votes = 1; //starts at one because, in order to create a wish, it needs to have at least one vote
  }

  /**
   * Method that returns the title of the wish as a String.
   * @return the title of the wish
   */
  public String getTitle() {
    return title;
  }

  /**
   * Method that returns the number of votes for a wish as an int.
   * @return the number of votes
   */
  public int getVotes() { return votes; }

  /**
   * Method that returns an integer of the previous value increased by 1.
   */
  public void incrementVoteBy1() {
    votes = votes + 1;
  }

  /**
   * Method that returns a description of the wish as a String.
   * @return the string representation of the wish as "Title: {title}, Votes: {votes}"
   */
  public String toString() {
    return "Title: " + title + ", Votes: " + votes;
  }
}
