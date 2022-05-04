import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;

public class uiLoginController {

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

        System.out.println(userName);
        System.out.println(userPassword);

        // we would create a new login handler object and send the data here
        // or whatever library we end up using and however they do it.

        // do login verification/library object creation
    }
}
