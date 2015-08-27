package coordinates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class DemoJava8 {

    public static void main(String[] args) {
        int min = -100;
        int max = 100;

        List<Point> points = new ArrayList<>();


        for (int i = min, j = max; i <= max; i++, j--) {
            points.add(new Point(i, j));
        }

        List<Dot> dots = points.parallelStream()
                .map(createPointsToDotFunc(0.13, 0.14))
                .filter(createMaxPredicate(100))
                .collect(Collectors.toList());
    }

    private static Function<Point, Dot> createPointsToDotFunc(double xF, double yF) {
        return point -> new Dot(multiplyDoubles(point.getX(), xF), multiplyDoubles(point.getY(), yF));
    }

    public static Predicate<Dot> createMaxPredicate(double max) {
        return dot -> dot.getX().add(dot.getY()).doubleValue() < max;
    }


    private static BigDecimal multiplyDoubles(double a, double b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }


}
