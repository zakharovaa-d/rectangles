import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Point> points;
    private static List<Quadrangle> quadrangles;

    public static void main(String[] args) {
        readPoints();
        generateAllPossibleQuadrangles();
        findRectangles();
    }

    private static void readPoints() {
        points = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of points:");
        int length = Integer.parseInt(scanner.nextLine());

        System.out.println("Input x and y coordinates for each point separated by space\n");
        for (int i = 0; i < length; i++) {
            System.out.println("Input x and y for point " + (i + 1) + ":");
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            Point enteredPoint = new Point(x, y);
            points.add(enteredPoint);
        }

        System.out.println("Points: ");
        points.forEach(Point::print);
        System.out.println("Points count: " + points.size());
    }

    private static void generateAllPossibleQuadrangles() {
        quadrangles = new ArrayList<>();

        if (points.size() >= 4) {
            for (int i = 0; i < points.size() - 3; i++) {
                for (int j = i + 1; j < points.size() - 2; j++) {
                    for (int k = j + 1; k < points.size() - 1; k++) {
                        for (int m = k + 1; m < points.size(); m++) {
                            quadrangles.add(new Quadrangle(points.get(i), points.get(j), points.get(k), points.get(m)));
                        }
                    }
                }
            }
        }

        System.out.println("Quadrangles: ");
        quadrangles.forEach(Quadrangle::print);
        System.out.println("Quadrangles count: " + quadrangles.size());
    }

    private static void findRectangles() {
        List<Quadrangle> rectangles = quadrangles.stream()
                .filter(Quadrangle::isRectangular).collect(Collectors.toList());

        System.out.println("Rectangles: ");
        rectangles.forEach(System.out::println);
        System.out.println("Rectangles count: " + rectangles.size());
    }
}