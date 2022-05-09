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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class uiRegisterController {
    Stage primaryStage;
    ObservableList<ActivityTableDataClass> activityTableData;
    List<ActivityTableDataClass> newOrder;
    ObservableList<Activity> listOfActivities = FXCollections.observableArrayList(DatabaseController.getInstance().getAllActivity());
    
    @FXML
    private Button buttonLogout;
    //IMPLEMENT LOGOUT! RETURN TO WELCOME* UI!

    @FXML
    private Text textWelcomeUser;

    @FXML
    private Button buttonOpenRegisterUI;

    //why isnt this a method????
    @FXML
    private TableView<ActivityTableDataClass> tableRegisteredActivities = new TableView<ActivityTableDataClass>();

    @FXML
    void buttonLogout(ActionEvent event) {

    }

    @FXML
    private Button buttonAddToOrder;

    @FXML
    private Button buttonViewOrder;

    @FXML
    void tableSelectionClick(ActionEvent event) {

    }

    @FXML
    void buttonAddToOrder(ActionEvent event) {
        newOrder.add(tableRegisteredActivities.getSelectionModel().getSelectedItem());
        
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
        uiOrderController orderUI = new uiOrderController(newOrder);
        orderUI.startOrderUI();
    }

    //FXML code ends here

    //WARNING FOR YOUR EYES! HERE THERE BE A MESS OF IDEAS COMMENTED OUT!
    private void tablePopulator(int BroncoID){
        //update the ObservableList at the top with the orders.
        //listOfActivities = DatabaseController.getInstance().getAllActivity();

        //remove any activities that are already registered for.
        List<Order> listOfCustomerOrders = DatabaseController.getInstance().getActiveOrders(BroncoID);
        for (Order a : listOfCustomerOrders){
            for (Activity b : a.getItems()){
                for (Activity c : listOfActivities){
                    if (b.getName() == c.getName()){
                        listOfActivities.remove(b);
                    }
                }

            }
        }
        
        //REFACTOR AFTER EXTENDING ACTIVITY!!!
        
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
        tableRegisteredActivities.setItems(activityTableData);
    }

    public void startRegisterUI() throws IOException {

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
        Parent page = (Parent) FXMLLoader.load(getClass().getResource("registerUI.fxml"));

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM");

        // finalize/show the window
        tablePopulator(uiController.getID());
        primaryStage.showAndWait();
    }

}
