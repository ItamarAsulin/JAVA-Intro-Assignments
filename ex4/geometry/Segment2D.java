package ex4.geometry;

/**
 * This class represents a 2D segment on the plane,
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Segment2D implements GeoShape {
    private Point2D start;
    private Point2D end;

    /**
     * this method is a default constructor.
     */
    public Segment2D() {
        this.start = new Point2D(0, 0);
        this.end = new Point2D(0, 0);
    }

    /**
     * this method returns the start point.
     * @return
     */
    public Point2D getStart() {
        return start;
    }

    /**
     * this method sets the start point.
     * @param start
     */
    public void setStart(Point2D start) {
        this.start = start;
    }
/**
 *this method returns the end point.
 */
    public Point2D getEnd() {
        return end;
    }

    /**
     * this methos sets the end point.
     * @param end
     */
    public void setEnd(Point2D end) {
        this.end = end;
    }

    /**
     * this method is a given dots constructor.
     * @param start
     * @param end
     */
    public Segment2D(Point2D start, Point2D end) {
        if(start.get_x() < end.get_x()) {
            this.start = start;
            this.end = end;
        }else{
            this.start = end;
            this.end = start;
        }
        }

    /**
     * this method is a copy constructor.
     * @param other
     */
    public Segment2D(Segment2D other) {
        this.start = new Point2D(other.start);
        this.end = new Point2D(other.end);
    }
    /**
     * Computes if the point (ot) falls inside this (closed) shape.
     * */
    @Override
    public boolean contains(Point2D ot) {
        if(ot.distance(this.start) + ot.distance(this.end) == this.start.distance(this.end)) {
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Computes the center of mass of this shape
     * @return a 2D point
     */
    @Override
    public Point2D centerOfMass() {
     return  new Point2D(Math.min(this.start.get_x(),this.end.get_x() )+ (Math.max(this.start.get_x(),this.end.get_x()) - Math.min(this.start.get_x(),this.end.get_x()))/2, Math.min(this.start.get_y(),this.end.get_y() )+ (Math.max(this.start.get_y(),this.end.get_y()) - Math.min(this.start.get_y(),this.end.get_y()))/2);
    }

    /**
     * Computes the area of this shape.
     * @return
     */
    @Override
    public double area() {
        return 0;
    }
    /**
     * Computes the perimeter of this shape.
     * @return
     */
    @Override
    public double perimeter() {
        return 2 * this.start.distance(this.end);
    }
    /**
     * Move this shape by the vector 0,0-->vec
     * Note: this method changes the inner state of the object.
     * @param vec - a vector from the 0,0
     */
    @Override
    public void move(Point2D vec) {
        this.start.move(vec);
        this.end.move(vec);
    }
    /** This method computes a new (deep) copy of this GeoShape
     * @return a deep copy of this GeoShape.
     */
    @Override
    public GeoShape copy() {
        Point2D copyStart = new Point2D(this.start.get_x(), this.start.get_y());
        Point2D copyEnd = new Point2D(this.end.get_x(), this.end.get_y());
        Segment2D copy = new Segment2D(copyStart, copyEnd);
        return copy;
    }
    /**
     * This method return the dominant point of the shape:
     * Segment: the two end points
     * @return an array with all the points representing this GeoShape.
     * */
    @Override
    public Point2D[] getPoints() {
        Point2D[] getPoints = new Point2D[2];
        getPoints[0] = this.start;
        getPoints[1] = this.end;
        return getPoints;
    }
    /**
     * This method returns a String representing this shape,
     * such that one can use this string for saving the shape into a text file.
     * @return a String representing this shape
     */
    @Override
    public String toString() {
        return  "Segment2D," +start.toString() + "," + end.toString();

    }

}