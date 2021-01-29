package ex4;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;

import java.awt.Color;

public class GUIShape implements GUI_Shape {
    private GeoShape shape;
    private boolean isFilled;
    private Color color;
    private int tag;


    /**
     * default constructor.
     */
    public GUIShape() {
        shape = new Point2D();
        isFilled = false;
        color = Color.BLACK;
        tag = 0;
    }

    /**
     * given constructor.
     * @param shape
     * @param isFilled
     * @param color
     * @param tag
     */
    public GUIShape(GeoShape shape, boolean isFilled, Color color, int tag) {
        this.shape = shape;
        this.isFilled = isFilled;
        this.color = color;
        this.tag = tag;
    }

    /**
     * copy constructor.
     * @param other
     */
    public GUIShape(GUIShape other) {
        this.shape = other.getShape();
        this.isFilled = other.isFilled;
        this.color = other.color;
        this.tag = other.tag;
    }

    /**
     * returns the GeoShape of the GUIShape.
     * @return
     */
    @Override
    public GeoShape getShape() {
        return this.shape;
    }

    /**
     * sets the GeoHsape of the GUIShape.
     * @param g
     */
    @Override
    public void setShape(GeoShape g) {
        this.shape = g;
    }

    /**
     * returns if the GUIShape is filled or not.
     * @return
     */
    @Override
    public boolean isFilled() {
       if(this.getShape().area() == 0)
           return false;
       else
           return this.isFilled;
    }

    /**
     * sets the filled status of the GUIShape.
     * @param filled
     */
    @Override
    public void setFilled(boolean filled) {
        this.isFilled = filled;

    }

    /**
     * returns the color of the GUIShape.
     * @return
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * sets the color of the GUIShape.
     * @param cl
     */
    @Override
    public void setColor(Color cl) {
        this.color = cl;
    }

    /**
     * returns the tag of the GUIShape.
     * @return
     */
    @Override
    public int getTag() {
        return this.tag;
    }

    /**
     * sets the tag of the GUIShape.
     * @param tag
     */
    @Override
    public void setTag(int tag) {
     this.tag = tag   ;
    }

    /**
     * creates a deep copy of the GUIShape.
     * @return
     */
    @Override
    public GUI_Shape copy() {

       return new GUIShape(this.getShape(),this.isFilled,this.getColor(),this.tag);
    }

    /**
     * returns a string of the GUIShape such that can be saved into a txt file.
     * @return
     */
    @Override
    public String toString() {
        if(this.getShape() instanceof Point2D)
        return "Shape Kind: Point2D," +this.shape + " . Filled?: " +this.isFilled + ". Color: " + this.color.getRGB() + ". Tag: " +this.tag+".";
        else
            return "Shape Kind: " + this.getShape().toString() + " . Filled?: " +this.isFilled + ". Color: " + this.color.getRGB() + ". Tag: " +this.tag+".";
    }



}