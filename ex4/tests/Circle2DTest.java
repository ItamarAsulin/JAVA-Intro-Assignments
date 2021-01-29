package ex4.tests;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Circle2DTest {
    private final double eps = 0.001;

    @Test
    void constructorTest() {
        Circle2D circle = new Circle2D(new Point2D(3, 2), 3);
        assertEquals(3, circle.getRadius());
        assertEquals(3, circle.centerOfMass().get_x());
        assertEquals(2, circle.centerOfMass().get_y());
    }

    @Test
    void circleError() {
        Circle2D circle = new Circle2D(new Point2D(), -3);
        assertEquals(circle.getRadius(), 1);
    }

    @Test
    void contains() {
        Circle2D circle = new Circle2D(new Point2D(), 1);
        Point2D point = new Point2D(1, 0);
        assertTrue(circle.contains(point));
        point.set_x(3);
        assertFalse(circle.contains(point));

    }

    @Test
    void centerOfMass() {
        Point2D point = new Point2D();
        Circle2D circle = new Circle2D(point, 1);
        assertEquals(circle.centerOfMass(), point);
    }

    @Test
    void area() {
        Circle2D circle = new Circle2D(new Point2D(), 1);
        assertEquals(3.141, circle.area(), eps);
    }

    @Test
    void perimeter() {
        Circle2D circle = new Circle2D(new Point2D(), 1);
        assertEquals(6.283, circle.perimeter(), eps);
    }

    @Test
    void move() {
        Circle2D circle = new Circle2D(new Point2D(), 1);
        circle.move(new Point2D(3, 6));
        assertEquals(3, circle.centerOfMass().get_x());
        assertEquals(6, circle.centerOfMass().get_y());
    }

    @Test
    void copy() {
        Circle2D circle = new Circle2D(new Point2D(), 1);
        Circle2D circle2 = (Circle2D) circle.copy();
        Point2D[] array = circle.getPoints();
        Point2D[] array2 = circle2.getPoints();
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], array2[i]);
        }
    }

    @Test
    void getPoints() {
        Circle2D circle = new Circle2D(new Point2D(), 1);
        Point2D[] array = circle.getPoints();
        assertEquals(array[0].get_x(), 0);
        assertEquals(array[0].get_y(), 0);
        assertEquals(array[1].get_x(), 0);
        assertEquals(array[1].get_y(), 1);

    }

    @Test
    void testToString() {
        Circle2D circle = new Circle2D(new Point2D(), 1);
        assertEquals(circle.toString(), "Circle2D,0.0,0.0, 1.0");
    }

    @Test
    void areaCheck() {
        Circle2D c = new Circle2D(new Point2D(0, 0), 0);
        assertEquals(c.area(), 0);
    }
}