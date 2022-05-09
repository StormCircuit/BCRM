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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class uiWelcomeController implements Initializable {
    static Stage primaryStage;
    static TableView<ActivityTableDataClass> tableRegisteredActivitiesAlias;
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
        primaryStage.hide();
        reportUIcontroller reportUI = new reportUIcontroller();
        reportUI.startReportUI();
    }

    //FXML code ends here
    private void tablePopulator(int BroncoID){
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomeUI.fxml"));
        Parent page = (Parent) loader.load();
        
        

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BCRM welcome");

        // finalize/show the window
        primaryStage.show();
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        
        columnName.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("ActivityName"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("ActivityPrice"));
        tableRegisteredActivitiesAlias = tableRegisteredActivities;
        //here is where javafx loses the tableview.
        //By the time startWelcomeUI is traversed it is gone.
        //tablePopulator(uiController.getID());
        System.out.println();
    }

}
