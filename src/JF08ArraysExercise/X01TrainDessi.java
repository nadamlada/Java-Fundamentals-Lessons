package JF08ArraysExercise;
/*
You will be given a count of wagons in a train n. On the next n lines, you will receive how many people are going to get on that wagon.
At the end print the whole train and after that the sum of the people on the train.
 */

import java.util.Arrays;
import java.util.Scanner;

public class X01TrainDessi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());

        int[] peopleArray = new int[wagons];

        for (int i = 0; i < wagons; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            peopleArray[i] = people;
            System.out.print(people + " ");

        }
        System.out.println();
        //сумира числата от масива
        System.out.println(Arrays.stream(peopleArray).sum());

    }
}