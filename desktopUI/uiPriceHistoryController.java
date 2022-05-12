package desktopUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class uiPriceHistoryController {
    uiPriceHistoryController uiPriceHistoryController;
    Stage primaryStage;

    @FXML
    private TableView<?> priceHistoryTable;

    @FXML
    private ComboBox<?> menuSelectAcitvity;

    @FXML
    private Button buttonHome;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnDate;

    void tablePopulator(){
        this.priceHistoryTable.setItems();
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

        uiPriceHistoryController.columnPrice.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnName"));
        uiPriceHistoryController.columnDate.setCellValueFactory(new PropertyValueFactory<ActivityTableDataClass, String>("columnPrice"));
        uiPriceHistoryController.tablePopulator();
        

        // setup scene, primaryStage is our first stage we open
        Scene scene = new Scene(page);
        uiPriceHistoryController.primaryStage.setScene(scene);
        uiPriceHistoryController.primaryStage.setTitle("BCRM welcome");

        // finalize/show the window
        uiPriceHistoryController.primaryStage.show();
    }

}
