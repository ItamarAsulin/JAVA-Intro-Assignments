package ex4.geometry;

/**
 * This class represents a 2D circle in the plane. Please make sure you update it
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 *
 * @author boaz.benmoshe
 */
public class Circle2D implements GeoShape {
    private Point2D _center;
    private double _radius;

    public Circle2D() {
        this._center = new Point2D();
        this._radius = 1;
    }

    public Circle2D(Point2D cen, double rad) {
        if (rad < 0) {
            System.err.println("Radius can not be negative. Radius set to 1 by default");
            this._center = new Point2D(cen);
            this._radius = 1;
        } else {
            this._center = new Point2D(cen);
            this._radius = rad;
        }
    }

    public Circle2D(Circle2D other) {
        this._center = new Point2D(other._center);
        this._radius = other.getRadius();

    }

    public double getRadius() {
        return this._radius;
    }

/**
 * Computes if the point (ot) falls inside this (closed) shape.
 * */
    @Override
    public boolean contains(Point2D ot) {
        double dist = ot.distance(this._center);
        return dist <= this._radius;
    }
    /**
     * Computes the center of mass of this shape
     * @return a 2D point
     */
    @Override
    public Point2D centerOfMass() {
        return new Point2D(this._center);
    }
    /**
     * Computes the area of this shape
     * @return
     */
    @Override
    public double area() {
        double ans = Math.PI * Math.pow(this._radius, 2);
        return ans;
    }
    /**
     * Computes the perimeter of this shape.
     * @return
     */
    @Override
    public double perimeter() {
        double ans = Math.PI * 2 * this._radius;
        return ans;
    }
    /**
     * Move this shape by the vector 0,0-->vec
     * Note: this method changes the inner state of the object.
     * @param vec - a vector from the 0,0
     */
    @Override
    public void move(Point2D vec) {
        _center.move(vec);
    }
    /** This method computes a new (deep) copy of this GeoShape
     * @return a deep copy of this GeoShape.
     */
    @Override
    public GeoShape copy() {
        return new Circle2D(new Point2D(_center.get_x(), _center.get_y()), this.getRadius());
    }

/**
 * This method return the dominant point of the shape:
 * Circle: center and a point on the boundary (in this order).
 * @return an array with all the points representing this GeoShape.
 * */
    @Override
    public Point2D[] getPoints() {
        Point2D[] ans = new Point2D[2];
        ans[0] = new Point2D(this._center);
        ans[1] = new Point2D(ans[0].x(), ans[0].y() + this._radius);
        return ans;
    }
    /**
     * This method returns a String representing this shape,
     * such that one can use this string for saving the shape into a text file.
     * @return a String representing this shape
     */
    @Override
    public String toString() {
        return "Circle2D," + _center.toString() + ", " + _radius;
    }


}