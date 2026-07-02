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
        Random random = new Random();

        // ბონუსი: რანდომული რადიუსები 1..50 შუალედში
        Circle c1 = new Circle(random.nextInt(50) + 1);
        System.out.println("numberOfCircleInstances: " + Circle.numberOfCircleInstances);

        Circle c2 = new Circle(random.nextInt(50) + 1);
        System.out.println("numberOfCircleInstances: " + Circle.numberOfCircleInstances);

        Circle c3 = new Circle(random.nextInt(50) + 1);
        System.out.println("numberOfCircleInstances: " + Circle.numberOfCircleInstances);

        Circle c4 = new Circle(random.nextInt(50) + 1);
        System.out.println("numberOfCircleInstances: " + Circle.numberOfCircleInstances);

        Circle c5 = new Circle(random.nextInt(50) + 1);
        System.out.println("numberOfCircleInstances: " + Circle.numberOfCircleInstances);

        // circleToString ყველა ობიექტისთვის
        String s1 = Util.circleToString(c1);
        String s2 = Util.circleToString(c2);
        String s3 = Util.circleToString(c3);
        String s4 = Util.circleToString(c4);
        String s5 = Util.circleToString(c5);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        // Figure
        Figure figure = new Figure();
        System.out.println("Figure area:      " + figure.getArea());
        System.out.println("Figure perimeter: " + figure.getPerimeter());

        // Rectangle
        Rectangle rect1 = new Rectangle(4.0, 6.0);
        System.out.println("\nRect1 area:      " + rect1.getArea());      // 24.0
        System.out.println("Rect1 perimeter: " + rect1.getPerimeter());  // 20.0

        Rectangle rect2 = new Rectangle(3.0, 5.0);
        System.out.println("\nRect2 area:      " + rect2.getArea());      // 15.0
        System.out.println("Rect2 perimeter: " + rect2.getPerimeter());  // 16.0

        // Triangle (a=5, b=4, c=3, h=4 — სიმაღლე ხელით გაწერილი)
        Triangle triangle = new Triangle(5.0, 4.0, 3.0, 4.0);
        System.out.println("\nTriangle area:      " + triangle.getArea());      // 10.0
        System.out.println("Triangle perimeter: " + triangle.getPerimeter()); // 12.0

        // BONUS — სტატიკური მეთოდი
        System.out.println();
        HelperFunctions.compareRectangles(rect1, rect2); // parameter 1 > parameter 2
        HelperFunctions.compareRectangles(rect2, rect1); // parameter 1 < parameter 2
        HelperFunctions.compareRectangles(rect1, rect1); // parameter 1 = parameter 2


        // დავალება - Java Exceptions, String Operations & Regex
        // 7) წრეწირის შექმნა უარყოფითი რადიუსით -> RadiusException
        try {
            Circle invalidCircle = new Circle(-5);
        } catch (RadiusException e) {
            System.out.println(e.getMessage());
        }

        // 8) ობიექტების დაინსტანცირება, სანამ ლიმიტს მიაღწევს (LimitException)
        try {
            for (int i = 1; i <= 10; i++) {
                Circle circle = new Circle(i);
                System.out.println("Circle #" + i + " created, radius = " + circle.getRadius());
            }
        } catch (LimitException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------------");

        // 9) სტრინგული ოპერაციები
        String sentence = "Test Automation Bootcamp 12, 2025";

        // მხოლოდ "Automation" სიტყვის დაბეჭდვა დაბალ რეგისტრში
        String[] wordsForExtraction = sentence.split(" ");
        String automationWord = wordsForExtraction[1].toLowerCase();
        System.out.println(automationWord);

        // წინადადების სტრიქონების მასივად გადაქცევა და თითო სიტყვის ცალ-ცალკე ხაზზე დაბეჭდვა
        String[] words = sentence.split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        // წინადადების სიგრძის დაბეჭდვა
        System.out.println("Sentence length: " + sentence.length());

        // ყველა space-ის ჩანაცვლება ტირეთი
        String dashed = sentence.replace(" ", "-");
        System.out.println(dashed);

        System.out.println("-----------------------------------");

        // 11) ტელეფონის ნომრების მასივი (ვალიდური და არავალიდური)
        String[] phoneNumbers = {
                "599-14-15-16",   // ვალიდური
                "555-11-22-33",   // ვალიდური
                "595-99-88-77",   // ვალიდური
                "592-00-11-22",   // ვალიდური
                "111-14-15-16",   // არავალიდური პრეფიქსი
                "599-14-15",      // არავალიდური, ცოტა ციფრია
                "599-14-15-166",  // არავალიდური, ბევრი ციფრია
                "599-1a-15-16"    // არავალიდური, შეიცავს ასოს
        };

        // 12) ვალიდაციის გაშვება მასივის თითოეულ ელემენტზე
        for (String phoneNumber : phoneNumbers) {
            boolean isValid = phoneNumberValidation(phoneNumber);
            System.out.println(phoneNumber + " -> " + (isValid ? "VALID" : "INVALID"));
        }
    }

    // 10) ტელეფონის ნომრის ვალიდაციის ფუნქცია
    private static boolean phoneNumberValidation(String phoneNumber) {
        // 13) ყველა დეფისის მოშორება რეგექსის გამოყენებამდე
        String cleanNumber = phoneNumber.replace("-", "");

        String regex = "^(555|595|592|599)[0-9]{6}$";
        return cleanNumber.matches(regex);
    }
}