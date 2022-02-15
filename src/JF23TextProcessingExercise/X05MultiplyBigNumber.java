package JF23TextProcessingExercise;

/*
You are given two lines – the first one can be a really big number (0 to 1050). The second one will be a single-digit number (0 to 9).
You must display the product of these numbers.
Note: do not use the BigInteger class.

 */

import java.math.BigInteger;
import java.util.Scanner;

public class X05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = new BigInteger(scanner.nextLine());
        BigInteger b = new BigInteger(scanner.nextLine());

        BigInteger c = a.multiply(b);
        System.out.println(c);
    }
}
