package desktopUI;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

//THIS CLASS IS FOR TJ'S USE TO QUICKLY LAUNCH AND DEBUG UI! 
public class UIDebugStart extends Application{

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException{
        //do whatever
        uiController.showLoginUI();
        uiController.showWelcomeUI();
    }
}
