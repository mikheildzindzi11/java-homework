package ge.tbc.testautomation.javaoop.figures;

import ge.tbc.testautomation.exceptionsStringOperationsRegex.LimitException;
import ge.tbc.testautomation.exceptionsStringOperationsRegex.RadiusException;

public class Circle extends Figure implements Comparable{
    private double radius;
    public static int numberOfCircleInstances = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + "}";
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Object o) {
        Circle other = (Circle) o;

        if (this.radius > other.radius) {
            return 1;
        } else if (this.radius < other.radius) {
            return -1;
        } else {
            return 0;
        }
    }
}