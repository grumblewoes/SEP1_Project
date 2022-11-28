import javafx.application.Application;
import javafx.stage.Stage;
import model.BoardGamesModel;
import model.BoardGamesModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    BoardGamesModel model = new BoardGamesModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
