import java.util.Arrays;

public class Square implements Figure {
    private Point[] points;
    private Plane plane;
    private double value;

    public Square() {}

    public Square(Point[] points) throws ArgumentException {
        sortPoints(points);
        if (nonRectanguler(points)) {
            throw new ArgumentException("Only rectangular inputs are accepted");
        }
        this.points = points;
        this.plane = new Plane(points);
        this.value = calculate();
    }

    private void sortPoints(Point[] points) {
        Arrays.sort(points, (p1, p2) -> {
            return Integer.compare(p1.x, p2.x);
        });
    }

    private boolean nonRectanguler(Point[] points) {
        return points.length != 1 && (points[0].x != points[1].x || points[2].x != points[3].x
                || points[0].y != points[2].y || points[1].y != points[3].y);
    }

    @Override
    public double calculate() {
        return calculate(points);
    }

    @Override
    public double calculate(Point[] points) {
        if (points.length == 1) {
            return (double) points[0].x * points[0].y;
        }
        Point l = points[0];
        Point r = points[3];
        return Math.abs(l.x - r.x) * Math.abs(l.y - r.y);
    }

    @Override
    public String toString() {
        return String.format("%s\n%s"
                , points.length == 1 ? "Unable to display screen for input values\n" : plane.planeToString()
                , String.format("The area of the rectangle is: %s", value));
    }
}
