package JF05_DataTypesAndVariablesExercise;

/*
Write a program to read an integer n and print all triples of the first n small Latin letters, ordered alphabetically:
 */

import java.util.Scanner;

public class X06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (char i = 'a'; i < 'a' + n; i++) {
            for (char j = 'a'; j < 'a' + n; j++) {
                for (char k = 'a'; k < 'a' + n; k++) {

                    System.out.printf("%c%c%c%n", i, j, k);

                }
            }
        }
    }
}