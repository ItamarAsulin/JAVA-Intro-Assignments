package ex4.geometry;

import java.awt.*;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Rect2D implements GeoShape {
    private Point2D bottomLeft;
    private Point2D topRight;

    /**
     * this method is a default constructor.
     */
    public Rect2D() {
        this.bottomLeft = new Point2D();
        this.topRight = new Point2D(2,1);
    }

    /**
     * this method recives two dots in order to build a rectangle.
     * this method also makes sure that the given rectangle is valid,
     * and changes the dots in such way that the rect will be built from
     * bottom left corner and top right corner.
     * @param bottomLeft
     * @param topRight
     */
    public Rect2D(Point2D bottomLeft, Point2D topRight) {
        if(bottomLeft.get_x() == topRight.get_x() && bottomLeft.get_y() == topRight.get_y()){
            System.err.println("Rectangle can not be a dot. Set to default Rectangle. bottom left = 0,0. top right = 2,1.");
            this.bottomLeft = new Point2D();
            this.topRight = new Point2D(2,1);
        }
        else if (bottomLeft.get_x() < topRight.get_x()) {
            if (bottomLeft.get_y() < topRight.get_y()) {
                this.bottomLeft = new Point2D(bottomLeft.get_x(),bottomLeft.get_y());
                this.topRight = new Point2D(topRight.get_x(),topRight.get_y());
            } else {
                this.bottomLeft = new Point2D(bottomLeft.get_x(), topRight.get_y());
                this.topRight = new Point2D(topRight.get_x(), bottomLeft.get_y());
            }
        } else {
           if(topRight.get_y() < bottomLeft.get_y()){
               this.bottomLeft = new Point2D(topRight.get_x(),topRight.get_y());
               this.topRight = new Point2D(bottomLeft.get_x(),bottomLeft.get_y());
           }else{
               this.bottomLeft = new Point2D(topRight.get_x(), bottomLeft.get_y());
               this.topRight = new Point2D(bottomLeft.get_x(), topRight.get_y());
           }
        }
    }

    /**
     * this method is a copy constructor.
     * @param other
     */
    public Rect2D(Rect2D other) {
        this.topRight = new Point2D(other.topRight);
        this.bottomLeft = new Point2D(other.bottomLeft);
    }

    public Point2D getBottomLeft() {
        return this.bottomLeft;
    }

    public void setBottomLeft(Point2D bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point2D getTopRight() {
        return this.topRight;
    }

    public void setTopRight(Point2D topRight) {
        this.topRight = topRight;
    }
    public String shapeName(){
        return "Rect2D";
    }
/**
 * Computes if the point (ot) falls inside this (closed) shape.
 * */
    @Override
    public boolean contains(Point2D ot) {
        double bottomLeftMinusOtX = this.bottomLeft.get_x() - ot.get_x();
        double bottomLeftMinusOtY = this.bottomLeft.get_y() - ot.get_y();
        double topRightMinusOtX = this.topRight.get_x() - ot.get_x();
        double topRightMinusOty = this.topRight.get_y() - ot.get_y();
        if(bottomLeftMinusOtX<=0 && bottomLeftMinusOtY<=0 && topRightMinusOtX>= 0 && topRightMinusOty >=0)
            return true;
        else
            return false;
    }
    /**
     * Computes the center of mass of this shape
     * @return a 2D point
     */

    @Override
    public Point2D centerOfMass() {
        return new Point2D((this.bottomLeft.get_x() + (this.topRight.get_x()-this.bottomLeft.get_x())/2), (this.topRight.get_y() - (this.topRight.get_y()- this.bottomLeft.get_y())/2));
    }
    /**
     * Computes the area of this shape.
     * @return
     */
    @Override
    public double area() {
        Point2D bottomRight = new Point2D(topRight.get_x(), bottomLeft.get_y());
        double area = this.bottomLeft.distance(bottomRight)*bottomRight.distance(this.topRight);
        return area;
    }
    /**
     * Computes the perimeter of this shape.
     * @return
     */
    @Override
    public double perimeter() {
        Point2D bottomRight = new Point2D(topRight.get_x(), bottomLeft.get_y());
        double perimeter = (this.bottomLeft.distance(bottomRight) + bottomRight.distance(this.topRight)) * 2;
        return perimeter;
    }
    /**
     * Move this shape by the vector 0,0-->vec
     * Note: this method changes the inner state of the object.
     * @param vec - a vector from the 0,0
     */
    @Override
    public void move(Point2D vec) {
        this.bottomLeft.move(vec);
        this.topRight.move(vec);
    }
    /** This method computes a new (deep) copy of this GeoShape
     * @return a deep copy of this GeoShape.
     */
    @Override
    public GeoShape copy() {
        Point2D copyBottomLeft = new Point2D(this.bottomLeft.get_x(), this.bottomLeft.get_y());
        Point2D copyTopRight = new Point2D(this.topRight.get_x(),this.topRight.get_y());
        Rect2D copy = new Rect2D(copyBottomLeft, copyTopRight);
        return copy;
    }
    /**
     * This method return the dominant point of the shape:
     * Rectangle: min,max 2 points (left-low, right-up).
     * @return an array with all the points representing this GeoShape.
     * */
    @Override
    public Point2D[] getPoints() {
        Point2D [] getPoints = new Point2D[2];
        getPoints[0] = this.bottomLeft;
        getPoints[1] = this.topRight;
        return getPoints;

    }
    /**
     * This method returns a String representing this shape,
     * such that one can use this string for saving the shape into a text file.
     * @return a String representing this shape
     */
    @Override
    public String toString() {
        return "Rect2D," + bottomLeft.toString() + "," + topRight.toString();
    }

}
