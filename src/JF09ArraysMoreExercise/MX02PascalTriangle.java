package JF09ArraysMoreExercise;

/*
The triangle may be constructed in the following manner: In row 0 (the topmost row), there is a unique nonzero entry 1. Each entry of each subsequent row is constructed by adding the number above and to the left with the number above and to the right, treating blank entries as 0. For example, the initial number in the first (or any other) row is 1 (the sum of 0 and 1), whereas the numbers 1 and 3 in the third row are added to produce the number 4 in the fourth row.
If you want more info about it: https://en.wikipedia.org/wiki/Pascal's_triangle
Print each row element separated with whitespace.
 */

import java.util.Scanner;

public class MX02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("1");
        int[] buff = new int[3];
        buff[0] = 0;
        buff[1] = 1;
        buff[2] = 0;
        int counter = 0;

        while (counter < n - 1) {
            counter++;

            int[] newBuff = new int[buff.length + 1];
            newBuff[0] = 0;

            for (int i = 1; i < buff.length; i++) {
                newBuff[i] = buff[i] + buff[i - 1];
            }

            newBuff[buff.length] = 0;
            buff = newBuff;

            for (int i : newBuff) {
                if (i != 0) {
                    System.out.printf("%d ", i);
                }
            }

            System.out.println();
        }
    }
}