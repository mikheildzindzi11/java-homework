package ge.tbc.testautomation.javaoop.figures;

import ge.tbc.testautomation.abstractClassesInterfaces.interfaces.IResizable;
import ge.tbc.testautomation.abstractClassesInterfaces.interfaces.IValidFigure;

public class Triangle extends Figure implements IResizable, IValidFigure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // validation
        if (!validateFigure()) {
            throw new IllegalArgumentException(
                    "Invalid triangle sides: " + a + ", " + b + ", " + c);
        }
    }

    public double getArea(){
        double s = getLength() / 2;
        return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
    }

    @Override
    public double getLength() {
        return this.a + this.b + this.c;
    }

    @Override
    public void printPackageName() {
        System.out.println(this.getClass().getPackage().getName());
    }


    @Override
    public void doubleSize() {
        this.a *= 2;
        this.b *= 2;
        this.c *= 2;
    }

    @Override
    public void customSize(double byValue) {
        this.a *= byValue;
        this.b *= byValue;
        this.c *= byValue;
    }

    @Override
    public boolean validateFigure() {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && c + b > c;
    }
}