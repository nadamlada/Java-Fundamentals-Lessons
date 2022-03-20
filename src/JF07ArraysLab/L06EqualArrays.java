package JF07ArraysLab;

/*
Read two arrays and print on the console whether they are identical or not. Arrays are identical if their elements are equal.
If the arrays are identical find the sum of the first one and print on the console the following message:
"Arrays are identical. Sum: {sum}", otherwise find the first index where the arrays differ and print on the console following message:
"Arrays are not identical. Found difference at {index} index."
 */

import java.util.Scanner;

public class L06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputOne = scanner.nextLine();
        String[] dividedOne = inputOne.split("\\s");
        int[] intsOne = new int[dividedOne.length];

        String inputTwo = scanner.nextLine();
        String[] dividedTwo = inputTwo.split("\\s");
        int[] intsTwo = new int[dividedTwo.length];

        boolean areIdentical = true;

        if (dividedOne.length != dividedTwo.length) {
            areIdentical = false;
        }

        int sum = 0;
        int diff = 0;
        for (int i = 0; i < dividedOne.length; i++) {
            intsOne[i] = Integer.parseInt(dividedOne[i]);
            intsTwo[i] = Integer.parseInt(dividedTwo[i]);

            if (intsOne[i] == intsTwo[i]) {

                areIdentical = true;
                sum += intsOne[i];
            } else {
                areIdentical = false;
                diff = i;
                break;
            }
        }

        if (areIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", diff);
        }
    }
}