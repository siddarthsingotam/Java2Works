import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class PetController {
    private Pet pet;
    private PetView petView;
    private double speed = 2.0; // Adjust the speed as needed

    public PetController(Pet pet, PetView petView) {
        this.pet = pet;
        this.petView = petView;
    }

    public void handleMouseMoved(MouseEvent event) {
        Point2D mouseLocation = new Point2D(event.getX(), event.getY());
        movePetTowards(mouseLocation);
    }

    private void movePetTowards(Point2D targetLocation) {
        Point2D petLocation = pet.getLocation();
        Point2D direction = targetLocation.subtract(petLocation).normalize();
        Point2D newLocation = petLocation.add(direction.multiply(speed));

        pet.setLocation(newLocation);
        petView.drawPet(newLocation);
    }

    public void handleMouseExited() {
        // Stop pet movement when mouse exits canvas
    }
}