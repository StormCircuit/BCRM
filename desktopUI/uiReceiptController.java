package desktopUI;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class uiReceiptController {
    Stage primaryStage = new Stage();
    ObservableList<ActivityTableDataClass> newOrder = FXCollections.observableArrayList();
    uiWelcomeController welcomeUI = new uiWelcomeController();
    uiReceiptController uiReceiptController;

    @FXML
    private TableView<ActivityTableDataClass> receiptTable;

    @FXML
    private TableColumn<ActivityTableDataClass, String> columnPrice;

    @FXML
    private TableColumn<ActivityTableDataClass, String> columnName;

    @FXML
    private TableColumn<ActivityTableDataClass, String> columnActivity;

    @FXML
    private Button buttonHome;

    @FXML
    void buttonHomeClicked(ActionEvent event) throws IOException {
        this.primaryStage.hide();
        this.welcomeUI.startWelcomeUI();

    }

    void tablePopulator(){
        this.receiptTable.setItems(newOrder);
    }

    public void startReceiptUI(ObservableList<ActivityTableDataClass> newOrderArg) throws IOException {

        //set this objects stage reference since this is where we come into the method.

        //startWelcoemUI is the entrypoint for this controller. It will get the FXML file,
        //set the class's uiRegisterController var to the FXMLLoader's instance and then
        //call tablePopulate to fill it.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("receiptUI.fxml"));
        Parent page = (Parent) loader.load();

        //we need to get the instance of the controller we just made so we can populate its table
        //recall we have to use the instance made by FXMLLoader
        uiReceiptController = loader.getController();

        uiReceiptController.columnName.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnName"));
        uiReceiptController.columnPrice.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnPrice"));
        uiReceiptController.tablePopulator();
        
        uiReceiptController.newOrder = newOrderArg;

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        uiReceiptController.primaryStage.setScene(scene);
        uiReceiptController.primaryStage.setTitle("BCRM welcome");

        // finalize/show the window
        uiReceiptController.primaryStage.show();
    }

}
