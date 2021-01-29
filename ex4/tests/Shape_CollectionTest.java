package ex4.tests;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Shape_CollectionTest {

    @Test
    void size() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testPoint);
        test.add(testCircle);
        assertEquals(4, test.size());
    }

    @Test
    void removeElementAt() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testPoint);
        test.add(testCircle);
        assertEquals(testTriangle, test.removeElementAt(1));
    }

    @Test
    void addAt() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testPoint);
        test.addAt(testCircle, 0);
        assertEquals(testCircle, test.get(0));
    }

    @Test
    void add() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testPoint);
        test.add(testCircle);
        assertEquals(testCircle, test.get(3));
    }

    @Test
    void copy() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testPoint);
        test.add(testCircle);
        Shape_Collection test2 = (Shape_Collection) test.copy();
        assertNotEquals(test, test2);
        for (int i = 0; i < test.size(); i++) {
            assertEquals(test.get(i).getShape(), test2.get(i).getShape());
            assertEquals(test.get(i).getTag(), test2.get(i).getTag());
            assertEquals(test.get(i).getColor(), test2.get(i).getColor());
            assertEquals(test.get(i).isFilled(), test2.get(i).isFilled());

        }
    }

    @Test
    void sort() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testCircle);
        double triangleArea = testTriangle.getShape().area();
        double segmentArea = testSegment.getShape().area();
        double circleArea = testCircle.getShape().area();
        Shape_Comp sortBy = new Shape_Comp(2);
        test.sort(sortBy);
        test.toString();
        assertTrue(test.get(2).getShape() instanceof Circle2D);
        assertTrue(test.get(1).getShape() instanceof Triangle2D);
        assertTrue(test.get(0).getShape() instanceof Segment2D);

        sortBy = new Shape_Comp(3);
        test.sort(sortBy);
        assertTrue(test.get(2).getShape() instanceof Segment2D);
        assertTrue(test.get(1).getShape() instanceof Triangle2D);
        assertTrue(test.get(0).getShape() instanceof Circle2D);
        sortBy = new Shape_Comp(4);
        test.sort(sortBy);
        assertTrue(test.get(2).getShape() instanceof Circle2D);
        assertTrue(test.get(1).getShape() instanceof Triangle2D);
        assertTrue(test.get(0).getShape() instanceof Segment2D);
        sortBy = new Shape_Comp(5);
        test.sort(sortBy);
        assertTrue(test.get(2).getShape() instanceof Segment2D);
        assertTrue(test.get(1).getShape() instanceof Triangle2D);
        assertTrue(test.get(0).getShape() instanceof Circle2D);
        sortBy = new Shape_Comp(6);
        test.sort(sortBy);
        assertTrue(test.get(2).getShape() instanceof Triangle2D);
        assertTrue(test.get(1).getShape() instanceof Segment2D);
        assertTrue(test.get(0).getShape() instanceof Circle2D);


    }


    @Test
    void removeAll() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testCircle);
        test.removeAll();
        assertEquals(0,test.size());
    }

    @Test
    void save() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        test.add(testPoint);
        test.add(testSegment);
        test.add(testTriangle);
        test.save("testFile.txt");

    }

    @Test
    void load() {
        Shape_Collection test = new Shape_Collection();
        test.load("text.txt");
        System.out.println(test.toString());
    }

    @Test
    void getBoundingBox() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        GUI_Shape testCircle = new GUIShape(new Circle2D(new Point2D(2, 0), 5), true, Color.BLACK, 0);
        test.add(testSegment);
        test.add(testTriangle);
        test.add(testPoint);
        test.add(testCircle);
        GeoShape bounderiesRect = new Rect2D(new Point2D(-3, -5), new Point2D(7, 5));
        GeoShape boundingIboxTest = test.getBoundingBox();
        Point2D[] p1 = bounderiesRect.getPoints();
        Point2D[] p2 = boundingIboxTest.getPoints();
        for (int i = 0; i < p1.length; i++) {
            assertEquals(p1[i],p2[i]);
            assertEquals(p1[i],p2[i]);
        }
        testTriangle.getShape().move(new Point2D(7,8));
        boundingIboxTest = test.getBoundingBox();
        bounderiesRect = new Rect2D(new Point2D(-3, -5), new Point2D(9, 11));
        for (int i = 0; i < p1.length; i++) {
            assertEquals(p1[i],p2[i]);
            assertEquals(p1[i],p2[i]);
        }

    }

    @Test
    void testToString() {
        Shape_Collection test = new Shape_Collection();
        GUI_Shape testTriangle = new GUIShape(new Triangle2D(new Point2D(1, 0), new Point2D(2, 3), new Point2D(1, 1)), true, Color.BLUE, 0);
        GUI_Shape testSegment = new GUIShape(new Segment2D(new Point2D(1, 0), new Point2D(2, 3)), true, Color.BLUE, 0);
        GUI_Shape testPoint = new GUIShape(new Point2D(2, 3), true, Color.BLUE, 0);
        test.add(testPoint);
        test.add(testSegment);
        test.add(testTriangle);
        test.toString();
        System.out.println(test.toString());
        String s = "GUIShape,255,true,0,Point2D,2.0,3.0\n" +
       "GUIShape,255,true,0,Segment2D,1.0,0.0,2.0,3.0\n" +
        "GUIShape,255,true,0,Triangle2D,1.0,0.0,2.0,3.0,1.0,1.0";
        assertEquals(s, test.toString());
    }
}