import javafx.application.Application;
import javafx.stage.Stage;
import model.BoardGamesModel;
import model.BoardGamesModelManager;
import model.Event;
import view.ViewHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A class that is responsible for the creation of the GUI.
 * 
 * 
 * @author Sep_Group_3
 * @version 1.5
 */
public class MyApplication extends Application
{
  /**
   * A method that creates the GUI. Initialises the model and imports it from the database (local file if exists).
   * 
   * @param primaryStage 
   *        the stage that is passed from javafx
   */
  public void start(Stage primaryStage)
  {
    BoardGamesModel model = new BoardGamesModelManager().getFileManager().importModelFromDatabase();

//    to check if it works you need to deactivate validation for dateTime in Event
//    model.addEvent(new Event("should expire in 15 seconds","lorem ipsum 50",LocalDateTime.now().minusDays(1).plusSeconds(15),"Canteen"));

    model.getFileManager().exportModelToDatabase();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
