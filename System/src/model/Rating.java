package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author Jakub Cerovsky
 * @version 1.0 3 December 2022
 */
public class Rating implements Serializable
{
  int rating;
  public final static int LEGAL_RATINGS[] = { 1, 2, 3, 4, 5};
  /**
   * 1-argument constructor 
   * 
   * @throws IllegalArgumentException in case that rating is not legal value
   * @param rating 
   *        
   */
  public Rating(int rating)
{
  if (isLegalRating(rating))
  {
    this.rating=rating;
  }
  else
  {
    throw new IllegalArgumentException("Illegal rating: " + rating);
  }
}

  /**
   * 
   * Method that returns rating as an Integer
   *
   * @return rating as an Integer
   *        
   */
  public int getRating()
  {
    return rating;
  }

  /**
   * Method that is looping through legal ratings and returns if given one is legal or not
   * 
   * @param rating
   *
   * @return if the rating is a legal value
   *        
   */
  public static boolean isLegalRating(int rating)
  {
    for (int i = 0; i < LEGAL_RATINGS.length; i++)
    {
      if (rating == LEGAL_RATINGS[i])
      {
        return true;
      }
    }
    return false;
  }
}
