import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil {
    private BufferedReader br;
    private Pattern pattern;
    private Pattern extractor;
    private Matcher matcher;
    private int pointCnt;

    public InputUtil(InputStream is) {
        this.br = new BufferedReader(new InputStreamReader(is));
    }

    public String readLine() throws IOException {
        return br.readLine();
    }

    private boolean validate(String input) {
        return matcher.matches();
    }

    private Point[] extract(String input) throws NumberFormatException, ArgumentException {
        Point[] points = new Point[pointCnt];
        matcher = extractor.matcher(input);
        int x, y;
        for (int idx = 0; idx < pointCnt; ++idx) {
            if (!matcher.find()) {
                throw new ArgumentException("The number of vertices of the shape and the number of factors do not match");
            }
            x = Integer.parseInt(matcher.group());
            if (x > Plane.MAX_POS) {
                throw new ArgumentException("Input value out of range (must be less than or equal to " + Plane.MAX_POS + ")");
            }
            if (!matcher.find()) {
                throw new ArgumentException("The number of vertices of the shape and the number of factors do not match");
            }
            y = Integer.parseInt(matcher.group());
            if (y > Plane.MAX_POS) {
                throw new ArgumentException("Input value out of range (must be less than or equal to " + Plane.MAX_POS + ")");
            }
            points[idx] = new Point(x, y);
        }
        return points;
    }

    public Point[] parsing(String input, String element) throws ParsingException, ArgumentException {
        String target = String.format("\\(%s,%s\\)", element, element);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s(-%s)*", target, target));

        pattern = Pattern.compile(sb.toString());
        matcher = pattern.matcher(input);
        if (!validate(input)) {
            throw new ParsingException("Parsing Error!\nUsage: (%d,%d)-(%d,%d)...");
        }

        pattern = Pattern.compile(target);
        extractor = Pattern.compile(String.format("%s", element));
        matcher = pattern.matcher(input);

        pointCnt = 0;
        while (matcher.find()) {
            ++pointCnt;
        }

        return extract(input);
    }

    public int getPointCnt() {
        return pointCnt;
    }
}
