package JF08ArraysExercise;

/*
Write a program that finds the longest sequence of equal elements in an array of integers. If several longest sequences exist, print the leftmost one.
 */

import java.util.Scanner;

public class X07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] elements = input.split("\\s");

        String current = " ";
        int currentCounter = 1;
        int maxCounter = 1;
        String maxElement = " ";

        for (int i = 0; i < elements.length - 1; i++) {

            current = elements[i];

            if (elements[i].equals(elements[i + 1])) {
                currentCounter++;

            } else {
                currentCounter = 1;
                continue;
            }

            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
                maxElement = current;
            }
        }

        for (int i = 1; i <= maxCounter; i++) {
            System.out.print(maxElement + " ");
        }
    }
}