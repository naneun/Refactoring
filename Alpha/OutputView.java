import java.util.stream.IntStream;

public class OutputView {
    public void showInfos(int mn, int mx) {
        String result = IntStream.rangeClosed(mn, mx).boxed().map(Alpha::getInfo).reduce("", (a, b) -> String.format("%s%s\n", a, b));
        System.out.println(result);
    }
}
