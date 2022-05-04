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
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(location);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
    }
}