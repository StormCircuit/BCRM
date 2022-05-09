package desktopUI;

import java.io.IOException;
import java.util.List;

import hibernate.entity.Activity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class uiOrderController {
    Stage primaryStage;
    List<ActivityTableDataClass> newOrder;
    public uiOrderController(List<ActivityTableDataClass> ArgNewOrder){
        this.newOrder = ArgNewOrder;
    }

    @FXML
    private TableView<ActivityTableDataClass> tableOrder = new TableView<ActivityTableDataClass>();

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonCheckout;

    @FXML
    void tableSelectionClick(ActionEvent event) {

    }

    @FXML
    void buttonCheckoutAction(ActionEvent event) {

    }

    @FXML
    void buttonCancelAction(ActionEvent event) {

    }

    public void startOrderUI() throws IOException {

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
        Parent page = (Parent) FXMLLoader.load(getClass().getResource("orderUI.fxml"));

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM");

        // finalize/show the window
        primaryStage.showAndWait();
    }

}
