import java.util.Arrays;

public class Plane {
    private static int ROW;
    private static int COL;
    public static final int MAX_POS = 24;

    private char[][] planeMap;

    public Plane() {}

    public Plane(Point[] points) {
        this.planeMap = createPlaneMap();
        for (Point point : points) {
            dot(point);
        }
    }

    public char[][] createPlaneMap() {
        int leftSec = Integer.toString(MAX_POS).length();
        ROW = MAX_POS + 2;
        COL = leftSec + 1 + (MAX_POS << 1);
        char[][] planeMap = new char[ROW][COL];
        for (char[] line : planeMap) {
            Arrays.fill(line, ' ');
        }
        basicSetting(planeMap, leftSec);

        return planeMap;
    }

    private void basicSetting(char[][] planeMap, int leftSec) {
        for (int row = ROW - 2; row >= 0; --row) {
            planeMap[row][leftSec] = '|';
        }

        planeMap[ROW - 1][leftSec - 1] = '0';
        for (int row = ROW - 4, num = 2; row >= 0; row -= 2, num += 2) {
            String str = Integer.toString(num);
            int len = str.length();
            for (int idx = 0; idx < len; ++idx) {
                planeMap[row][leftSec - idx - 1] = str.charAt(len - idx - 1);
            }
        }

        planeMap[ROW - 2][leftSec] = '+';
        for (int col = leftSec + 1; col < COL; ++col) {
            planeMap[ROW - 2][col] = '-';
        }

        for (int col = leftSec + 1 + (leftSec << 1), num = 2; col <= COL; col += (leftSec << 1), num += 2) {
            String str = Integer.toString(num);
            int len = str.length();
            for (int idx = 0; idx < len; ++idx) {
                planeMap[ROW - 1][col - idx - 1] = str.charAt(len - idx - 1);
            }
        }
    }

    private void dot(Point point) {
        planeMap[Plane.ROW - 2 - point.y][Plane.COL - 1 - (MAX_POS - point.x) * 2] = '●';
    }

    public String planeToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROW; ++ i) {
            sb.append(planeMap[i]).append('\n');
        }
        return sb.toString();
    }
}
