package ge.tbc.testautomation.annotationsAndStreams;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Analyzable {

    @VariableNameAnnotation(name = "Age")
    private int age;

    @VariableNameAnnotation(name = "FirstName")
    private String firstName;

    @VariableNameAnnotation(name = "Salary")
    private double salary;

    @VariableNameAnnotation(name = "IsActive")
    private boolean isActive;

    @VariableNameAnnotation(name = "Id")
    private long id;

    @VariableNameAnnotation(name = "Grade")
    private char grade;

    @VariableNameAnnotation(name = "Height")
    private float height;

    @VariableNameAnnotation(name = "Level")
    private byte level;

    @VariableNameAnnotation(name = "YearsOfExperience")
    private short yearsOfExperience;

    @VariableNameAnnotation(name = "Hobbies")
    private List<String> hobbies;

    @VariableNameAnnotation // name არ გადმეცემა -> გამოიყენება default "Default Value"
    private Map<String, Integer> scores;

    @VariableNameAnnotation(name = "WrongName") // შეგნებულად ველის რეალურ სახელს არ ემთხვევა
    private LocalDate birthDate;

    @VariableNameAnnotation(name = "LuckyNumbers")
    private int[] luckyNumbers;

    @VariableNameAnnotation(name = "Email")
    private String email;
}