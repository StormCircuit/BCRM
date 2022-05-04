import java.io.IOException;

import javafx.scene.*;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;

// testing!
public class LoginController {

    // singleton setup
    private static final LoginController LoginController = new LoginController();
    private static String username;
    private static String password;

    private static uiLoginController loginUI = new uiLoginController();

    public static LoginController getInstance() {
        return LoginController;
    }

    // getting and setting
    public static void setUsername(String usernameArg) {
        // set the username
        username = usernameArg;
    }

    public static void setPassword(String passwordArg) {
        password = passwordArg;
    }

    public static void showUI() {
        uiLoginController.startLoginUI();
    }
}