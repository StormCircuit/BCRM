import javafx.application.Application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;

// testing!
public class openingUI extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //primaryStage is taken from application class, it is the first stage the program will show.
        //recall that 'stages' are singular instances of windows

        //this is the first UI the program will open.
        //FXMLLoader takes our fxml file. We use getClass().getResource() to properly get the file. I am not sure why this is,
        //just that the docs specify it this way
        Parent page = (Parent)FXMLLoader.load(getClass().getResource("login.fxml"));
        
        //setup scene, primaryStage is our first stage we open 
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM Login");


        //finalize/show the window
        primaryStage.show();
    }
}