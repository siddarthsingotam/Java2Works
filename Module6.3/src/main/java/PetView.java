import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Point2D;

public class PetView {
    private Canvas canvas;
    private Image petImage;

    public PetView(double canvasWidth, double canvasHeight, String petImagePath) {
        this.canvas = new Canvas(canvasWidth, canvasHeight);
        this.petImage = new Image(petImagePath);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void drawPet(Point2D petLocation) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(petImage, petLocation.getX(), petLocation.getY());
    }
}