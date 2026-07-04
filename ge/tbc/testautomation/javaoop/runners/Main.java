package ge.tbc.testautomation.javaoop.runners;

import ge.tbc.testautomation.javaoop.figures.Circle;
import ge.tbc.testautomation.javaoop.util.Util;
import java.util.Random;

import ge.tbc.testautomation.javaoop.figures.Figure;
import ge.tbc.testautomation.javaoop.figures.Rectangle;
import ge.tbc.testautomation.javaoop.figures.Triangle;
import ge.tbc.testautomation.javaoop.util.HelperFunctions;

import ge.tbc.testautomation.exceptionsStringOperationsRegex.LimitException;
import ge.tbc.testautomation.exceptionsStringOperationsRegex.RadiusException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Circle demo ===");
        Circle circle = new Circle(5);
        circle.printPackageName();
        System.out.printf("Area: %.2f%n", circle.getArea());
        System.out.printf("Length (circumference): %.2f%n", circle.getLength());
        System.out.println("Is valid? " + circle.validateFigure());

        circle.doubleSize();
        System.out.printf("After doubleSize -> radius: %.2f, area: %.2f%n",
                circle.getRadius(), circle.getArea());

        circle.customSize(0.5);
        System.out.printf("After customSize(0.5) -> radius: %.2f, area: %.2f%n",
                circle.getRadius(), circle.getArea());

        System.out.println();
        System.out.println("=== Triangle demo ===");
        Triangle triangle = new Triangle(3, 4, 5);
        triangle.printPackageName();
        System.out.printf("Area: %.2f%n", triangle.getArea());
        System.out.printf("Length (perimeter): %.2f%n", triangle.getLength());
        System.out.println("Is valid? " + triangle.validateFigure());

        triangle.doubleSize();
        System.out.printf("After doubleSize -> perimeter: %.2f, area: %.2f%n",
                triangle.getLength(), triangle.getArea());

        triangle.customSize(0.5);
        System.out.printf("After customSize(0.5) -> perimeter: %.2f, area: %.2f%n",
                triangle.getLength(), triangle.getArea());


        try {
            Circle invalidCircle = new Circle(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            Triangle invalidTriangle = new Triangle(1, 1, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}