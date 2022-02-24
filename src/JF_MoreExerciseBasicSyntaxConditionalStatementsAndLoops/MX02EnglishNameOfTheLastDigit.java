package JF_MoreExerciseBasicSyntaxConditionalStatementsAndLoops;

/*
Write a method that returns the English name of the last digit of a given number. Write a program that reads an integer and prints the returned value from this method.
 */

import java.util.Scanner;

public class MX02EnglishNameOfTheLastDigit {

    public static final String ZERO = "zero";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        if (num < 10) {

            if (num == 1) {
                System.out.println("one");
            }
            if (num == 2) {
                System.out.println("two");
            }
            if (num == 3) {
                System.out.println("three");
            }
            if (num == 4) {
                System.out.println("four");
            }
            if (num == 5) {
                System.out.println("five");
            }
            if (num == 6) {
                System.out.println("six");
            }
            if (num == 7) {
                System.out.println("seven");
            }
            if (num == 8) {
                System.out.println("eight");
            }
            if (num == 9) {
                System.out.println("nine");
            }
            if (num == 0) {
                System.out.println("zero");
            }


        } else {
            int last = num % 10;
            if (last == 1) {
                System.out.println("one");
            }
            if (last == 2) {
                System.out.println("two");
            }
            if (last == 3) {
                System.out.println("three");
            }
            if (last == 4) {
                System.out.println("four");
            }
            if (last == 5) {
                System.out.println("five");
            }
            if (last == 6) {
                System.out.println("six");
            }
            if (last == 7) {
                System.out.println("seven");
            }
            if (last == 8) {
                System.out.println("eight");
            }
            if (last == 9) {
                System.out.println("nine");
            }
            if (last == 0)
                System.out.println(ZERO);
        }
    }
}

