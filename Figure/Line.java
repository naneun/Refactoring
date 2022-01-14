public class Line implements Figure {
    private Point[] points;
    private double value;

    public Line() {}
    public Line(Point[] points) {
        this.points = points;
        this.value = calculate(points);
    }

    @Override
    public Point[] getPoints() {
        return this.points;
    }

    @Override
    public double calculate() {
        return calculate(points);
    }

    @Override
    public double calculate(Point[] points) {
        Point p1 = points[0];
        Point p2 = points[1];
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return String.format("%s", String.format("Distance between two points: %s", value));
    }
}
