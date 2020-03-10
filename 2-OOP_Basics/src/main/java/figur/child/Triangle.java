package figur.child;

import figur.Figure;

import java.util.HashMap;

public class Triangle extends Figure {
    private static final String NAME = "Triangle";
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public Triangle(int x, int y, int x2, int y2, int x3, int y3) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public double getArea() {
        return (Math.abs((this.x2 - super.getX()) * (this.y3 - super.getY()) - (this.x3 - super.getX()) * (this.y2 - super.getY()))) / 2;
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
        coordinates.put("x3", this.getX3());
        coordinates.put("y3", this.getY3());
        return coordinates;
    }
}