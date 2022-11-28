package view;

import javafx.scene.layout.Region;
import model.BoardGamesModel;

public abstract class ViewController
{
  private Region root;

  private ViewHandler viewHandler;

  private BoardGamesModel model;

  public Region getRoot(){ return root; }

  public ViewHandler getViewHandler() { return viewHandler; }

  public BoardGamesModel getModel() { return model; }

  public void setRoot(Region root) { this.root = root; }

  public void setViewHandler(ViewHandler viewHandler) { this.viewHandler = viewHandler; }

  public void setModel(BoardGamesModel model) { this.model = model; }

  public abstract void reset();

  public abstract void init(ViewHandler viewHandler, BoardGamesModel model, Region root);
}
