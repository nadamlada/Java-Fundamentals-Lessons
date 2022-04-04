package JF10MethodsLab;

/*
Create a method for printing triangles as shown below:
 */

import java.util.Scanner;

public class L03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printNumberTriangle(n);
    }

    private static void printNumberTriangle(int n) {

        for (int length = 1; length <= n; length++) {
            print(length);
        }

        for (int length = n - 1; length >= 1; length--) {
            print(length);
        }
    }

    public static void print(int length) {

        for (int i = 1; i <= length; i++) {

            System.out.print(i);
            if (i != length) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}