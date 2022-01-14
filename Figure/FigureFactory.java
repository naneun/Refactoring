public class FigureFactory {
    public Figure getFigure(int pointCnt, Point[] points) throws ArgumentException {
        Figure figure = null;
        if (pointCnt == 1 || pointCnt == 4) {
            figure = new Square(points);
        } else if (pointCnt == 2) {
            figure = new Line(points);
        } else if (pointCnt == 3) {
            figure = new Triangle(points);
        } else if (pointCnt == 4) {
            figure = new Square(points);
        } else {
            figure = new Polygon(points);
        }
        return figure;
    }
}
