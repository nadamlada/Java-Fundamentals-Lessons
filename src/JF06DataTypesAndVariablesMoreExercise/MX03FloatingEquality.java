package JF06DataTypesAndVariablesMoreExercise;

/*
Write a program that safely compares floating-point numbers (double) with precision eps = 0.000001.
Note that we cannot directly compare two floating-point numbers a and b by a==b because of the nature
of the floating-point arithmetic. Therefore, we assume two numbers are equal if they are more close to
each other than some fixed constant eps.
You will receive two lines, each containing a floating-point number. Your task is to compare the values
of the two numbers.
 */

import java.util.Scanner;

public class MX03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001d;                                     //слагаш d за да е децимал

        double n11 = Math.abs(n1);
        double n22 = Math.abs(n2);

        if (Math.abs(n11 - n22) >= eps) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}