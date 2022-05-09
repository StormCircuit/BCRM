package desktopUI;

import java.io.IOException;

import hibernate.controller.DatabaseController;
import hibernate.entity.Activity;
import hibernate.entity.Order;

import javafx.beans.property.StringProperty;
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
    static Stage primaryStage;
    ObservableList<ActivityTableDataClass> activityTableData;
    List<Activity> newOrder;
    List<Activity> listOfActivities = DatabaseController.getInstance().getAllActivity();

    private class ActivityTableDataClass extends Activity{
        public ActivityTableDataClass(String name, double price) {
            super(name, price);
        }

        private StringProperty activityName;
        private StringProperty activityPrice;

        public void setActivityName(String argActivityName){
            activityName.set(argActivityName);
        }

        public void setActivityPrice(String argPrice){
            activityPrice.set(argPrice);
        }

        public String getActivityName(){
            return activityName.get();
        }

        public String getActivityPrice(){
            return activityPrice.get();
        }

    }
    //FXML scene builder code begins here


    @FXML
    private Button buttonLogout;
    //IMPLEMENT LOGOUT! RETURN TO LOGIN UI!

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
    void buttonOpenRegisterUI(ActionEvent event) {

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
        /**
        Calendar c = Calendar.getInstance();
		Date date = c.getTime();
        DatabaseController.CreateOrder(date, "COUNTER", uiController.getID(), newOrder);
        */
    }

    @FXML
    void buttonViewOrder(ActionEvent event) {

    }

    //FXML code ends here
    private void tablePopulator(int BroncoID){
        //update the ObservableList at the top with the orders.
        listOfActivities = DatabaseController.getInstance().getAllActivity();

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
        

        for (Activity i : listOfActivities){
            //fill our array from each activity j
            //To do this we must create new ActivityTableDataClass objects and fill the array activityTableData with them.
            ActivityTableDataClass newData = new ActivityTableDataClass();
            newData.setActivityName(i.getName());
            newData.setActivityPrice(Double.toString(i.getPrice()));
            activityTableData.add(newData);
        }
        //add all the activities to the ObservableList
        tableRegisteredActivities.setItems(activityTableData);
    }

    public void startWelcomeUI() throws IOException {

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
        Parent page = (Parent) FXMLLoader.load(getClass().getResource("welcomeUI.fxml"));

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM welcome");

        // finalize/show the window
        tablePopulator(uiController.getID());
        primaryStage.showAndWait();
    }

}
