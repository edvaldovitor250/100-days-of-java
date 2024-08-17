# Day 96

## Desafio:

Implemente um algoritmo em Java para calcular o fecho convexo de um conjunto de pontos no plano usando o algoritmo de Graham.


**Resultado:**

```java

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Day096 {

    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                  (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }

    public static Point findMinY(List<Point> points) {
        Point minYPoint = points.get(0);
        for (Point point : points) {
            if (point.y < minYPoint.y || 
               (point.y == minYPoint.y && point.x < minYPoint.x)) {
                minYPoint = point;
            }
        }
        return minYPoint;
    }

    public static List<Point> grahamScan(List<Point> points) {
        Point minYPoint = findMinY(points);
        points.remove(minYPoint);

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int orient = orientation(minYPoint, p1, p2);
                if (orient == 0) {
                    return distance(minYPoint, p1) < distance(minYPoint, p2) ? -1 : 1;
                }
                return (orient == 2) ? -1 : 1;
            }
        });

        points.add(0, minYPoint);

        Stack<Point> stack = new Stack<>();
        stack.push(points.get(0));
        stack.push(points.get(1));
        stack.push(points.get(2));

        for (int i = 3; i < points.size(); i++) {
            while (stack.size() > 1 && orientation(secondTop(stack), stack.peek(), points.get(i)) != 2) {
                stack.pop();
            }
            stack.push(points.get(i));
        }

        return new ArrayList<>(stack);
    }

    public static int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static Point secondTop(Stack<Point> stack) {
        Point top = stack.pop();
        Point secondTop = stack.peek();
        stack.push(top);
        return secondTop;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 3));
        points.add(new Point(2, 3));
        points.add(new Point(1, 1));
        points.add(new Point(2, 1));
        points.add(new Point(3, 0));
        points.add(new Point(0, 0));
        points.add(new Point(3, 3));

        List<Point> convexHull = grahamScan(points);

        System.out.println("Os pontos no fecho convexo são:");
        for (Point p : convexHull) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
