package JF01BasicSyntaxConditionalStatementsAndLoopsLab;
/*
Rewrite your program, so it can receive the multiplier from the console. Print the table from the given multiplier to 10. If the given multiplier is more than 10 - print only one row with the integer, the given multiplier, and the product. See the examples below for more information.
Output
Print every row of the table in the following format:
{theInteger} X {times} = {product}
Constraints
•	The integer will be in the interval [1…100]
 */

import java.util.Scanner;

public class L11MultiplicationTable_2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        if (second > 10) {
            System.out.printf("%d X %d = %d", first, second, first * second);
        }

        for (int i = second; i <= 10; i++) {

            System.out.printf("%d X %d = %d%n", first, i, first * i);

        }
    }
}
