package JFBasicSyntaxConditionalStatementsAndLoopsExercise;

/*Write a program to check if a given number is a strong number or not. A number is strong if the sum of the Factorial
of each digit is equal to the number. For example 145 is a strong number, because 1! + 4! + 5! = 145.
Print "yes" if the number is strong and "no" if the number is not strong.
 */

import java.util.Scanner;

public class X06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int firstNum = num;

        int sumFactoriel = 0;

        while (true) {
            int lastDigit = num % 10;

            int factoriel = 1;
            for (int i = lastDigit; i >= 1; i--) {          //5! = 5*4*3*2*1 = 120
                factoriel = i * factoriel;

            }

            sumFactoriel = sumFactoriel + factoriel;

            num = num / 10;                                 // num /=10

            if (num < 10) {
                sumFactoriel = sumFactoriel + num;
                break;
            }

        }
        if (sumFactoriel == firstNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
