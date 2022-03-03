package JF04DdataTypesAndVariablesLab;

/*
A number is special when its sum of digits is 5, 7, or 11.
Write a program to read an integer n and for all numbers in the range 1…n to print the number and if it is special or not (True / False).

https://youtu.be/xpNOuMerhrE?t=12041
 */

import java.util.Scanner;

public class L10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(input);

        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;
            int digits = 0;

            while (number > 0) {

                int digit = number % 10;                        //взима последната цифра
                sum += digit;
                number = number / 10;                           // премахваме последния диджит

            }

            boolean isSpecial = (sum == 5 || sum == 7 || sum == 11);

            if (isSpecial) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}