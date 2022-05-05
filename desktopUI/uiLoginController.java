package desktopUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class uiLoginController {
    static Stage primaryStage;
    @FXML
    private PasswordField passwordFieldText;

    @FXML
    private Button loginFinalizeButton;

    @FXML
    private TextField usernameFieldText;

    @FXML
    void loginFinalizeButtonAction(ActionEvent clickEvent) {
        // put the actual code to run here.
        // It sounds like we're gonna be using a session factory of sorts so this
        // probably will not be handled by the UI controller
        System.out.println("Success!");
        String userName = usernameFieldText.getText();
        String userPassword = passwordFieldText.getText();

        // System.out.println(userName);
        // System.out.println(userPassword);

        LoginController.setUsername(userName);
        System.out.println("UI class says: " + userName);

        LoginController.setPassword(userPassword);


        //close the stage once the buttons clicked. Should return to the 'showAndWait' caller
        primaryStage.close();

        // we would create a new login handler object and send the data here
        // or whatever library we end up using and however they do it.

        // do login verification/library object creation
    }

    public void startLoginUI() throws IOException {

        //set this objects stage reference since this is where we come into the method.
        primaryStage = new Stage();

        // primaryStage is taken from application class, it is the first stage the
        // program will show.
        // recall that 'stages' are singular instances of windows

        // this is the first UI the program will open.
        // FXMLLoader takes our fxml file. We use getClass().getResource() to properly
        // get the file. I am not sure why this is,
        // just that the docs specify it this way
        // Parent page = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));
        Parent page = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM Login");

        // finalize/show the window
        primaryStage.showAndWait();
    }
}
