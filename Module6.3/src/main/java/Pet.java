import javafx.geometry.Point2D;

public class Pet {
    private Point2D location;

    public Pet(Point2D location) {
        this.location = location;
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }
}
