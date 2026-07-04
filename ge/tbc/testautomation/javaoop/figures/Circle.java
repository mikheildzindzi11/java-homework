package ge.tbc.testautomation.javaoop.figures;

import ge.tbc.testautomation.abstractClassesInterfaces.interfaces.IResizable;
import ge.tbc.testautomation.abstractClassesInterfaces.interfaces.IValidFigure;
import ge.tbc.testautomation.exceptionsStringOperationsRegex.LimitException;
import ge.tbc.testautomation.exceptionsStringOperationsRegex.RadiusException;

public class Circle extends Figure implements IResizable, IValidFigure {
    private double radius;
    public static int numberOfCircleInstances = 0;

    public Circle(double radius) {
        this.radius = radius;

        // validation
        if (!validateFigure()) {
            throw new IllegalArgumentException("Invalid circle: radius must be positive. Got: " + radius);
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void printPackageName() {
        System.out.println(this.getClass().getPackage().getName());
    }

    @Override
    public void doubleSize() {
        radius *= 2;
    }

    @Override
    public void customSize(double byValue) {
        radius *= byValue;
    }

    @Override
    public boolean validateFigure() {
        return radius > 0;
    }
}