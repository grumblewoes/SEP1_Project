package view;

import javafx.scene.layout.Region;
import model.BoardGamesModel;

import java.io.Serializable;

public abstract class ViewController implements Serializable
{
  protected Region root;

  protected ViewHandler viewHandler;

  protected BoardGamesModel model;

  public Region getRoot(){ return root; }

  public ViewHandler getViewHandler() { return viewHandler; }

  public BoardGamesModel getModel() { return model; }


  public abstract void reset();

  public abstract void init(ViewHandler viewHandler, BoardGamesModel model, Region root);
}
