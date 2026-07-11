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
import java.util.Arrays;
import java.util.List;

import ge.tbc.testautomation.annotationsAndStreams.Analyzable;
import ge.tbc.testautomation.annotationsAndStreams.VariableNameAnnotation;

import java.lang.reflect.Field;
import ge.tbc.testautomation.generics.AnyPair;
import ge.tbc.testautomation.generics.FigurePair;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Integer someInteger = 100;
        String someString = "Hello";

        AnyPair<Field[], Field[]> fieldsPair = getDeclaredFields(someInteger, someString);

        List<Field> integerFields = Arrays.asList(fieldsPair.getElementOne());
        List<Field> stringFields = Arrays.asList(fieldsPair.getElementTwo());

        System.out.println("Integer fields: " + integerFields);
        System.out.println("String fields: " + stringFields);

        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);

        FigurePair<Circle, Rectangle> figurePair = new FigurePair<>(circle, rectangle);

        System.out.println(figurePair);
    }

    private static <K, D> AnyPair<Field[], Field[]> getDeclaredFields(K objOne, D objTwo) {
        Field[] fieldsOne = objOne.getClass().getDeclaredFields();
        Field[] fieldsTwo = objTwo.getClass().getDeclaredFields();
        return new AnyPair<>(fieldsOne, fieldsTwo);
    }
}