import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Quadrangle> quadrangles;
    private static List<Point> points;

    public static void main(String[] args) {

        // no rectangulars
//        Point a = new Point(3,4);
//        Point b = new Point(5,6);
//        Point c = new Point(8,5);
//        Point d = new Point(9,3);
//        Point e = new Point(7,1);
//        Point f = new Point(3,1);

        // 1 rectangular
//        Point a = new Point(2,3);
//        Point b = new Point(5,6);
//        Point c = new Point(7,4);
//        Point d = new Point(4,1);
//        Point e = new Point(1,6);
//        Point f = new Point(7,6);

        // 2 rectangulars
        Point a = new Point(-7,4);
        Point b = new Point(-1,1);
        Point c = new Point(1,1);
        Point d = new Point(-1,-1);
        Point e = new Point(1,-1);
        Point f = new Point(0,4);
        Point g = new Point(2,8);
        Point k = new Point(6,8);
        Point l = new Point(8,5);
        Point m = new Point(11,5);
        Point n = new Point(6,1);


        points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        points.add(e);
        points.add(f);
        points.add(g);
        points.add(l);
        points.add(m);
        points.add(n);


        System.out.println("Points: ");
        for (Point point: points) {
            point.print();
        }

        generateAllPossibleQuadrangles();
        List<Quadrangle> rectangles = new ArrayList<>();
        rectangles = quadrangles.stream().filter(Quadrangle::isRectangular).collect(Collectors.toList());

        rectangles.forEach(System.out::println);
        System.out.println("Rectangles count: " + rectangles.size());
    }

    private static void generateAllPossibleQuadrangles() {
        quadrangles = new ArrayList<>();

        for (int i = 0; i < points.size() - 3; i++) {
            for (int j = i + 1; j < points.size() - 2; j++) {
                for (int k = j + 1; k < points.size() - 1; k++) {
                    for (int m = k + 1; m < points.size(); m++) {
                        quadrangles.add(new Quadrangle(points.get(i), points.get(j), points.get(k), points.get(m)));
                    }
                }
            }
        }

        quadrangles.forEach(Quadrangle::print);
        System.out.println(quadrangles.size());
    }
}