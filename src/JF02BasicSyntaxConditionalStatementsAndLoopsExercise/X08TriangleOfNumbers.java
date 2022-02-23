package JF02BasicSyntaxConditionalStatementsAndLoopsExercise;
/*
Write a program, which receives a number – n, and prints a triangle from 1 to n as in the examples.
*/

import java.util.Scanner;

public class X08TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            {
                for (int j = 1; j <= i; j++) {
                    System.out.printf("%d ", i);
                }

                System.out.println();
            }
        }

        System.out.println();
    }
}
