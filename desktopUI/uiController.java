package desktopUI;
import java.io.IOException;

// testing!
public class uiController {

    // singleton setup
    private static final uiController uiController = new uiController();
    private static final uiLoginController loginUI = new uiLoginController();
    private static final uiWelcomeController welcomeUI = new uiWelcomeController();
    private static String username;
    private static String password;

    public static uiController getInstance() {
        return uiController;
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

    public static void showLoginUI() throws IOException {
        loginUI.startLoginUI();
        System.out.println("Controller class sees: " + username);
    }

    public static void showWelcomeUI() throws IOException {
        welcomeUI.startWelcomeUI();
    }
}