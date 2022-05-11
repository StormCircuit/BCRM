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

    //why isnt this a method????
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
    void tableSelectionClick(ActionEvent event) {

    }

    @FXML
    void buttonAddToOrder(ActionEvent event) {
        newOrder.add(tableAvailableActivities.getSelectionModel().getSelectedItem());
        System.out.print(newOrder);
        //get each selection (when user presses a button) and add it to an activity list.
        //this list will be passed to the databasecontroller wherever we finalize the order

        //CreateOrder(Date date,String status, int bronco_id, List<Activity> items)
        /*
        Calendar c = Calendar.getInstance();
		Date date = c.getTime();
        
        DatabaseController.getInstance().CreateOrder(date, "COUNTER", uiController.getID(), newOrder);
        */
    }

    @FXML
    void buttonViewOrder(ActionEvent event) throws IOException {
        if(newOrder == null){
            alertOrderEmptyUIcontroller alertUI = new alertOrderEmptyUIcontroller();
            alertUI.startAlertOrderEmptyUI();
        }
        else{
            uiOrderController orderUI = new uiOrderController(newOrder);
            orderUI.startOrderUI();
        }
    }

    //FXML code ends here

    //WARNING FOR YOUR EYES! HERE THERE BE A MESS OF IDEAS COMMENTED OUT!
    public void tablePopulator(int BroncoID){
        //update the ObservableList at the top with the orders.


        
        listOfAllActivities = DatabaseController.getInstance().getAllActivity();
        List<Order> listOfCustomerOrders = DatabaseController.getInstance().getActiveOrders(BroncoID);
        /*
        for (Activity i : listOfAllActivities){
            //int j = 0;

            //super simple casting, since we extend object. The multiline code is a previous implementation left
            //for legacy/bug fixing purposes.

            //the idea here is since I extended the Activity object to ActivityTableDataClass I can then simply cast it upwards
            //with no loss of data
            //listOfActivities.set(j, (ActivityTableDataClass) listOfActivities.get(j));



            //To do this we must create new ActivityTableDataClass objects and fill the ObservableList activityTableData with them.
            ActivityTableDataClass newData = new ActivityTableDataClass(i.getName(), i.getPrice());
            activityTableData.add(newData);

            //j++;
        }
        //remove any activities that are already registered for.
        */
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
        
        //REFACTOR AFTER EXTENDING ACTIVITY!!!
        /*
        for (Activity i : listOfActivities){
            //int j = 0;

            //super simple casting, since we extend object. The multiline code is a previous implementation left
            //for legacy/bug fixing purposes.

            //the idea here is since I extended the Activity object to ActivityTableDataClass I can then simply cast it upwards
            //with no loss of data
            //listOfActivities.set(j, (ActivityTableDataClass) listOfActivities.get(j));



            //To do this we must create new ActivityTableDataClass objects and fill the ObservableList activityTableData with them.
            ActivityTableDataClass newData = new ActivityTableDataClass(i.getName(), i.getPrice());
            activityTableData.add(newData);

            //j++;
        }
        //PREV IMPLEMENTATION: add all the activities to the ObservableList
        //tableRegisteredActivities.setItems(activityTableData);

        //Horrible attempt at casting a list of activities to an observable list of activity table data classes (down classing)
        //it didnt work.
        //ObservableList<ActivityTableDataClass> listOfTableFormattedActivities = listOfActivities;

        //add the observablelist of activities to the table.
        */
        System.out.println();
        tableAvailableActivities.setItems(activityTableData);
    }

    public void startRegisterUI() throws IOException {

        //set this objects stage reference since this is where we come into the method.
        primaryStage = new Stage();

        //startWelcoemUI is the entrypoint for this controller. It will get the FXML file,
        //set the class's uiWelcomeController var to the FXMLLoader's instance and then
        //call tablePopulate to fill it.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registerUI.fxml"));
        Parent page = (Parent) loader.load();

        //we need to get the instance of the controller we just made so we can populate its table
        //recall we have to use the instance made by FXMLLoader
        uiRegisterController = loader.getController();
        //uiWelcomeController.columnName.PropertyValueFactoryProperty<ActivityTableDataClass, String>("columnName");
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
