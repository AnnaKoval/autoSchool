package figur;

import java.util.HashMap;

public abstract class Figure {
    private int x;
    private int y;

    public abstract String getName();

    public abstract double getArea();

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public HashMap getCoordinates() {
        HashMap<String, Integer> coordinates = new HashMap<>();
        coordinates.put("x1", getX());
        coordinates.put("y1", getY());
        return coordinates;
    }
}
