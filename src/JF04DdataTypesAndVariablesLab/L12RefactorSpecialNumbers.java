package JF04DdataTypesAndVariablesLab;
/*
You are given a working code that is a solution to Problem 9. Special Numbers. However, the variables are improperly named, declared before they are needed and some of them are used for multiple things. Without using your previous solution, modify the code so that it is easy to read and understand.
Hints
•	Reduce the span of the variables by declaring them at the moment they receive a value, not before
•	Rename your variables to represent their real purpose (example: "toe" should become isSpecialNum, etc.)
•	Search for variables that have multiple purposes. If you find any, introduce a new variable

 */

import java.util.Scanner;

public class L12RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {

            int sum = 0;
            int number = i;

            while (number > 0) {
                int currentNumber = number % 10;
                sum = sum + currentNumber;

                number = number / 10;
            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}