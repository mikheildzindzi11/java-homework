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

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import ge.tbc.testautomation.annotationsAndStreams.Analyzable;
import ge.tbc.testautomation.annotationsAndStreams.VariableNameAnnotation;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Field[] fields = Analyzable.class.getDeclaredFields();

        List<Field> matchingFields = Arrays.stream(fields)
                .filter(field -> {
                    VariableNameAnnotation annotation = field.getAnnotation(VariableNameAnnotation.class);
                    String capitalizedName = capitalize(field.getName());
                    return capitalizedName.equals(annotation.name());
                })
                .toList();

        List<Field> nonMatchingFields = Arrays.stream(fields)
                .filter(field -> {
                    VariableNameAnnotation annotation = field.getAnnotation(VariableNameAnnotation.class);
                    String capitalizedName = capitalize(field.getName());
                    return !capitalizedName.equals(annotation.name());
                })
                .toList();

        System.out.println("=== ემთხვევა ანოტაციის name-ს (" + matchingFields.size() + ") ===");
        matchingFields.forEach(field -> {
            VariableNameAnnotation annotation = field.getAnnotation(VariableNameAnnotation.class);
            System.out.printf("ველი: %-20s ანოტაციის name: %s%n", field.getName(), annotation.name());
        });

        System.out.println("\n=== არ ემთხვევა ანოტაციის name-ს (" + nonMatchingFields.size() + ") ===");
        nonMatchingFields.forEach(field -> {
            VariableNameAnnotation annotation = field.getAnnotation(VariableNameAnnotation.class);
            System.out.printf("ველი: %-20s ანოტაციის name: %s%n", field.getName(), annotation.name());
        });

        // მე-7: სხვადასხვა ტიპის გამოუყენებელი ცვლადები, warning-ის გარეშე
        int unusedNumber = 10;
        String unusedText = "hello";
        boolean unusedFlag = true;
        double unusedPrice = 99.99;
    }

    private static String capitalize(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }
}