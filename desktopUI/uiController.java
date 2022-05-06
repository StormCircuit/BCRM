package desktopUI;
import hibernate.controller.*;
import java.io.IOException;

// testing!
public class uiController {

    // singleton setup
    private static final uiController uiController = new uiController();
    private static final uiLoginController loginUI = new uiLoginController();
    private static final uiWelcomeController welcomeUI = new uiWelcomeController();
    private static int BroncoID;
    //private static String password;

    public static uiController getInstance() {
        return uiController;
    }

    // getting and setting
    public static void setBroncoID(int IDArg) {
        // set the BroncoID
        BroncoID = IDArg;
    }

    public static int getID() {
        return BroncoID;
    }

    public static void showLoginUI() throws IOException {
        loginUI.startLoginUI();
        System.out.println("Controller class sees: " + BroncoID);
    }

    public static void showWelcomeUI() throws IOException {
        welcomeUI.startWelcomeUI();
    }

    public static void verifyLogIn(int BroncoID) {
        boolean access = DatabaseController.getInstance().verifyLogIn(BroncoID);
        if(access == false) {
            //reject
        }else if(access = true) {
            //log in
        }
    }
}