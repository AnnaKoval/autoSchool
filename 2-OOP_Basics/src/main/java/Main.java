import soft.FigureList;

public class Main {
    public static void main(String[] args) {
        FigureList figures = new FigureList();
        figures.initialize();

        figures.printFigureList();
        figures.sortByArea();
        System.out.println("SORTED LIST");
        figures.printFigureList();
    }
}
