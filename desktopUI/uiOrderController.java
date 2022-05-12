package desktopUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hibernate.controller.DatabaseController;
import hibernate.entity.Activity;
import hibernate.entity.Order;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class uiOrderController {
    Stage primaryStage;
    ObservableList<ActivityTableDataClass> activityTableData = FXCollections.observableArrayList();
    ObservableList<ActivityTableDataClass> newOrder = FXCollections.observableArrayList();
    ObservableList<Activity> listOfRegisterableActivities = FXCollections.observableArrayList();
    List<Activity> listOfAllActivities = new ArrayList<Activity>();
    uiOrderController uiOrderController;
    uiRegisterController newRegisterUI;

    @FXML
    private TableView<ActivityTableDataClass> tableOrder;

    @FXML
    private TableColumn<ActivityTableDataClass, String> columnPrice;

    @FXML
    private TableColumn<ActivityTableDataClass, String> columnName;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonCheckout;

    @FXML
    void tableSelectionClick(MouseEvent event) {

    }

    @FXML
    void buttonCheckoutAction(ActionEvent event) throws IOException {
        //finalize the data in the db by sending the order
        Date currDate = new Date();
        //DatabaseController expects a list so we cast our ObservableList newOrder to a arrayListy newOrderList.
        List<Activity> newOrderList = new ArrayList<Activity>();
        for (ActivityTableDataClass i : newOrder){
            newOrderList.add(i);
        }
        //actually commit the order
        DatabaseController.getInstance().CreateOrder(currDate, "ONLINE-PENDING", uiController.getID(), newOrderList);
        //hide this window, make a new register ui.
        uiOrderController.primaryStage.hide();
        newRegisterUI.startRegisterUI();
    }

    @FXML
    void buttonCancelAction(ActionEvent event) throws IOException {
        uiOrderController.primaryStage.hide();
        newRegisterUI.startRegisterUI();
    }

    public void tablePopulator(int BroncoID){
        tableOrder.setItems(newOrder);
    }

    public void startOrderUI(ObservableList<ActivityTableDataClass> orderArray) throws IOException {



        //set this objects stage reference since this is where we come into the method.
        primaryStage = new Stage();

        //startRegisterUI is the entrypoint for this controller. It will get the FXML file,
        //set the class's uiRegisterController var to the FXMLLoader's instance and then
        //call tablePopulate to fill it.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orderUI.fxml"));
        Parent page = (Parent) loader.load();

        //we need to get the instance of the controller we just made so we can populate its table
        //recall we have to use the instance made by FXMLLoader
        uiOrderController = loader.getController();

        uiOrderController.newOrder = orderArray;

        //NPE
        uiOrderController.columnName.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnName"));
        uiOrderController.columnPrice.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnPrice"));
        uiOrderController.tablePopulator(uiController.getID());
        
        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM order");

        // finalize/show the window
        primaryStage.show();
    }

}
