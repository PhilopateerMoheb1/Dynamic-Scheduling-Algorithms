package processmanager;

import java.awt.Point;
import java.util.ArrayList;

public class TextCoordinates {
    private String text;
    private Point coordinates;

    public TextCoordinates(String text, Point coordinates) {
        this.text = text;
        this.coordinates = coordinates;
    }

    public String getText() {
        return text;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }
}