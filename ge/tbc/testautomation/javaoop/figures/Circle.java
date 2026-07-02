package ge.tbc.testautomation.javaoop.figures;

import ge.tbc.testautomation.exceptionsStringOperationsRegex.LimitException;
import ge.tbc.testautomation.exceptionsStringOperationsRegex.RadiusException;

public class Circle extends Figure {
    private double radius;
    public static int numberOfCircleInstances = 0;

    public Circle(double radius) {
        super();

        if (numberOfInstances > 5) {
            throw new LimitException("INSTANTIATION LIMIT REACHED");
        }

        if (radius <= 0) {
            throw new RadiusException("RADIUS VALUE NOT VALID");
        }

        this.radius = radius;
        numberOfCircleInstances++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}