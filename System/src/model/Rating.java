package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Rating implements Serializable
{
  int rating;
  public final static int LEGAL_RATINGS[] = { 1, 2, 3, 4, 5};
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

  public int getRating()
  {
    return rating;
  }

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
