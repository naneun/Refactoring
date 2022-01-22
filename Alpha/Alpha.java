import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Alpha {
    static private final Function<Set, Integer> sum = factors -> factors.stream().mapToInt(number -> (Integer) number).sum();

    static private final Function<Integer, Set> factorize = number -> IntStream.rangeClosed(1, (int) Math.sqrt(number))
                    .boxed().flatMap(pod -> IntStream.of(number).filter(val -> val % pod == 0)
                    .mapToObj(val -> new int[]{pod, val / pod})).flatMapToInt(Arrays::stream)
                    .boxed().collect(Collectors.toSet());

    static private final Function<Integer, String> classify = number -> Stream.of(number)
            .map(val -> Integer.compare(sum.apply(factorize.apply(val)) - val, val))
            .map(val -> val == 0 ? "Perfect" : val > 0 ? "Abundant" : "Deficient").reduce("", (a, b) -> a + b);

    static private final Predicate<Integer> isPrime = number -> Stream.of(number).filter(val -> val > 1 && factorize.apply(val)
            .equals(Stream.of(1, val).collect(Collectors.toSet()))).count() == 1;

    static private final Predicate<Integer> isSquared = number -> Stream.of(number)
            .mapToInt(val -> Integer.compare((int) Math.pow((int) Math.sqrt(val), 2), val)).sum() == 0;

    static public final String getInfo(int number) {
        return String.format("%d : %s, %s", number, Alpha.classify.apply(number)
                , Alpha.isPrime.test(number) ? "prime" : Alpha.isSquared.test(number) ? "squared" : "");
    }
}