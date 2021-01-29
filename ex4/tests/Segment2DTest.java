package ex4.tests;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Segment2DTest {
    private final static double eps = 0.001;

    @Test
    void contains() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        Point2D p3 = new Point2D(3, 2);
        Point2D p4 = new Point2D(1.5, 0.5);
        assertTrue(seg.contains(p4));
        assertFalse(seg.contains(p3));
    }

    @Test
    void centerOfMass() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        Point2D p4 = new Point2D(1.5, 0.5);
        assertEquals(seg.centerOfMass().get_y(), p4.get_y());
        assertEquals(seg.centerOfMass().get_x(), p4.get_x());
    }

    @Test
    void area() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        assertEquals(0, seg.area());
    }

    @Test
    void perimeter() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        double perimeter = 6.324556;
        assertEquals(perimeter, seg.perimeter(),eps);
    }

    @Test
    void move() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        Point2D p3 = new Point2D(1,1);
        seg.move(p3);
        assertEquals(seg.getStart().get_x(), 1);
        assertEquals(seg.getStart().get_y(), 1);
        assertEquals(seg.getEnd().get_x(), 4);
        assertEquals(seg.getEnd().get_y(), 2);
    }

    @Test
    void copy() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        Segment2D seg2 = (Segment2D) seg.copy();
        assertEquals(seg.getStart().get_x(), seg2.getStart().get_x());
        assertEquals(seg.getStart().get_y(), seg2.getStart().get_y());
        assertEquals(seg.getEnd().get_x(), seg2.getEnd().get_x());
        assertEquals(seg.getEnd().get_y(), seg2.getEnd().get_y());

        }


    @Test
    void getPoints() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        Point2D[] arr = seg.getPoints();
        assertEquals(arr[0].get_x(),0);
        assertEquals(arr[1].get_x(),3);
        assertEquals(arr[0].get_y(),0);
        assertEquals(arr[1].get_y(),1);
    }

    @Test
    void testToString() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 1);
        Segment2D seg = new Segment2D(p1, p2);
        String s = "Segment2D,0.0,0.0,3.0,1.0";
        assertEquals(seg.toString(),s);

    }
}