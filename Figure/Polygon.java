import java.util.Arrays;
import java.util.Objects;

public class Polygon implements Figure {
    private Point[] points;
    private Plane plane;
    private double value;

    private static Line line;
    private static Triangle triangle;

    public Polygon() {
        if (Objects.isNull(line)) {
            this.line = new Line();
        }
        if (Objects.isNull(triangle)) {
            this.triangle = new Triangle();
        }
    }
    public Polygon(Point[] points) {
        this();
        this.points = points;
        this.plane = new Plane();
        this.value = calculate();
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long val = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        int result = 0;
        if (val > 0) {
            result = 1;
        } else if (val < 0) {
            result = -1;
        }
        return result;
    }

    private void sortClockwise(Point[] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (Integer.compare(p1.x, p2.x) != 0) {
                return Integer.compare(p1.x, p2.x);
            } else {
                return Integer.compare(p1.y, p2.y);
            }
        });
        Arrays.sort(points, (p1, p2) -> {
            int result = ccw(points[0], p1, p2);
            if (result > 0) {
                return -1;
            } else if (result < 0) {
                return 1;
            } else {
                double d1 = line.calculate(new Point[]{ points[0], p1 });
                double d2 = line.calculate(new Point[]{ points[0], p2 });
                if (Double.compare(d1, d2) > 0) {
                    return 1;
                }
            }
            return -1;
        });
    }

    @Override
    public double calculate() {
        return calculate(points);
    }

    @Override
    public double calculate(Point[] points) {
        sortClockwise(points);
        double result = 0;
        int cnt = points.length;
        for (int idx = 1; idx < cnt - 1; ++idx) {
            result += triangle.calculate(new Point[]{ points[0], points[idx], points[idx + 1] });
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", plane.planeToString(points), String.format("The area of the polygon is: %s", value));
    }
}
