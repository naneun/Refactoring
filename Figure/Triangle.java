import java.util.Objects;

public class Triangle implements Figure {
    private Point[] points;
    private Plane plane;
    private double value;

    private static Line line;

    public Triangle() {
        if (Objects.isNull(line)) {
            this.line = new Line();
        }
    }
    public Triangle(Point[] points) {
        this();
        this.points = points;
        this.plane = new Plane();
        this.value = calculate();
    }

    @Override
    public double calculate() {
        return calculate(points);
    }

    @Override
    public double calculate(Point[] points) {
        double a = line.calculate(new Point[]{ points[0], points[1] });
        double b = line.calculate(new Point[]{ points[0], points[2] });
        double c = line.calculate(new Point[]{ points[1], points[2] });
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", plane.planeToString(points), String.format("The area of the triangle is: %s", value));
    }
}
