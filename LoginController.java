import java.io.IOException;

// testing!
public class LoginController {

    // singleton setup
    private static final LoginController LoginController = new LoginController();
    private static final uiLoginController loginUI = new uiLoginController();
    private static String username;
    private static String password;

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

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void showUI() throws IOException {
        loginUI.startLoginUI();
        System.out.println("Controller class sees: " + username);
    }
}