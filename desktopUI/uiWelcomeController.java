package desktopUI;

import java.io.IOException;
import java.net.URL;

import hibernate.controller.DatabaseController;
import hibernate.entity.Activity;
import hibernate.entity.Order;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class uiWelcomeController {
    uiWelcomeController uiWelcomeController;
    Stage primaryStage = new Stage();
    ObservableList<ActivityTableDataClass> activityTableData = FXCollections.observableArrayList();

    //FXML scene builder code begins here


    @FXML
    public Button buttonLogout;

    @FXML
    public Button buttonOpenRegisterUI;

    @FXML
    public TableView<ActivityTableDataClass> tableRegisteredActivities;
    
    @FXML
    public TableColumn<ActivityTableDataClass, String> columnName;

    @FXML
    public TableColumn<ActivityTableDataClass, String> columnPrice;

    @FXML
    void buttonLogout(ActionEvent event) {

    }

    @FXML
    void buttonOpenRegisterUI(ActionEvent event) throws IOException {
        primaryStage.hide();
        uiRegisterController registerUI = new uiRegisterController();
        registerUI.startRegisterUI();

    }

    
    @FXML
    void buttonReportClicked(ActionEvent event) throws IOException {
        this.primaryStage.hide();
        uiReceiptController receiptUI = new uiReceiptController();
        receiptUI.startReceiptUI();
    }

    //FXML code ends here
    public void tablePopulator(int BroncoID){
        //update the ObservableList at the top with the orders.
        List<Order> listOfOrders = DatabaseController.getInstance().getActiveOrders(BroncoID);
        

        for (Order i : listOfOrders){
            for(Activity j : i.getItems()){
                //fill our array from each activity j
                //To do this we must create new ActivityTableDataClass objects and fill the array activityTableData with them.
                ActivityTableDataClass newData = new ActivityTableDataClass(j.getName(), j.getPrice());
                activityTableData.add(newData);
            }
        }
        //add all the activities to the ObservableList
        
        //set the table to use the list we just made
        //System.out.println(activityTableData.get(0).getColumnName());
        tableRegisteredActivities.setItems(activityTableData);
    }

    public void startWelcomeUI() throws IOException {

        //set this objects stage reference since this is where we come into the method.

        //startWelcoemUI is the entrypoint for this controller. It will get the FXML file,
        //set the class's uiWelcomeController var to the FXMLLoader's instance and then
        //call tablePopulate to fill it.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomeUI.fxml"));
        Parent page = (Parent) loader.load();

        //we need to get the instance of the controller we just made so we can populate its table
        //recall we have to use the instance made by FXMLLoader
        uiWelcomeController = loader.getController();

        uiWelcomeController.columnName.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnName"));
        uiWelcomeController.columnPrice.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnPrice"));
        uiWelcomeController.tablePopulator(uiController.getID());
        

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        uiWelcomeController.primaryStage.setScene(scene);
        uiWelcomeController.primaryStage.setTitle("BCRM welcome");

        // finalize/show the window
        uiWelcomeController.primaryStage.show();
    }
}
