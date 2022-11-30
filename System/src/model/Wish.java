package model;

public class Wish
{
  private String title;
  private int votes;

  public Wish(String title) {
    this.title = title;
    votes = 1; //starts at one because, in order to create a wish, it needs to have at least one vote
  }

  public String getTitle() {
    return title;
  }

  public int getVotes() { return votes; }

  public int incrementVoteBy1() {
    return votes++;
  }

  public String toString() {
    return "Title: " + title + ", Votes: " + votes;
  }
}
