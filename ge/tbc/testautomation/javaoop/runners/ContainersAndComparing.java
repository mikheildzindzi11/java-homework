package ge.tbc.testautomation.javaoop.runners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import ge.tbc.testautomation.javaoop.figures.Circle;
import ge.tbc.testautomation.javaoop.figures.Rectangle;
import ge.tbc.testautomation.javaoop.figures.RectangleReverseComparator;

public class ContainersAndComparing {
    public static void main(String[] args) {

        // 2) ArrayList String ელემენტებით (raw ტიპი, Generics-ის გარეშე)
        ArrayList phoneNumbers = new ArrayList();
        phoneNumbers.add("555-542-231");
        phoneNumbers.add("555-887-987");
        phoneNumbers.add("555-161-143");
        phoneNumbers.add("555-189-6667");

        // 3) ლისტის ელემენტების დაბეჭდვა იტერატორით (casting Object -> String)
        System.out.println("ტელეფონის ნომრები:");
        Iterator numbersIterator = phoneNumbers.iterator();
        while (numbersIterator.hasNext()) {
            Object element = numbersIterator.next();
            String phoneNumber = (String) element;
            System.out.println(phoneNumber);
        }

        // 4) HashMap <სახელი, ტელეფონის ნომერი>
        HashMap contacts = new HashMap();
        contacts.put("გიორგი", phoneNumbers.get(0));
        contacts.put("ნინო", phoneNumbers.get(1));
        contacts.put("ლუკა", phoneNumbers.get(2));
        contacts.put("სალომე", phoneNumbers.get(3));

        // 5) იმ სახელების დაბეჭდვა, ვისი ნომერიც შეიცავს "8"-ს
        System.out.println("\nსახელები, ვისი ნომერიც შეიცავს 8-იანს:");
        Iterator keysIterator = contacts.keySet().iterator();
        while (keysIterator.hasNext()) {
            Object keyObject = keysIterator.next();
            String name = (String) keyObject;

            Object valueObject = contacts.get(name);
            String phoneNumber = (String) valueObject;

            if (phoneNumber.contains("8")) {
                System.out.println(name);
            }
        }

        // 7) TreeSet<Circle> - 10 წრეწირი, ზოგს ერთნაირი რადიუსი
        TreeSet circleTreeSet = new TreeSet();
        circleTreeSet.add(new Circle(5));
        circleTreeSet.add(new Circle(2));
        circleTreeSet.add(new Circle(8));
        circleTreeSet.add(new Circle(5));  // დუბლიკატი რადიუსი
        circleTreeSet.add(new Circle(1));
        circleTreeSet.add(new Circle(9));
        circleTreeSet.add(new Circle(2));  // დუბლიკატი რადიუსი
        circleTreeSet.add(new Circle(7));
        circleTreeSet.add(new Circle(3));
        circleTreeSet.add(new Circle(9));  // დუბლიკატი რადიუსი

        System.out.println("\nTreeSet<Circle> (დალაგებული, დუბლიკატი რადიუსები გაქრა):");
        System.out.println(circleTreeSet);
        System.out.println("ზომა: " + circleTreeSet.size());

        // 8) იგივე ობიექტები HashSet-ში
        HashSet circleHashSet = new HashSet();
        circleHashSet.add(new Circle(5));
        circleHashSet.add(new Circle(2));
        circleHashSet.add(new Circle(8));
        circleHashSet.add(new Circle(5));
        circleHashSet.add(new Circle(1));
        circleHashSet.add(new Circle(9));
        circleHashSet.add(new Circle(2));
        circleHashSet.add(new Circle(7));
        circleHashSet.add(new Circle(3));
        circleHashSet.add(new Circle(9));

        System.out.println("\nHashSet<Circle> (დალაგება არ არის, ყველა ობიექტი შემორჩა):");
        System.out.println(circleHashSet);
        System.out.println("ზომა: " + circleHashSet.size());

        // 9) Rectangle-ების სია, დალაგებული reverse comparator-ით
        ArrayList rectangles = new ArrayList();
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(10, 2));
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(5, 5));
        rectangles.add(new Rectangle(2, 8));

        Collections.sort(rectangles, new RectangleReverseComparator());

        System.out.println("\nRectangle-ების სია, დალაგებული ფართობის კლებადობით (reverse comparator):");
        Iterator rectanglesIterator = rectangles.iterator();
        while (rectanglesIterator.hasNext()) {
            Object rectObject = rectanglesIterator.next();
            Rectangle rectangle = (Rectangle) rectObject;
            System.out.println(rectangle);
        }
    }
}
