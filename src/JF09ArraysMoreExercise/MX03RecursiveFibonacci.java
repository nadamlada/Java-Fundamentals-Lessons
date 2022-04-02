package JF09ArraysMoreExercise;
/*
The Fibonacci sequence is quite a famous sequence of numbers. Each member of the sequence is calculated from the sum of the two previous elements. The first two elements are 1, 1. Therefore the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34…
The following sequence can be generated with an array, but that’s easy, so your task is to implement recursively.
So if the function GetFibonacci(n) returns the n’th Fibonacci number we can express it using GetFibonacci(n) = GetFibonacci(n-1) + GetFibonacci(n-2).
However, this will never end and in a few seconds, a StackOverflow Exception is thrown. For the recursion to stop it has to have a "bottom". The bottom of the recursion is GetFibonacci(2) should return 1 and GetFibonacci(1) should return 1.
Input
•	On the only line in the input, the user should enter the wanted Fibonacci number.
Output
•	The output should be the n’th Fibonacci number counting from 1.
Constraints
•	1 ≤ N ≤ 50
Examples
Input	Output
5	5
10	55
21	10946
For the Nth Fibonacci number, we calculate the N-1th and the N-2th number, but for the calculation of the N-1th number we calculate the N-1-1th(N-2th) and the N-1-2th number, so we have a lot of repeated calculations.

If you want to figure out how to skip those unnecessary calculations, you can search for a technique called memoization.

подават вход нула, резултат нула

 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MX03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, Double> buffer = new HashMap<>();
        double print = solveMemorization(n, buffer);
        System.out.printf("%.0f", print);
    }

    private static double solveMemorization(int n, Map<Integer, Double> buffer) {
        double result = 1;

        buffer.put(1, 1.0);
        buffer.put(2, 1.0);
        buffer.put(0, 0.0);

        //При рекурсия, много е важно да определиш точката в която матодът ще спре да извиква себе си,
        // т.е. дъно на рекурсията. Можеш да си представиш рекурсията като цикъл.

        if (n == 1) {
            return result;
        }

        if (buffer.containsKey(n)) {
            result = buffer.get(n);
        } else {
            result = solveMemorization((n - 1), buffer) + solveMemorization((n - 2), buffer);
            buffer.put(n, result);
        }

        buffer.put(n, result);
        return result;
    }
}