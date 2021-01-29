package ex4.tests;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {
    private final static double eps = 0.001;
    @Test
    void constructorTest(){
        Point2D p = new Point2D(2,1);
        assertEquals(2,p.get_x());
        assertEquals(1, p.get_y());
    }
    @Test
    void add() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(6, 7);
        Point2D p3 = p1.add(p2);
        assertEquals(6, p3.get_x());
        assertEquals(7, p3.get_y());

    }

    @Test
    void testToString() {
        Point2D p1 = new Point2D();
        assertEquals("0.0,0.0", p1.toString());
    }

    @Test
    void distance() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(5, 7);
        double dis = p1.distance(p2);
        assertEquals(8.602325, dis, eps);

    }

    @Test
    void testEquals() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D();
        assertTrue(p1.equals(p2));
    }

    @Test
    void close2equals() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(0.0001, 0.000001);
        assertTrue(p1.close2equals(p2, eps));
    }

    @Test
    void vector() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(2, 3);
        Point2D p3 = p1.vector(p2);
        assertEquals(2, p3.get_x());
        assertEquals(3, p3.get_y());

    }

    @Test
    void contains() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(2, 3);
        Point2D p3 = new Point2D(0, 0);
        assertFalse(p1.contains(p2));
        assertTrue(p1.contains(p3));
    }

    @Test
    void centerOfMass() {
        Point2D p1 = new Point2D();
        assertEquals(p1, p1.centerOfMass());
    }

    @Test
    void area() {
        Point2D p1 = new Point2D();
        assertEquals(p1.area(), 0);
    }

    @Test
    void perimeter() {
        Point2D p1 = new Point2D();
        assertEquals(p1.perimeter(), 0);
    }

    @Test
    void move() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(2, 3);
        p1.move(p2);
        assertEquals(2, p1.get_x());
        assertEquals(3, p1.get_y());


    }

    @Test
    void copy() {
        Point2D p1 = new Point2D();
        Point2D p2 = (Point2D) p1.copy();
        assertEquals(p2.get_x(), p1.get_x());
        assertEquals(p2.get_y(), p1.get_y());
    }

    @Test
    void getPoints() {
        Point2D p1 = new Point2D();
        Point2D[] arr = p1.getPoints();
        assertEquals(arr[0].get_y(), 0.0);
        assertEquals(arr[0].get_x(), 0.0);

    }
}