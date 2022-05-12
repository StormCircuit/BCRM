package desktopUI;

import java.io.IOException;
import java.util.List;

import hibernate.controller.DatabaseController;
import hibernate.entity.Customer;
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

public class uiReportController {
    Stage primaryStage = new Stage();
    ObservableList<CustomerTableDataClass> customers = FXCollections.observableArrayList();
    uiWelcomeController welcomeUI = new uiWelcomeController();
    uiReportController uiReportController;

    @FXML
    private TableView<CustomerTableDataClass> reportTable;

    @FXML
    private TableColumn<CustomerTableDataClass, String> columnRevenue;

    @FXML
    private TableColumn<CustomerTableDataClass, String> columnName;

    @FXML
    private Button buttonHome;

    @FXML
    void buttonHomeClicked(ActionEvent event) throws IOException {
        this.primaryStage.hide();
        this.welcomeUI.startWelcomeUI();

    }

    void tablePopulator(){
        List<Customer> listOfCustomers = DatabaseController.getInstance().getAllCustomers();
        for (Customer var : listOfCustomers){
            CustomerTableDataClass varTable = new CustomerTableDataClass(var.getName(), DatabaseController.getInstance().getTotalRevenue(var.getBronco_id()));
            //System.out.println(varTable.columnNameProperty().get());
            customers.add(varTable);
        }
        this.reportTable.setItems(customers);
    }

    public void startReportUI() throws IOException {

        //set this objects stage reference since this is where we come into the method.

        //startWelcoemUI is the entrypoint for this controller. It will get the FXML file,
        //set the class's uiRegisterController var to the FXMLLoader's instance and then
        //call tablePopulate to fill it.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("financialreportUI.fxml"));
        Parent page = (Parent) loader.load();

        //we need to get the instance of the controller we just made so we can populate its table
        //recall we have to use the instance made by FXMLLoader
        uiReportController = loader.getController();

        uiReportController.columnName.setCellValueFactory(new PropertyValueFactory<CustomerTableDataClass, String>("columnName"));
        uiReportController.columnRevenue.setCellValueFactory(new PropertyValueFactory<CustomerTableDataClass, String>("columnRevenue"));
        
        uiReportController.tablePopulator();

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        uiReportController.primaryStage.setScene(scene);
        uiReportController.primaryStage.setTitle("BCRM report");

        // finalize/show the window
        uiReportController.primaryStage.show();
    }

}
