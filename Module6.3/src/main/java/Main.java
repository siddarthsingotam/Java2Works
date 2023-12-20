import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create a Pet object with an initial location
        Pet pet = new Pet(new Point2D(0, 0));

        //Create a PetView object with a specified canvas size and pet image path
        PetView petView = new PetView(800, 600, "path/to/pet/image.png");

        // PetController object with the Pet and PetView objects
        PetController petController = new PetController(pet, petView);

        //Set up a Scene with the PetView's canvas
        Scene scene = new Scene(petView.getCanvas().getParent());

        //mouse event handlers for the Scene that call the PetController's methods
        scene.setOnMouseMoved(event -> petController.handleMouseMoved(event));
        scene.setOnMouseExited(event -> petController.handleMouseExited());

        //Stage and show the Scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Virtual Pet");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
