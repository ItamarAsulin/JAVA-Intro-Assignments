package ex4.tests;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Triangle2DTest {
    private final static double eps = 0.001;

    @Test
    void TriangleError() {
        Triangle2D t = new Triangle2D(new Point2D(), new Point2D(), new Point2D());
        assertEquals(t.getP1().get_x(), 0);
        assertEquals(t.getP1().get_y(), 0);
        assertEquals(t.getP2().get_x(), 3);
        assertEquals(t.getP2().get_y(), 0);
        assertEquals(t.getP3().get_x(), 1.5);
        assertEquals(t.getP3().get_y(), 3);
    }

    @Test
    void contains() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        Point2D p4 = new Point2D(1.5, 2);
        Point2D p5 = new Point2D(-0.01, 0);
        assertTrue(t1.contains(p4));
        assertFalse(t1.contains(p5));
    }

    @Test
    void centerOfMass() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        Point2D p4 = new Point2D(1.5, 1);
        assertEquals(p4.get_x(), t1.centerOfMass().get_x());
        assertEquals(p4.get_y(), t1.centerOfMass().get_y());
    }

    @Test
    void area() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        assertEquals(3 * 1.5, t1.area(), eps);
    }

    @Test
    void perimeter() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        assertEquals(9.708, t1.perimeter(), eps);

    }

    @Test
    void move() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        t1.move(new Point2D(1, 1));
        assertEquals(t1.getP1().get_x(), 1);
        assertEquals(t1.getP1().get_y(), 1);
        assertEquals(t1.getP2().get_x(), 4);
        assertEquals(t1.getP2().get_y(), 1);
        assertEquals(t1.getP3().get_x(), 2.5);
        assertEquals(t1.getP3().get_y(), 4);
    }

    @Test
    void copy() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        Triangle2D t2 = (Triangle2D) t1.copy();
        Point2D[] arr1 = t1.getPoints();
        Point2D[] arr2 = t2.getPoints();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr2[i];
        }
    }

    @Test
    void getPoints() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        Point2D[] arr1 = {p1, p2, p3};
        Point2D[] arr2 = t1.getPoints();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr2[i];
        }

    }
    @Test
    void areaCheck(){
        Triangle2D t = new Triangle2D(new Point2D(0,0), new Point2D(1,1), new Point2D(2,2));
        assertEquals(t.area(),0);
    }

    @Test
    void testToString() {
        String s = "Triangle2D,0.0,0.0,3.0,0.0,1.5,3.0";
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(1.5, 3);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        assertEquals(s, t1.toString());
    }
}