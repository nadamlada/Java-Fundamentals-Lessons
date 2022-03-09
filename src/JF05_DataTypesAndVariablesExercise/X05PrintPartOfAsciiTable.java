package JF05_DataTypesAndVariablesExercise;

/*
Find online more information about ASCII (American Standard Code for Information Interchange) and write a program
that prints part of the ASCII table of characters at the console.
On the first line of input, you will receive the char index you should start with, and on the
second line - the index of the last character you should print.
 */

import java.util.Scanner;

public class X05PrintPartOfAsciiTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        for (int i = a; i <= b; i++) {

            //от Int в char

            char symbol = (char) i;
            System.out.printf("%c ", symbol);
        }

    }
}