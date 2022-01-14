import java.io.OutputStream;

public class OutputUtil {
    private OutputStream os;
    private Plane plane;

    public OutputUtil(OutputStream os) {
        this.os = os;
        this.plane = new Plane();
    }

    public void printInfo(Figure figure) {
        System.out.println(plane.planeToString(figure.getPoints()));
        System.out.println(figure);
    }
}
