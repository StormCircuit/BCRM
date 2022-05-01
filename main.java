import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
// testing!
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {

        // setup the stage (creating various objects)
        Stage primaryStage = new Stage();
        StackPane primaryStackPane = new StackPane();
        primaryStage.setTitle("Main App");

        // setup the login input column (labels and input boxes)
        VBox loginColumn = new VBox();
        loginColumn.setSpacing(8);
        loginColumn.setPadding(new Insets(10, 10, 10, 10));
        loginColumn.getChildren().addAll(
                new Label("Username:"),
                new TextField(),
                new Label("Password:"),
                new PasswordField(),
                new Button("Login"));
        root.getChildren().addAll(loginColumn);

        // setup actions
        checkLogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // code goes here. Send the input information from username/password box to the
                // session factory for verification
            }
        });

        // setup formatting
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}