package JF08ArraysExercise;

/*
Write a program that creates 2 arrays. You will be given an integer n. On the next n lines, you get 2 integers.
Form 2 arrays as shown below.
 */

/*
https://youtu.be/kZpfsxBYMX0?t=7872
https://youtu.be/h9Uhu40jvpg?t=7324
 */

import java.util.Scanner;

public class X03ZigZagArraysAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] forPrint1 = new String[n];
        String[] forPrint2 = new String[n];

        for (int i = 0; i < n; i++) {

            String[] line = scanner.nextLine().split("\\s");

            if ((i + 1) % 2 != 0) {
                forPrint1[i] = line[0];
                forPrint2[i] = line[1];
            } else {
                forPrint2[i] = line[0];
                forPrint1[i] = line[1];
            }
        }

        System.out.println(String.join(" ", forPrint1));
        System.out.println(String.join(" ", forPrint2));
    }
}