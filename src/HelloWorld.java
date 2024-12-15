import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Label with "Hello, World!"
        Label helloLabel = new Label("Hello, World!");

        // Create a layout and add the Label to it
        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);

        // Create a Scene with the layout and set its size
        Scene scene = new Scene(root, 400, 300);

        // Set the stage (window) properties
        primaryStage.setTitle("Hello World JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
