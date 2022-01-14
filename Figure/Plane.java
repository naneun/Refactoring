import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Plane {
    private static int ROW;
    private static int COL;
    public static final int MAX_POS = 24;

    private char[][] planeMap;

    public Plane() {
        this.planeMap = createPlaneMap();
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

    public String planeToString(Point[] points) {
        Set<Point> st = new HashSet<>();
        for (Point point : points) {
            st.add(new Point(Plane.ROW - 2 - point.y, Plane.COL - 1 - (MAX_POS - point.x) * 2));
        }
        Point point = new Point(0, 0);
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < ROW; ++row) {
            for (int col = 0; col < COL; ++col) {
                point.x = row;
                point.y = col;
                if (st.contains(point)) {
                    sb.append('●');
                } else {
                    sb.append(planeMap[row][col]);
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
