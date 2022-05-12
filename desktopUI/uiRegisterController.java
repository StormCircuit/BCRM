package desktopUI;

import java.io.IOException;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class uiRegisterController {
    Stage primaryStage;
    ObservableList<ActivityTableDataClass> activityTableData = FXCollections.observableArrayList();
    ObservableList<ActivityTableDataClass> newOrder = FXCollections.observableArrayList();
    ObservableList<Activity> listOfRegisterableActivities = FXCollections.observableArrayList();
    List<Activity> listOfAllActivities = new ArrayList<Activity>();
    uiRegisterController uiRegisterController;
    
    @FXML
    private Button buttonLogout;
    //IMPLEMENT LOGOUT! RETURN TO WELCOME* UI!

    @FXML
    private Text textWelcomeUser;

    @FXML
    private Button buttonOpenRegisterUI;

    @FXML
    private TableView<ActivityTableDataClass> tableAvailableActivities;
    
    @FXML
    private TableColumn<ActivityTableDataClass, String> columnPrice;

    @FXML
    private TableColumn<ActivityTableDataClass, String> columnName;

    @FXML
    private Button buttonAddToOrder;

    @FXML
    private Button buttonViewOrder;

    
    @FXML
    private Button buttonOpenWelcomeUI;

    @FXML
    void buttonOpenWelcomeUI(ActionEvent event) throws IOException {
        primaryStage.hide();
        uiWelcomeController welcomeUI = new uiWelcomeController();
        welcomeUI.startWelcomeUI();

    }

    @FXML
    void buttonLogout(ActionEvent event) {

    }

    @FXML
    void tableSelectionClick(MouseEvent event) {

    }

    @FXML
    void buttonAddToOrder(ActionEvent event) throws IOException {
        //if the selection is NOT empty, add it to the order
        if (tableAvailableActivities.getSelectionModel().getSelectedItem() != null){
            newOrder.add(tableAvailableActivities.getSelectionModel().getSelectedItem());
        }
        else {
            alertOrderEmptyUIcontroller alertUI = new alertOrderEmptyUIcontroller();
            alertUI.startAlertOrderEmptyUI();
        }

        //System.out.println(newOrder.get(0));
    }

    @FXML
    void buttonViewOrder(ActionEvent event) throws IOException {
        if(newOrder.isEmpty()){
            alertOrderEmptyUIcontroller alertUI = new alertOrderEmptyUIcontroller();
            alertUI.startAlertOrderEmptyUI();
        }
        else{
            uiOrderController orderUI = new uiOrderController();
            orderUI.startOrderUI(newOrder);
        }
    }

    //FXML code ends here

    //WARNING FOR YOUR EYES! HERE THERE BE A MESS OF IDEAS COMMENTED OUT!
    public void tablePopulator(int BroncoID){

        
        listOfAllActivities = DatabaseController.getInstance().getAllActivity();
        List<Order> listOfCustomerOrders = DatabaseController.getInstance().getActiveOrders(BroncoID);

        //For each activity in the list of customer orders (IE all their active orders)
        //make a new object in our observable list 'activityTableData'; this will be the final observable list
        //we use to print to the table.
        for (Order a : listOfCustomerOrders){
            for (Activity b : a.getItems()){
                for (Activity c : listOfAllActivities){
                    if (b.getName() != c.getName()){
                        ActivityTableDataClass newData = new ActivityTableDataClass(b.getName(), b.getPrice());
                        activityTableData.add(newData);
                    }
                }

            }
        }
        //set the table
        tableAvailableActivities.setItems(activityTableData);
    }

    public void startRegisterUI() throws IOException {

        //set this objects stage reference since this is where we come into the method.
        primaryStage = new Stage();

        //startRegisterUI is the entrypoint for this controller. It will get the FXML file,
        //set the class's uiRegisterController var to the FXMLLoader's instance and then
        //call tablePopulate to fill it.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registerUI.fxml"));
        Parent page = (Parent) loader.load();

        //we need to get the instance of the controller we just made so we can populate its table
        //recall we have to use the instance made by FXMLLoader
        uiRegisterController = loader.getController();

        uiRegisterController.columnName.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnName"));
        uiRegisterController.columnPrice.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnPrice"));
        uiRegisterController.tablePopulator(uiController.getID());
        
        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM register");

        // finalize/show the window
        primaryStage.show();
    }

}
