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
    static Stage primaryStage;
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
        //finalize the data in the db by sending the order

    }

    @FXML
    void buttonCancelAction(ActionEvent event) throws IOException {
        primaryStage.hide();
        uiRegisterController registerUI = new uiRegisterController();
        registerUI.startRegisterUI();

    }

    public void startOrderUI() throws IOException {

        //set this objects stage reference since this is where we come into the method.
        primaryStage = new Stage();

        Parent page = (Parent) FXMLLoader.load(getClass().getResource("orderUI.fxml"));

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM");

        // finalize/show the window
        primaryStage.showAndWait();
    }

}
