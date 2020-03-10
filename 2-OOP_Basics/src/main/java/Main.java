import figur.Figure;
import figur.child.Circle;
import figur.child.Square;
import figur.child.Triangle;
import soft.FigureList;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FigureList figures = new FigureList();
        figures.initialize();

        figures.printFigure_List();
        figures.sortArea();
        System.out.println("SORTED LIST");
        figures.printFigure_List();
    }
}
