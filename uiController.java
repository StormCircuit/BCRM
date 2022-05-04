import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class uiController {

    @FXML
    private TextField usernameField;

    @FXML
    private Button loginFinalizeText;

    @FXML
    private TextField passwordField;

    @FXML
    void loginFinalizeAction(ActionEvent event) {
        //create a session here with login info. We should directly pass this information to a dedicated session handler.

    }

}
