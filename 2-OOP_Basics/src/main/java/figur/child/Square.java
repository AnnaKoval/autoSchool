package figur.child;

import figur.Figure;

import java.util.HashMap;

public class Square extends Figure {
    private static final String NAME = "Square";
    private int x2;
    private int y2;

    public Square(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x) {
        this.x2 = x;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y) {
        this.y2 = y;
    }

    @Override
    public double getArea() {
        double side = Math.sqrt(Math.pow((this.x2 - super.getX()),2) + Math.pow((this.y2 - super.getY()), 2));
        return side * side;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public HashMap getCoordinates() {
        HashMap<String, Integer> coordinates = super.getCoordinates();
        coordinates.put("x2", this.getX2());
        coordinates.put("y2", this.getY2());
        return coordinates;
    }
}
