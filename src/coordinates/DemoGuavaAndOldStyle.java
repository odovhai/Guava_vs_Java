package coordinates;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoGuavaAndOldStyle {

    public static final Function<Dot, Double> TO_MAP = new Function<Dot, Double>() {
        public Double apply(Dot dot) {
            return dot.getX().add(dot.getY()).doubleValue();
        }
    };

    public static void main(String[] args) {


        int min = -100;
        int max = 100;

        List<Point> points = new ArrayList<>();


        for (int i = min, j = max; i <= max; i++, j--) {
            points.add(new Point(i, j));
        }


        System.out.println(points);



        System.out.println(points);


        List<Point> filteredPoints = filterPointsByDelimeter(points);

        System.out.println(filteredPoints);

        List<Dot> dots = createDotsFromPoints(filteredPoints, 0.23, 0.73);


        System.out.println(dots);

        Map<Dot, Double> map = FluentIterable.from(points).transform(point -> new Dot(multiplyDoubles(point.getX(), 0.23), multiplyDoubles(point.getY(), 0.73)))
                .toMap(new Function<Dot, Double>() {
                    @Override
                    public Double apply(Dot dot) {
                        return dot.getX().add(dot.getY()).doubleValue();
                    }
                });



        Map<Dot, Double> map0 = createFilteredDotsMapFromPoints(points, 0.14, 0.13, 100);

        Map<Dot, Double> map1 = createFilteredDotsMapFromPoints(points,
                new Function<Point, Dot>() {
                    public Dot apply(Point point) {
                        return new Dot(multiplyDoubles(point.getX(), 0.13), multiplyDoubles(point.getY(), 0.14));
                    }
                },
                new Predicate<Dot>() {
                    public boolean apply(Dot dot) {
                        return dot.getX().add(dot.getY()).doubleValue() < 100;
                    }
                },
                new Function<Dot, Double>() {
                    public Double apply(Dot dot) {
                        return dot.getX().add(dot.getY()).doubleValue();
                    }
                });

        Map<Dot, Double> map2 = FluentIterable.from(points)
                        .transform(point -> new Dot(multiplyDoubles(point.getX(), 0.13), multiplyDoubles(point.getY(), 0.17)))
                        .filter( dot -> dot.getX().add(dot.getY()).doubleValue() < 200)
                        .toMap(dot -> dot.getX().add(dot.getY()).doubleValue());



    }

    private static Function<Point, Dot> createPointsToDotFunc(double xF, double yF) {
        return point -> new Dot(multiplyDoubles(point.getX(), xF), multiplyDoubles(point.getY(), yF));
    }

    public static Predicate<Dot> createMaxPredicate(double max) {
        return dot -> dot.getX().add(dot.getY()).doubleValue() < max;
    }



    private static Map<Dot, Double> createFilteredDotsMapFromPoints(List<Point> points,
                            Function<Point, Dot> pointsToDot, Predicate<Dot> filterByMax, Function<Dot, Double> toMap) {

        return FluentIterable.from(points).transform(pointsToDot).filter(filterByMax).toMap(toMap);
    }

    private static List<Dot> createDotsFromPoints(List<Point> points, double xF, double yF) {
        List<Dot> dots = new ArrayList<>();
        for (Point point : points) {
            dots.add(new Dot(multiplyDoubles(point.getX(), xF), multiplyDoubles(point.getY(), yF)));
        }

        return dots;
    }

    private static BigDecimal multiplyDoubles(double a, double b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }

    private static List<Point> filterPointsByDelimeter(List<Point> points) {
        List<Point> result = new ArrayList<>();
        for (Point point : points) {
            if (point.getX() % 2 == 0 && point.getY() % 2 == 0) {
                result.add(point);
            }
        }
        return result;
    }


    private static Map<Dot, Double> createFilteredDotsMapFromPoints(List<Point> points, double xF, double yF, double max) {

        Map<Dot, Double> dots = new HashMap<>();

        for (Point point : points) {

            Dot dot = new Dot(multiplyDoubles(point.getX(), xF), multiplyDoubles(point.getY(), yF));

            double coordinateSum = dot.getX().add(dot.getY()).doubleValue();

            if (coordinateSum <= max) {
                dots.put(dot, coordinateSum);
            }

        }
        return dots;
    }

}
