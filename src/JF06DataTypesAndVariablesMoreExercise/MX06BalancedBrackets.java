package JF06DataTypesAndVariablesMoreExercise;

/*
You will receive n lines. On those lines, you will receive one of the following:
•	Opening bracket – "(",
•	Closing bracket – ")" or
•	Random string
Your task is to find out if the brackets are balanced. That means after every closing bracket should follow an opening one. Nested parentheses are not valid, and if two consecutive opening brackets exist, the expression should be marked as unbalanced.
Input
•	On the first line, you will receive n – the number of lines, which will follow.
•	On the next n lines, you will receive "(", ")" or another string.
Output
You have to print "BALANCED" if the parentheses are balanced and "UNBALANCED" otherwise.
Constraints
•	n will be in the interval [1…20]
•	The length of the stings will be between [1…100] characters
 */

import java.util.Scanner;

public class MX06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countAllBrackets = 0;
        int counterPaired = 0;
        boolean isOpened = false;
        boolean unbalanced = false;
        boolean arePaired = false;
        int arePairedCounter = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            char symbol = input.charAt(0);

            if (symbol == '(' || symbol == ')') {
                countAllBrackets++;
            } else {
                continue;
            }

            if ((!isOpened) && (symbol == ')')) {           // ако почва )
                unbalanced = true;
                continue;
            } else if (symbol == '(') {
                if (isOpened) {
                    unbalanced = true;
                    break;
                } else {
                    isOpened = true;
                }
            }

            if ((isOpened) && (symbol == ')')) {
                arePaired = true;
                isOpened = false;
                arePairedCounter++;
            }
        }

        if (arePairedCounter * 2 == countAllBrackets) {
            System.out.println("BALANCED");
        } else if (unbalanced) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}