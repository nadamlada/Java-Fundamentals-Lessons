package JFBasicSyntaxConditionalStatementsAndLoopsLab;

/*
Write a program, which prints all the numbers from 1 to 100, which are divisible by 3. You have to use a single for loop. The program should not receive input.
 */

import java.util.Scanner;

public class L08DivisibleBy_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 3; i <= 100; i += 3) {
            System.out.println(i);
        }
    }
}
