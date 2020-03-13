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
    private Figure[] figure_List = new Figure[10];

    public void printFigureList() {
        for (Figure figure : figure_List) {
            System.out.println(figure.getName() + ", S = " + figure.getArea());
        }
    }

    public Figure[] sortByArea() {
        Arrays.sort(figure_List, new FigureComparator());
        return figure_List;
    }

    public FigureList initialize() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(4);
            if (randomNumber == 1) {
                figure_List[i] = new Triangle(1, 1, -2, 4, -2, -2);
            } else if (randomNumber == 2) {
                figure_List[i] = new Circle(20, 10, 10);
            } else {
                figure_List[i] = new Square(0, 0, 1, 1);
            }
        }
        return this;
    }
}
