public class Plane {
    public static final int ROW = 26;
    public static final int COL = 51;
    public static final int MAX_POS = 24;

    private char[][] planeMap;

    public Plane(Point[] points) {
        this.planeMap = createPlaneMap();
        for (Point point : points) {
            dot(point);
        }
    }

    public char[][] createPlaneMap() {
        char[][] planeMap = new char[ROW][COL];
        String line = null;
        line = "24|                                                ";
        planeMap[0] = line.toCharArray();
        line = "  |                                                ";
        planeMap[1] = line.toCharArray();
        line = "22|                                                ";
        planeMap[2] = line.toCharArray();
        line = "  |                                                ";
        planeMap[3] = line.toCharArray();
        line = "20|                                                ";
        planeMap[4] = line.toCharArray();
        line = "  |                                                ";
        planeMap[5] = line.toCharArray();
        line = "18|                                                ";
        planeMap[6] = line.toCharArray();
        line = "  |                                                ";
        planeMap[7] = line.toCharArray();
        line = "16|                                                ";
        planeMap[8] = line.toCharArray();
        line = "  |                                                ";
        planeMap[9] = line.toCharArray();
        line = "14|                                                ";
        planeMap[10] = line.toCharArray();
        line = "  |                                                ";
        planeMap[11] = line.toCharArray();
        line = "12|                                                ";
        planeMap[12] = line.toCharArray();
        line = "  |                                                ";
        planeMap[13] = line.toCharArray();
        line = "10|                                                ";
        planeMap[14] = line.toCharArray();
        line = "  |                                                ";
        planeMap[15] = line.toCharArray();
        line = " 8|                                                ";
        planeMap[16] = line.toCharArray();
        line = "  |                                                ";
        planeMap[17] = line.toCharArray();
        line = " 6|                                                ";
        planeMap[18] = line.toCharArray();
        line = "  |                                                ";
        planeMap[19] = line.toCharArray();
        line = " 4|                                                ";
        planeMap[20] = line.toCharArray();
        line = "  |                                                ";
        planeMap[21] = line.toCharArray();
        line = " 2|                                                ";
        planeMap[22] = line.toCharArray();
        line = "  |                                                ";
        planeMap[23] = line.toCharArray();
        line = "  +------------------------------------------------";
        planeMap[24] = line.toCharArray();
        line = " 0    2   4   6   8  10  12  14  16  18  20  22  24";
        planeMap[25] = line.toCharArray();

        return planeMap;
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
