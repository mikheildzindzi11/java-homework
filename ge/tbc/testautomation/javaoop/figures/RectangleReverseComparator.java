package ge.tbc.testautomation.javaoop.figures;

import java.util.Comparator;

public class RectangleReverseComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Rectangle first = (Rectangle) o1;
        Rectangle second = (Rectangle) o2;

        if (first.getArea() > second.getArea()) {
            return -1;
        } else if (first.getArea() < second.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}