package soft;

import figur.Figure;
import figur.child.Circle;
import figur.child.Square;
import figur.child.Triangle;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FigureList {
    Figure[] figure_List = new Figure[10];
    int counter;

    public void add(Figure f) {
        figure_List[counter++] = f;
    }

    public void printFigure_List() {
        for (Figure figure : figure_List) {
            if (figure != null) {
                System.out.println(figure.getName() + ", S = " + figure.getArea());
            }
        }
    }

    public Figure[] sortArea() {
        Arrays.sort(figure_List, new FigureComparator());
        return figure_List;
    }

    public FigureList initialize() {
        ArrayList<Figure> figures = new ArrayList<>();
        Random random = new Random();
        Triangle triangle = new Triangle(1, 1, -2, 4, -2, -2);
        Circle circle = new Circle(20, 10, 10);
        Square square = new Square(0, 0, 1, 1);

        figures.add(triangle);
        figures.add(circle);
        figures.add(triangle);
        figures.add(square);
        figures.add(circle);
        figures.add(triangle);
        figures.add(triangle);
        figures.add(square);
        figures.add(triangle);
        figures.add(triangle);
        figures.add(triangle);
        figures.add(square);
        figures.add(square);
        figures.add(triangle);

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(11);
            this.add(figures.get(randomNumber));
        }
        return this;
    }
}
