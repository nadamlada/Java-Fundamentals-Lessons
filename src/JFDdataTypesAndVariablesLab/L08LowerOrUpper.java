package JFDdataTypesAndVariablesLab;

/*
Write a program that prints whether a given character is upper-case or lower-case.
 */

import java.util.Scanner;

public class L08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char asked = input.charAt(0);

        if ('a' <= asked && asked <= 'z') {

            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }
    }
}