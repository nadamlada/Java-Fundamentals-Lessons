package JF08ArraysExercise;

 /*
 Write a program that receives an array and the number of rotations you have to perform (the first element goes at the end)
 Print the resulting array.
  */

import java.util.Scanner;

public class X04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] numbers = input.split("\\s");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < rotations; j++) {
            String firstNumber = numbers[0];

            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            numbers[numbers.length - 1] = firstNumber;
        }

        System.out.println(String.join(" ", numbers));
    }
}