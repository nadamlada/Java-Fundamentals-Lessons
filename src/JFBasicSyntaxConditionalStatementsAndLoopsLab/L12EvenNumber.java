package JFBasicSyntaxConditionalStatementsAndLoopsLab;

/*
Take as an input an even number and print its absolute value with a message: "The number is: {absoluteValue}". If the number is odd, print "Please write an even number." and continue reading numbers.
 */

import java.util.Scanner;

public class L12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        while (true)
            if (num % 2 == 0) {
                System.out.printf("The number is: %d", Math.abs(num));
                break;
            } else {
                System.out.println("Please write an even number.");
                num = Integer.parseInt(scanner.nextLine());
            }
    }
}
