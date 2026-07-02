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