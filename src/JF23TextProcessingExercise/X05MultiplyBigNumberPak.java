package JF23TextProcessingExercise;
/*
You are given two lines – the first one can be a really big number (0 to 1050). The second one will be a single-digit number (0 to 9).
You must display the product of these numbers.
Note: do not use the BigInteger class.

 */

import java.util.Scanner;

public class X05MultiplyBigNumberPak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        StringBuilder a = new StringBuilder(text);

        String reversed = a.reverse().toString();
        StringBuilder total = new StringBuilder();

        int reminder = 0;
        for (int i = 0; i < reversed.length(); i++) {
            int result = Integer.parseInt(reversed.charAt(i) + "") * multiplier + reminder;
            if (i == reversed.length() - 1) {
                total.insert(0, result);
            } else {
                int useThis = result % 10;
                total.insert(0, useThis);
                reminder = result / 10;
            }
        }

        //remove leading zeroes
        while (total.charAt(0) == '0' && total.length() > 1) {
            total.deleteCharAt(0);
        }

        System.out.println(total);
    }
}