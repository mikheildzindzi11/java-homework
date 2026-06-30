package ge.tbc.testautomation.javaoop.util;

import ge.tbc.testautomation.javaoop.figures.Rectangle;

public class HelperFunctions {

    public static void compareRectangles(Rectangle r1, Rectangle r2) {
        double p1 = r1.getPerimeter();
        double p2 = r2.getPerimeter();

        String symbol;
        if (p1 > p2) {
            symbol = ">";
        } else if (p1 < p2) {
            symbol = "<";
        } else {
            symbol = "=";
        }

        System.out.println("parameter 1 " + symbol + " parameter 2");
    }
}