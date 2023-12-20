import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Step 1: Create a Pet object with an initial location
        Pet pet = new Pet(new Point2D(0, 0));

        // Step 2: Create a PetView object with a specified canvas size and pet image path
        PetView petView = new PetView(800, 600, "path/to/pet/image.png");

        // Step 3: Create a PetController object with the Pet and PetView objects
        PetController petController = new PetController(pet, petView);

        // Step 4: Set up a Scene with the PetView's canvas
        Scene scene = new Scene(petView.getCanvas().getParent());

        // Step 5: Set up mouse event handlers for the Scene that call the PetController's methods
        scene.setOnMouseMoved(event -> petController.handleMouseMoved(event));
        scene.setOnMouseExited(event -> petController.handleMouseExited());

        // Step 6: Create a Stage and show the Scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Virtual Pet");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
