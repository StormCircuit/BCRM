package desktopUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hibernate.controller.DatabaseController;
import hibernate.entity.Activity;
import hibernate.entity.Price;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class uiPriceHistoryController {
    uiPriceHistoryController uiPriceHistoryController;
    ObservableList<HistoricalPricesTableDataClass> historicalPricesTableData = FXCollections.observableArrayList();;
    ObservableList<ActivityTableDataClass> activityListMenu = FXCollections.observableArrayList();;
    List<Activity> listOfAllActivities = DatabaseController.getInstance().getAllActivity();
    Activity currSelectedActivity = listOfAllActivities.get(0);
    Stage primaryStage = new Stage();


    @FXML
    private TableView<HistoricalPricesTableDataClass> priceHistoryTable;

    @FXML
    private ComboBox<ActivityTableDataClass> menuSelectActivity;

    @FXML
    private Button buttonHome;

    @FXML
    private TableColumn<HistoricalPricesTableDataClass, String> columnPrice;

    @FXML
    private TableColumn<HistoricalPricesTableDataClass, String> columnDate;

    @FXML
    private Button buttonUpdatePrice;

    @FXML
    void buttonHomeClicked(ActionEvent event) throws IOException {
        this.primaryStage.hide();
        uiWelcomeController welcomeUI = new uiWelcomeController();
        welcomeUI.startWelcomeUI();

    }

    @FXML
    void menuSelectActivityClick(ActionEvent event) {
        this.currSelectedActivity = menuSelectActivity.getSelectionModel().getSelectedItem();
        this.tablePopulator();
    }

    @FXML
    void buttonUpdatePriceClick(MouseEvent event) {

    }

    void menuPopulator(){
        for (Activity var : listOfAllActivities){
            ActivityTableDataClass newData = new ActivityTableDataClass(var.getName(), var.getPrice(), var.getId());
            this.activityListMenu.add(newData);
        }
        this.menuSelectActivity.setItems(activityListMenu);
    }

    void tablePopulator(){
        for(Price j : currSelectedActivity.getPrices()){
            HistoricalPricesTableDataClass newData = new HistoricalPricesTableDataClass(String.valueOf(j.getPrice()), String.valueOf(j.getDate()));
            this.historicalPricesTableData.add(newData);
        }
        this.priceHistoryTable.setItems(historicalPricesTableData);
    }

    public void startPriceHistoryUI() throws IOException {

        //set this objects stage reference since this is where we come into the method.

        //startWelcoemUI is the entrypoint for this controller. It will get the FXML file,
        //set the class's uiPriceHistoryController var to the FXMLLoader's instance and then
        //call tablePopulate to fill it.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("priceHistoryUI.fxml"));
        Parent page = (Parent) loader.load();

        //we need to get the instance of the controller we just made so we can populate its table
        //recall we have to use the instance made by FXMLLoader
        uiPriceHistoryController = loader.getController();

        uiPriceHistoryController.columnPrice.setCellValueFactory(new PropertyValueFactory<HistoricalPricesTableDataClass, String>("columnName"));
        uiPriceHistoryController.columnDate.setCellValueFactory(new PropertyValueFactory<HistoricalPricesTableDataClass, String>("columnPrice"));
        uiPriceHistoryController.menuPopulator();
        

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        uiPriceHistoryController.primaryStage.setScene(scene);
        uiPriceHistoryController.primaryStage.setTitle("BCRM welcome");

        // finalize/show the window
        uiPriceHistoryController.primaryStage.show();
    }

}
