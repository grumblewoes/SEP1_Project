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
public class Rating implements Serializable
{
  int rating;
  public final static int LEGAL_RATINGS[] = { 1, 2, 3, 4, 5};
  /**
   * 1-argument constructor 
   * 
   * 
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
   * 
   *
   * @return 
   *        
   */
  public int getRating()
  {
    return rating;
  }

  /**
   * 
   * 
   * @param rating 
   *        
   *
   * @return 
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
