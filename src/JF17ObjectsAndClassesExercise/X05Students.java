package JF17ObjectsAndClassesExercise;

/*
Write a program that receives n count of students and orders them by grade (in descending). Each student should have a
first name (string), last name (string), and grade (a floating-point number).
Input
•	First-line will be a number n.
•	Next n lines you will get a student info in the format "{first name} {second name} {grade}".
Output
•	Print each student in the following format "{first name} {second name}: {grade}".
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class X05Students {

    public static class Student {
        private String firstName;
        private String secondName;
        private double grade;


        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        public double getGrade() {
            return this.grade;
        }

        @Override
        //"{first name} {second name}: {grade}".
        public String toString() {
            return String.format("%s %s: %.2f", this.firstName, this.secondName, this.grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            String firstName = commands[0];
            String secondName = commands[1];
            double grade = Double.parseDouble(commands[2]);
            Student student = new Student(firstName, secondName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparing(Student::getGrade).reversed());
        for (Student student : students) {
            System.out.println(student);
        }
    }
}