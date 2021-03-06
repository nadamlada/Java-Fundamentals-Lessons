package JF02BasicSyntaxConditionalStatementsAndLoopsExercise;

/*
You will be given an integer and you have to print on the console whether that number is divisible by the following numbers: 2, 3, 6, 7, 10. You should always take the bigger division. If the number is divisible by both 2 and 3 it is also divisible by 6 and you should print only the division by 6. If a number is divisible by 2 it is sometimes also divisible by 10 and you should print the division by 10. If the number is not divisible by any of the given numbers print "Not divisible". Otherwise, print "The number is divisible by {number}".
 */

import java.util.Scanner;

public class X02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int dev = 0;
        if (num % 10 == 0) {
            dev = 10;
        } else if (num % 7 == 0) {
            dev = 7;

        } else if (num % 6 == 0) {
            dev = 6;

        } else if (num % 3 == 0) {
            dev = 3;

        } else if (num % 2 == 0) {
            dev = 2;
        }

        if (dev == 0) {
            System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", dev);
        }
    }
}

