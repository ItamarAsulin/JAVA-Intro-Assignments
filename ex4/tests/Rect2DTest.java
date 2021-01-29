package ex4.tests;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;

import static org.junit.jupiter.api.Assertions.*;

class Rect2DTest {
    @Test
    void areaCheck(){
        Rect2D r = new Rect2D(new Point2D(0,0), new Point2D(0,2));
        assertEquals(r.area(),0);
    }
    @Test
    void constructorTest(){
        Circle2D circle = new Circle2D(new Point2D(3,2), 3);
        assertEquals(3, circle.getRadius());
        assertEquals(3,circle.centerOfMass().get_x());
        assertEquals(2,circle.centerOfMass().get_y());
    }
    @Test
    void RectError(){
        Rect2D r = new Rect2D(new Point2D(), new Point2D());
        assertEquals(r.getTopRight().get_x(),2);
        assertEquals(r.getTopRight().get_y(),1);
    }

    @Test
    void contains() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Point2D p1 = new Point2D();
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        assertTrue(r1.contains(p1));
    }

    @Test
    void centerOfMass() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Point2D p1 = new Point2D(1, 0.5);
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        assertEquals(r1.centerOfMass().get_x(), p1.get_x());
        assertEquals(r1.centerOfMass().get_y(), p1.get_y());
    }

    @Test
    void area() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        assertEquals(2, r1.area());
    }

    @Test
    void perimeter() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        assertEquals(6, r1.perimeter());
    }

    @Test
    void move() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        Point2D p1 = new Point2D(1, 0.5);
        r1.move(p1);
        assertEquals(1,r1.getBottomLeft().get_x());
        assertEquals(0.5,r1.getBottomLeft().get_y());
        assertEquals(3,r1.getTopRight().get_x());
        assertEquals(1.5,r1.getTopRight().get_y());
    }

    @Test
    void copy() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        Point2D[] array1 = r1.getPoints();
        Rect2D r2 = (Rect2D) r1.copy();
        Point2D[] array2 = r2.getPoints();
        for (int i = 0; i < array1.length; i++) {
            assertEquals(array1[i], array2[i]);
        }
    }

    @Test
    void getPoints() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        Point2D[] array1 = r1.getPoints();
        assertEquals(array1[0].get_x(),0);
        assertEquals(array1[1].get_x(),2);
        assertEquals(array1[0].get_y(),0);
        assertEquals(array1[1].get_y(),1);
    }

    @Test
    void testToString() {
        Point2D bottomLeft = new Point2D();
        Point2D topRight = new Point2D(2, 1);
        Rect2D r1 = new Rect2D(bottomLeft, topRight);
        String s = "Rect2D,0.0,0.0,2.0,1.0";
        assertEquals(r1.toString(),s);
    }
}