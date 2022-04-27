package JF16ObjectsAndClassesLab;

/*
You will receive N - the number in the range [0 - 1000]. Calculate the Factorial of N and print the result
 */

import java.math.BigInteger;
import java.util.Scanner;

public class L03BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigInteger bigIn = new BigInteger(String.valueOf(1));

        for (int i = 1; i <= n; i++) {
            bigIn = bigIn.multiply(BigInteger.valueOf(i));
        }

        System.out.println(bigIn);
    }
}