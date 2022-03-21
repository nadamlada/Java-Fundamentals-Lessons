package JF07ArraysLab;

 /*
 Write a program to read an array of integers and condense them by summing adjacent couples of elements until a
 single integer is obtained. For example, if we have 3 elements {2, 10, 3}, we sum the first two and the second two elements
 and obtain {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.
  */

 /*
 https://www.youtube.com/watch?app=desktop&v=UeLh-8u0pXg
  */

import java.util.Arrays;
import java.util.Scanner;

public class L07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int searched = 0;

        int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (numbers.length == 1) {
            searched = numbers[0];
            System.out.printf("%d", searched);
            return;
        }

        int[] buff = new int[numbers.length - 1];

        for (int i = 0; i < numbers.length; i++) {

            if (i != numbers.length - 1) {
                int currentCalculation = numbers[i] + numbers[i + 1];
                buff[i] = currentCalculation;
            } else {
                if (buff.length == 1) {
                    searched = buff[0];
                    break;
                }
                numbers = buff;
                buff = new int[numbers.length - 1];
                i = -1;
            }
        }
        System.out.printf("%d", searched);
    }
}