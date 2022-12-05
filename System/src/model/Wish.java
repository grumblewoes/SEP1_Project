package model;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class Wish implements Serializable
{
  private String title;
  private int votes;

  /**
   * 1-argument constructor 
   * 
   * 
   * @param title 
   *        
   */
  public Wish(String title) {
    this.title = title;
    votes = 1; //starts at one because, in order to create a wish, it needs to have at least one vote
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String getTitle() {
    return title;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public int getVotes() { return votes; }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public int incrementVoteBy1() {
    return votes++;
  }

  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public String toString() {
    return "Title: " + title + ", Votes: " + votes;
  }
}
