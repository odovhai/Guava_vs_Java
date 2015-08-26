package coordinates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoOldStyle {

    public static void main(String[] args) {


        int min = -100;
        int max = 100;

        List<Point> points = new ArrayList<>();
        Random random = new Random();


        for (int i = min, j = max; i <= max; i++, j--) {
            int randomX = random.nextInt((max - min) + 1) + min;
            int randomY = random.nextInt((max - min) + 1) + min;
            points.add(new Point(randomX, randomY));
            points.add(new Point(i, j));
        }

        System.out.println(points);


        List<Point> filteredPoints = filterPoints(points);

        System.out.println(filteredPoints);

        List<Dot> dots = createDotsFromPoints(filteredPoints, 0.23, 0.73);

        System.out.println(dots);

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

    private static List<Point> filterPoints(List<Point> points) {
        List<Point> result = new ArrayList<>();
        for (Point point : points) {
            if (point.getX() < point.getY()) {
                result.add(point);
            }
        }
        return result;
    }


}
