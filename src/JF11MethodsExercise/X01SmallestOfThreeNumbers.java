package JF11MethodsExercise;

/*
Write a method to print the smallest of three integer numbers. Use an appropriate name for the method.
 */

import java.util.Scanner;

public class X01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int result = smallestOfThreeNumbers(a, b, c);
        System.out.println(result);
    }

    private static int smallestOfThreeNumbers(int a, int b, int c) {
        return Math.min(c, Math.min(a, b));
    }
}