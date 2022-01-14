import java.io.IOException;
import java.util.Objects;

public class Calculator {
    private static OutputUtil outputUtil;
    private static final int MIN_VERTEX = 5;
    private static final FigureFactory figureFactory = new FigureFactory();

    public static void start() throws IOException {
        InputUtil inputUtil = new InputUtil(System.in);
        OutputUtil outputUtil = new OutputUtil(System.out);

        String input = null;
        String element = "[-]?\\d+";

        Figure figure = null;
        Point[] points = null;
        int pointCnt = 0;

        while (true) {
            try {
                System.out.println("> Please enter coordinates (ex. (%d,%d)-(%d,%d)...)");
                input = inputUtil.readLine();
                points = inputUtil.parsing(input, element);
                try {
                    pointCnt = inputUtil.getPointCnt();
                    figure = figureFactory.getFigure(pointCnt, points);
                    if (pointCnt < MIN_VERTEX) {
                        throw new ArgumentException("It is not a polygon.");
                    }
                } catch (ArgumentException e) {
                    System.out.println(e.getMessage());
                } finally {
                    outputUtil.printInfo(figure);
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
