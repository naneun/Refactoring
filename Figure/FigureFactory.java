public class FigureFactory {
    private static int LINE = 2;
    private static int TRIANGLE = 3;
    private static int SQUARE = 4;
    private static int SQUARE2 = 1;

    public Figure getFigure(int pointCnt, Point[] points) throws ArgumentException {
        Figure figure = null;
        if (pointCnt == SQUARE2 || pointCnt == SQUARE) {
            figure = new Square(points);
        } else if (pointCnt == LINE) {
            figure = new Line(points);
        } else if (pointCnt == TRIANGLE) {
            figure = new Triangle(points);
        } else {
            figure = new Polygon(points);
        }
        return figure;
    }
}
