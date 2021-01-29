package ex4;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import ex4.geometry.*;
import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Shape_Collection implements GUI_Shape_Collection {
    private Vector<GUI_Shape> sc;

    /**
     * default constructor.
     */
    public Shape_Collection() {
        sc = new Vector<GUI_Shape>();
    }

    /**
     * given constructor.
     * @param length
     */
    public Shape_Collection(int length) {
        sc = new Vector<GUI_Shape>(length);

    }

    /**
     * copy constructor.
     * @param other
     */
    public Shape_Collection(Shape_Collection other) {
        this.sc = new Vector<GUI_Shape>(other.sc);
    }
    /**
     * This method return a reference to the i'th element in the collection.
     * @param i - the index of the element
     * @return a reference (NOT a copy) for the i'th element in the collection.
     */
    @Override
    public GUI_Shape get(int i) {
        return this.sc.get(i);

    }
    /**
     * return the size of the collection (if empty return 0).
     * @return
     */
    @Override
    public int size() {
        return this.sc.size();
    }
    /**
     * This method remove (and return) the gui_shape at the i'th location.
     * After removing the size of this collection decreases (by 1) and the order (of the elements) remains the same - just with out the removed element.
     * @param i - the index of the element to be removed.
     * @return the gui_shape which was removed
     */
    @Override
    public GUI_Shape removeElementAt(int i) {
        GUI_Shape remove;
        remove = sc.elementAt(i);
        this.sc.removeElementAt(i);
        return remove;
    }
    /**
     * This method adds the gui_element s to this collection in the i'th position.
     * Note: the method adds s "as is" (NOT a new copy of s).
     * @param s - the gui_shape
     * @param i - the location (index) in which s should be added
     */

    @Override
    public void addAt(GUI_Shape s, int i) {
        sc.add(i, s);
    }
    /**
     * This method adds the gui_element s to this collection in the last position.
     * Note: the method adds s "as is" (NOT a new copy of s).
     * @param s - the gui_shape
     */
    @Override
    public void add(GUI_Shape s) {
        sc.addElement(s);
    }
    /**
     * This method constructs a deep copy of this collection.
     * Note: the two collections are equal - yet they have no shared memory.
     * @return
     */
    @Override
    public GUI_Shape_Collection copy() {
        Shape_Collection copy = new Shape_Collection();
        for (int i = 0; i < sc.size(); i++) {
            copy.addAt(this.sc.elementAt(i), i);
        }
        return copy;
    }
    /** This method sorts this gui_shape collection according to the comp Comparator - in increasing order.
     *
     * @param comp a linear order over gui_sahpes as defined in java.util.Comparator
     */
    @Override
    public void sort(Comparator comp) {
        for (int i = 0; i < this.size() - 1; i++) {
            for (int j = 0; j < this.size() - 1; j++) {
                if (comp.compare(this.get(j), this.get(j + 1)) == 1)
                    this.addAt(this.removeElementAt(j + 1), j);


            }

        }

    }
    /**
     * This method simple removes all the elements from this collection.
     */
    @Override
    public void removeAll() {
        this.sc.clear();
    }
    /**
     * This method saves this gui_shape collection to a text file.
     * @param file - the file name in which this collection will be saved.
     */
    @Override
    public void save(String file) {
        String s = this.toString();
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(s);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method restore a gui_shape collection from text file (as saved be the save method).
     * Note this method changes the this collection.
     * @param file - the name of the text file to create a gui shape file from.
     * @return a new gui_shape collection (from file).
     */
    @Override
    public void load(String file) {
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String arr[] = data.split(",");
                GeoShape shape = null;

                if (arr[4].equals("Point2D")) {
                    shape = new Point2D(Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
                } else if (arr[4].equals("Segment2D")) {
                    Point2D p1 = new Point2D(Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
                    Point2D p2 = new Point2D(Double.parseDouble(arr[7]), Double.parseDouble(arr[8]));
                    shape = new Segment2D(p1, p2);
                } else if (arr[4].equals("Triangle2D")) {
                    Point2D p1 = new Point2D(Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
                    Point2D p2 = new Point2D(Double.parseDouble(arr[7]), Double.parseDouble(arr[8]));
                    Point2D p3 = new Point2D(Double.parseDouble(arr[9]), Double.parseDouble(arr[10]));
                    shape = new Triangle2D(p1, p2, p3);

                } else if (arr[4].equals("Rect2D")) {
                    Point2D p1 = new Point2D(Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
                    Point2D p2 = new Point2D(Double.parseDouble(arr[7]), Double.parseDouble(arr[8]));
                    shape = new Rect2D(p1, p2);
                } else {
                    double radius = Double.parseDouble(arr[7]);
                    Point2D p1 = new Point2D(Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
                    shape = new Circle2D(p1, radius);
                }

                GUIShape gs = new GUIShape(
                        shape, Boolean.parseBoolean(arr[2]), new Color(Integer.parseInt(arr[1])), Integer.parseInt(arr[3])
                );

                sc.add(gs);
            }

            myReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("File not found. Please enter correct path.");
        }
    }
    /**
     * This methods returns the minimal bounding box containing all the shapes in this collection.
     * @return
     */
    @Override
    public Rect2D getBoundingBox() {
        if (size() == 0)
            return new Rect2D();
        else {
            Point2D minPoint;
            Point2D maxPoint;
            GUI_Shape getGUIShape = this.sc.get(0);
            GeoShape whatShape = getGUIShape.getShape();
            Point2D[] shapePoints = whatShape.getPoints();
            minPoint = new Point2D(shapePoints[0]);
            maxPoint = new Point2D(shapePoints[0]);
            for (int i = 0; i < size(); i++) {
                getGUIShape = this.get(i);
                whatShape = getGUIShape.getShape();
                shapePoints = whatShape.getPoints();
                for (int j = 0; j < shapePoints.length; j++) {
                    if (whatShape instanceof Circle2D ) {
                        Point2D circleTopRightCorner = new Point2D(((whatShape).centerOfMass().get_x() + ((Circle2D) whatShape).getRadius()), whatShape.centerOfMass().get_y() + ((Circle2D) whatShape).getRadius());
                        Point2D circleBottomLeftCorner = new Point2D(((whatShape).centerOfMass().get_x() - ((Circle2D) whatShape).getRadius()), whatShape.centerOfMass().get_y() - ((Circle2D) whatShape).getRadius());
                        Rect2D circle = new Rect2D(circleBottomLeftCorner,circleTopRightCorner);
                        if (circle.getBottomLeft().get_x() < minPoint.get_x()) {
                            minPoint.set_x(circle.getBottomLeft().get_x());
                            if(circle.getTopRight().get_x()> maxPoint.get_x()) {
                                maxPoint.set_x(circle.getTopRight().get_x());
                            }

                        } else if ((circle.getBottomLeft().get_y() < minPoint.get_y())) {
                            minPoint.set_y(circle.getBottomLeft().get_y());
                            if(circle.getTopRight().get_y() > maxPoint.get_y()){
                                maxPoint.set_y(circle.getTopRight().get_y());
                            }
                        } else if ((circle.getTopRight().get_x() > maxPoint.get_x())) {
                            maxPoint.set_x(circle.getTopRight().get_x());

                        } else if ((circle.getTopRight().get_y() > maxPoint.get_y())) {
                            maxPoint.set_y(circle.getTopRight().get_y());
                        }

                    } else {
                        if (shapePoints[j].get_x() < minPoint.get_x()) {
                            minPoint.set_x(shapePoints[j].get_x());
                        } else if ((shapePoints[j].get_y() < minPoint.get_y())) {
                            minPoint.set_y(shapePoints[j].get_y());
                        } else if ((shapePoints[j].get_x() > maxPoint.get_x())) {
                            maxPoint.set_x(shapePoints[j].get_x());

                        } else if ((shapePoints[j].get_y() > maxPoint.get_y())) {
                            maxPoint.set_y(shapePoints[j].get_y());
                        }
                    }

                }

            }
            return new Rect2D(minPoint, maxPoint);
        }

    }

    /**
     * /**
     *      * returns a string of the GUIShape such that can be saved into a txt file.
     *      * @return
     */
    @Override
    public String toString() {
        String s = "";
        GUI_Shape[] shapeArray = new GUI_Shape[this.size()];
        for (int i = 0; i < this.size(); i++) {
            shapeArray[i] = this.sc.get(i);
        }

        for (int i = 0; i < shapeArray.length - 1; i++) {
            int c = shapeArray[i].getColor().getRGB()&0xffffff;
            if (shapeArray[i].getShape() instanceof Point2D)
                s += "GUIShape," + c + "," + shapeArray[i].isFilled() + "," + shapeArray[i].getTag() + ",Point2D," + shapeArray[i].getShape().toString() + "\n";
            else
                s += "GUIShape," + c + "," + shapeArray[i].isFilled() + "," + shapeArray[i].getTag() + "," + shapeArray[i].getShape().toString() + "\n";
        }
        int c = shapeArray[shapeArray.length -1].getColor().getRGB()&0xffffff;
        if (shapeArray[shapeArray.length - 1].getShape() instanceof Point2D)
            s += "GUIShape," + c + "," + shapeArray[shapeArray.length - 1].isFilled() + "," + shapeArray[shapeArray.length - 1].getTag() + ",Point2D," + shapeArray[shapeArray.length - 1].getShape().toString();
        else
            s += "GUIShape," + c
                    + "," + shapeArray[shapeArray.length - 1].isFilled() + "," + shapeArray[shapeArray.length - 1].getTag() + "," + shapeArray[shapeArray.length - 1].getShape().toString();

        return s;
    }
}
