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
        //put the actual code to run here.
        //It sounds like we're gonna be using a session factory of sorts so this probably will not be handled by the UI controller
        System.out.println("Success!");

    }

}
