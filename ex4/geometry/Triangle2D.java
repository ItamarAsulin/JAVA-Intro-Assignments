package ex4.geometry;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Triangle2D implements GeoShape {
    private Point2D p1;
    private Point2D p2;
    private Point2D p3;

    /**
     * this method is a default constructor.
     */
    public Triangle2D() {
        p1 = new Point2D(0,0);
        p2 = new Point2D(3,0);
        p3 = new Point2D(1.5,3);
    }

    /**
     * this method is a constructor by given points.
     * this method validate the input for a triangle.
     * @param a
     * @param b
     * @param c
     */
    public Triangle2D(Point2D a, Point2D b, Point2D c) {
        if(a.get_x() == b.get_x() && b.get_x() == c.get_x() && a.get_y() == b.get_y() && b.get_y() == c.get_y()){
            System.err.println("A Triangle can not be set with 3 equal points. set to default Triangle. Point set to : a:0.0,0.0 b:3.0,0.0 c: 1.5,3.0");
            this.p1 = new Point2D(0,0);
            this.p2 = new Point2D(3,0);
            this.p3 = new Point2D(1.5,3);
        }else {
            this.p1 = a;
            this.p2 = b;
            this.p3 = c;
        }
    }

    /**
     * this method returns the first point
     * @return
     */
    public Point2D getP1() {
        return p1;
    }
    /**
     * this method returns the second point
     * @return
     */
    public Point2D getP2() {
        return p2;
    }
    /**
     * this method returns the third point
     * @return
     */
    public Point2D getP3() {
        return p3;
    }

    /**
     * this method is a copy constructor.
     * @param other
     */
    public Triangle2D(Triangle2D other) {
        this.p1 = new Point2D(other.p1);
        this.p2 = new Point2D(other.p2);
        this.p3 = new Point2D(other.p3);
    }
    /**
     * Computes if the point (ot) falls inside this (closed) shape.
     * */
    @Override
    public boolean contains(Point2D ot) {
        Triangle2D a1 = new Triangle2D(ot, this.p1, this.p2);
        Triangle2D a2 = new Triangle2D(ot, this.p2, this.p3);
        Triangle2D a3 = new Triangle2D(ot, this.p3, this.p1);
        double allAreas = a1.area() + a2.area() + a3.area();
        if (this.area() >= allAreas)
            return true;
        else return false;
    }
    /**
     * Computes the center of mass of this shape
     * @return a 2D point
     */
    @Override
    public Point2D centerOfMass() {
        Point2D centerOfMass = new Point2D((this.p1.get_x() + this.p2.get_x() + this.p3.get_x()) / 3, (this.p1.get_y() + this.p2.get_y() + this.p3.get_y()) / 3);
        return centerOfMass;
    }



    /**
     * Computes the area of this shape.
     * @return
     */
    @Override
    public double area() {
        double d = perimeter() / 2;
        double a = this.p1.distance(this.p2);
        double b = this.p2.distance(this.p3);
        double c = this.p3.distance(this.p1);
        double area = Math.sqrt(d * (d - a) * (d - b) * (d - c));
        return area;
    }
    /**
     * Computes the perimeter of this shape.
     * @return
     */
    @Override
    public double perimeter() {
        double perimeter = this.p1.distance(this.p2) + this.p2.distance(this.p3) + this.p3.distance(this.p1);
        return perimeter;
    }
    /**
     * Move this shape by the vector 0,0-->vec
     * Note: this method changes the inner state of the object.
     * @param vec - a vector from the 0,0
     */
    @Override
    public void move(Point2D vec) {
        this.p1.move(vec);
        this.p2.move(vec);
        this.p3.move(vec);
    }
    /** This method computes a new (deep) copy of this GeoShape
     * @return a deep copy of this GeoShape.
     */
    @Override
    public GeoShape copy() {
        Triangle2D copy = new Triangle2D(new Point2D(this.p1), new Point2D(this.p2), new Point2D(this.p3));
        return copy;
    }
    /**
     * This method return the dominant point of the shape:
     * Triangle: all 3 points
     * @return an array with all the points representing this GeoShape.
     * */
    @Override
    public Point2D[] getPoints() {
        Point2D[] getPoints = new Point2D[3];
        getPoints[0] = this.p1;
        getPoints[1] = this.p2;
        getPoints[2] = this.p3;
        return getPoints;
    }
    /**
     * This method returns a String representing this shape,
     * such that one can use this string for saving the shape into a text file.
     * @return a String representing this shape
     */
    @Override
    public String toString() {
        return "Triangle2D," +p1.toString() + "," + p2.toString() + "," + p3.toString();

    }

}