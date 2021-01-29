package ex4;

import ex4.geometry.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 *
 * @author boaz.benmoshe
 */
public class Ex4 implements Ex4_GUI {
    private Shape_Collection sc;

    /**
     * default constructor for Ex4
     */
    public Ex4() {
        this.sc = new Shape_Collection();
    }
    /**
     * This method inits the GUI_Shape_Collection - which will be presented bt Ex4
     * @param g: the GUI_Shape_Collection object
     */
    @Override
    public void init(GUI_Shape_Collection g) {
        this.sc = (Shape_Collection) g;
    }
    /**
     * This method returns a link to the GUI_Shape_Collection
     * @return
     */
    @Override
    public GUI_Shape_Collection getShape_Collection() {
        return this.sc;
    }
    /**
     * This method presents the GUI shapes in this collection in a GUI window.
     */
    @Override
    public void show() {
        for (int i = 0; i < this.sc.size(); i++) {
            if (sc.get(i).getShape() instanceof Point2D) {
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(sc.get(i).getColor());
                StdDraw.point(((Point2D) sc.get(i).getShape()).get_x(), ((Point2D) sc.get(i).getShape()).get_y());
            } else if (sc.get(i).getShape() instanceof Segment2D) {
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(sc.get(i).getColor());
                StdDraw.line(((Segment2D) sc.get(i).getShape()).getStart().get_x(), ((Segment2D) sc.get(i).getShape()).getStart().get_y(), ((Segment2D) sc.get(i).getShape()).getEnd().get_x(), ((Segment2D) sc.get(i).getShape()).getEnd().get_y());
            } else if (sc.get(i).getShape() instanceof Rect2D) {
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(sc.get(i).getColor());
                double height = (Math.abs(((Rect2D) sc.get(i).getShape()).getBottomLeft().get_y() - ((Rect2D) sc.get(i).getShape()).getTopRight().get_y())) / 2;
                double length = (Math.abs(((Rect2D) sc.get(i).getShape()).getBottomLeft().get_x() - ((Rect2D) sc.get(i).getShape()).getTopRight().get_x())) / 2;
                if (sc.get(i).isFilled()) {
                    StdDraw.filledRectangle(sc.get(i).getShape().centerOfMass().get_x(), sc.get(i).getShape().centerOfMass().get_y(), length, height);
                } else {
                    StdDraw.rectangle(sc.get(i).getShape().centerOfMass().get_x(), sc.get(i).getShape().centerOfMass().get_y(), length, height);
                }
            } else if (sc.get(i).getShape() instanceof Triangle2D) {
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(sc.get(i).getColor());
                StdDraw.line(((Triangle2D) sc.get(i).getShape()).getP1().get_x(), ((Triangle2D) sc.get(i).getShape()).getP1().get_y(), ((Triangle2D) sc.get(i).getShape()).getP2().get_x(), ((Triangle2D) sc.get(i).getShape()).getP2().get_y());
                StdDraw.line(((Triangle2D) sc.get(i).getShape()).getP2().get_x(), ((Triangle2D) sc.get(i).getShape()).getP2().get_y(), ((Triangle2D) sc.get(i).getShape()).getP3().get_x(), ((Triangle2D) sc.get(i).getShape()).getP3().get_y());
                StdDraw.line(((Triangle2D) sc.get(i).getShape()).getP1().get_x(), ((Triangle2D) sc.get(i).getShape()).getP1().get_y(), ((Triangle2D) sc.get(i).getShape()).getP3().get_x(), ((Triangle2D) sc.get(i).getShape()).getP3().get_y());
                if (sc.get(i).isFilled()) {
                    Point2D[] arr = sc.get(i).getShape().getPoints();
                    double[] x = new double[arr.length];
                    double[] y = new double[arr.length];
                    for (int j = 0; j < arr.length; j++) {
                        x[j] = arr[j].get_x();
                        y[j] = arr[j].get_y();
                    }
                    StdDraw.filledPolygon(x, y);
                }
            } else if (sc.get(i).getShape() instanceof Circle2D) {
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(sc.get(i).getColor());
                if (sc.get(i).isFilled()) {
                    StdDraw.filledCircle(sc.get(i).getShape().centerOfMass().get_x(), sc.get(i).getShape().centerOfMass().get_y(), ((Circle2D) sc.get(i).getShape()).getRadius());
                } else {
                    StdDraw.circle(sc.get(i).getShape().centerOfMass().get_x(), sc.get(i).getShape().centerOfMass().get_y(), ((Circle2D) sc.get(i).getShape()).getRadius());
                }
            }
        }

    }
    /**
     * This method returns a String containing all the "toString" of each GUI_shape in the collection.
     * @return - a String with all the "toString"s af all shapes in the collection.
     */
    @Override
    public String getInfo() {
        return this.sc.toString();
    }

    /**
     * the Main method recive a txt file path and a sort num int, load the txt file,
     * then sort it by the given int and then prints it.
     * @param args
     */
    public static void main(String[] args) {
        validateArgs(args);
        String file = args[0];
        int comparingMethod = Integer.parseInt(args[1]);
        validateComparingMethod(comparingMethod);
        Ex4 win = new Ex4();
        GUI_Shape_Collection sc = win.getShape_Collection();
        sc.load(file);
        Shape_Comp comp = new Shape_Comp(comparingMethod);
        sc.sort(comp);
        Rect2D bb = sc.getBoundingBox();
        Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
        double m0 = Math.min(min.x(), min.y());
        double m1 = Math.max(max.x(), max.y());
        StdDraw.setCanvasSize(Ex4_Const.Width, Ex4_Const.Height);
        StdDraw.setScale(m0 - 0.1, m1 + 0.1);
        win.show();
    }

    /**
     * this moethod validates the given comparator.
     * @param comparingMethod
     */
    private static void validateComparingMethod(int comparingMethod) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        boolean compIntInRange = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == comparingMethod)
                compIntInRange = true;
        }
        if (compIntInRange == false) {
            String s = Arrays.toString(arr);
            System.err.println("Wrong comparing method number entered. please enter a number from the following:" + s);
            System.exit(0);
        }
    }

    /**
     * this method validates the input in cmd.
     * @param args
     */
    private static void validateArgs(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid number of args");
            System.exit(0);
        }
    }
}
