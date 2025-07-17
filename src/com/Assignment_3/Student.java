package com.Assignment_3;
import java.util.*;
public class Student {

    private String name;
    private int age;
    private double marks;

    // setter method
    public void setStudentDetails(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Parameterized Constructor
    public Student(String name, int age, double marks) {
        setStudentDetails(name, age, marks); // Call combined setter

        System.out.println("\n--- Student Details ---");
        System.out.println("Name  : " + this.name);
        System.out.println("Age   : " + this.age);
        System.out.println("Marks : " + this.marks);
    }

    // Input method
    public static void getStudentInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        new Student(name, age, marks);
    }

    public static void main(String[] args) {
        getStudentInput();
    }
}
