package desktopUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class reportUIcontroller {

    @FXML
    private TableView<?> reportTable;

    @FXML
    private Button buttonLogout;

    @FXML
    private Button buttonHome;

    @FXML
    void buttonHomeClicked(ActionEvent event) throws IOException {
        uiWelcomeController welcomeUI = new uiWelcomeController();
        welcomeUI.startWelcomeUI();

    }

    @FXML
    void buttonLogoutClicked(ActionEvent event) {

    }

}
