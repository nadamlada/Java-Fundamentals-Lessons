package JF08ArraysExercise;

/*
You will be given a count of wagons in a train n. On the next n lines, you will receive how many people are going to get on that wagon.
At the end print the whole train and after that the sum of the people on the train.
 */

import java.util.Scanner;

public class X01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int[] wagons = new int[n];
        for (int i = 0; i < n; i++) {
            wagons[i] = Integer.parseInt(scanner.nextLine());

            System.out.printf("%d ", wagons[i]);
            sum += wagons[i];
        }
        System.out.println();
        System.out.println(sum);

    }
}