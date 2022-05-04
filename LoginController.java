import java.io.IOException;

import javafx.scene.*;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;

// testing!
public class LoginController {

    // singleton setup
    private static final LoginController LoginController = new LoginController();

    public static LoginController getInstance() {
        return LoginController;
    }

    // getting and setting
    public static String getUsername() {
        // return the username
    }

    public void startLoginUI(Stage primaryStage) throws IOException {
        // primaryStage is taken from application class, it is the first stage the
        // program will show.
        // recall that 'stages' are singular instances of windows

        // this is the first UI the program will open.
        // FXMLLoader takes our fxml file. We use getClass().getResource() to properly
        // get the file. I am not sure why this is,
        // just that the docs specify it this way
        Parent page = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM Login");

        // finalize/show the window
        primaryStage.show();
    }
}