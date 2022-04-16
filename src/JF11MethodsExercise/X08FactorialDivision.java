package JF11MethodsExercise;

/*
Read two integer numbers. Calculate the factorial of each number. Divide the first result by the second and print
the division formatted to the second decimal point.
 */

import java.util.Scanner;

public class X08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        long factorialA = factorialA(a);
        long factorialB = factorialA(b);
        divideAtoB(factorialA, factorialB);
    }

    // при факториели се работи с лонг
    private static void divideAtoB(long a, long b) {
        double result = (a * 1.0) / b;
        System.out.printf("%.2f", result);
    }

    private static long factorialA(int a) {
        long factorial = a;

        for (int i = 1; i < a; i++) {
            factorial *= (a - i);
            // factorial *= i;
        }


        return factorial;
    }
}