package desktopUI;
import hibernate.controller.*;

import java.io.IOException;

// testing!
public class uiController {

    // singleton setup
    private static final uiController uiController = new uiController();
    private static final uiLoginController loginUI = new uiLoginController();
    private static final uiWelcomeController welcomeUI = new uiWelcomeController();
    
    //GIVE ME A HARD CODED BRONCO ID FROM THE DB!!
    private static int BroncoID = 13657527;
    //private static String password;

    public static uiController getInstance() {
        return uiController;
    }

    // getting and setting
    
    public static void setBroncoID(int IDArg) {
        // set the BroncoID
        //THIS IS DEACTIVATED FOR NOW AS WE ARE USING A HARD CODED ID!!! THE ID WILL NOT CHANGE AND IS
        //ASSIGNED AT THE TOP!!!
        //BroncoID = IDArg;
    }

    public static int getID() {
        return BroncoID;
    }

    public static void showLoginUI() throws IOException {

        //call loginUI's startLoginUI method to initiate the login window
        loginUI.startLoginUI();

        //take parameters, now stored in the class vars and call the connect routine to verify the credentials
        //"verifying" means initiating a connection with their broncoID
        verifyLogIn();
        //System.out.println("Controller class sees: " + BroncoID);
    }

    public static void showWelcomeUI() throws IOException {
        welcomeUI.startWelcomeUI();
    }

    public static void verifyLogIn() {
        boolean access = DatabaseController.getInstance().verifyLogIn(BroncoID);
        if(access == false) {
            //reject
        }else if(access = true) {
            //log in
        }
    }
}