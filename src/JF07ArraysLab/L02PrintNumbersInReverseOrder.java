package JF07ArraysLab;

/*
Read n numbers and print them in reverse order.
 */

import java.util.Scanner;

public class L02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] newnew = new int[n];
        for (int i = 0; i < n; i++) {
            newnew[i] = numbers[n - i - 1];
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", newnew[i]);
        }
    }
}