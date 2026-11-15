package ge.tbc.testautomation.javaoop.figures;

public class Rectangle extends Figure{
    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getArea(){
        return a * b;
    }

    public double getPerimeter(){
        return (a + b) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + a + ", height=" + b + ", area=" + getArea() + "}";
    }
}