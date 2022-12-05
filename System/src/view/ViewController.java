package view;

import javafx.scene.layout.Region;
import model.BoardGamesModel;

import java.io.Serializable;

/**
 * An abstract class with the default functionality and variables of the controllers
 * 
 * 
 * @author Damian Trafiałek
 * @version 2.0 - 03 December 2022
 */
public abstract class ViewController implements Serializable
{
  protected Region root;

  protected ViewHandler viewHandler;

  protected BoardGamesModel model;

  /**
   * A method that returns the root region of the controller.
   * 
   *
   * @return root
   *        the region element of the controller
   */
  public Region getRoot(){ return root; }


  /**
   * 
   * 
   */
  public abstract void reset();


  /**
   * 
   * 
   * @param viewHandler 
   *        
   * @param model 
   *        
   * @param root 
   *        
   */
  public abstract void init(ViewHandler viewHandler, BoardGamesModel model, Region root);
}
