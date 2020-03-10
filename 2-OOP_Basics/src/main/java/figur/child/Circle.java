package figur.child;

import figur.Figure;

public class Circle extends Figure {
    private static final String NAME = "Circle";
    private double radius;

    public Circle(double radius, int x, int y) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
