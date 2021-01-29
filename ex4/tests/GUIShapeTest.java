package ex4.tests;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GUIShapeTest {

    @Test
    void getShape() {
        GUI_Shape gs = new GUIShape();
        boolean b = gs.getShape() instanceof Point2D;
        assertTrue(b);
    }

    @Test
    void setShape() {
        GUI_Shape gs = new GUIShape();
        GeoShape r = new Rect2D(new Point2D(), new Point2D(2,1));
        gs.setShape(r);
        boolean b = gs.getShape() instanceof Rect2D;
        assertTrue(b);
    }

    @Test
    void isFilled() {
        GUI_Shape gs = new GUIShape();
        assertFalse(gs.isFilled());
    }

    @Test
    void setFilled() {
        GUI_Shape gs = new GUIShape();
        gs.setFilled(true);
        assertTrue(gs.isFilled());
    }

    @Test
    void getColor() {
        GUI_Shape gs = new GUIShape();
        assertEquals(Color.BLACK,gs.getColor());
    }

    @Test
    void setColor() {
        GUI_Shape gs = new GUIShape();
        gs.setColor(Color.BLUE);
        assertEquals(gs.getColor(), Color.BLUE);
    }

    @Test
    void getTag() {
        GUI_Shape gs = new GUIShape();
        assertEquals(0,gs.getTag());
    }

    @Test
    void setTag() {
        GUI_Shape gs = new GUIShape();
        gs.setTag(4);
        assertEquals(4,gs.getTag());
    }

    @Test
    void copy() {
        GUI_Shape gs = new GUIShape(new Point2D(),true,Color.BLUE,3);
        GUI_Shape gs2 = (GUI_Shape) gs.copy();
       Point2D[] arr1 = gs.getShape().getPoints();
        Point2D[] arr2 = gs2.getShape().getPoints();
        for (int i = 0; i <arr1.length ; i++) {
            assertEquals(arr1[i] , arr2[i]);
        }
        assertEquals(gs.getColor(),gs2.getColor());
        assertEquals(gs.isFilled(),gs2.isFilled());
        assertEquals(gs.getTag(),gs2.getTag());
        System.out.println(Color.BLUE.getRGB());
    }

    @Test
    void testToString() {
        GUI_Shape gs = new GUIShape(new Point2D(),true,Color.BLUE,3);
        String s = "Shape Kind: Point2D,0.0,0.0 . Filled?: true. Color: -16776961. Tag: 3.";
        assertEquals(gs.toString(),s);
        gs = new GUIShape(new Rect2D(new Point2D(), new Point2D(2,1)),true,Color.BLUE,3);
        s= "Shape Kind: Rect2D,0.0,0.0,2.0,1.0 . Filled?: true. Color: -16776961. Tag: 3.";
    }
}