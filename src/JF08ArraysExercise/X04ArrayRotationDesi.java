package JF08ArraysExercise;

/*
Write a program that receives an array and the number of rotations you have to perform (the first element goes at the end)
Print the resulting array.
 */

import java.util.Scanner;

public class X04ArrayRotationDesi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rotations = Integer.parseInt(scanner.nextLine());

        String[] inputs = input.split("\\s");
        for (int i = 0; i < rotations; i++) {
            String firstElement = inputs[0];
            for (int j = 0; j < inputs.length - 1; j++) {
                inputs[j] = inputs[j + 1];
            }

            inputs[inputs.length - 1] = firstElement;
        }

        for (String inputsElement : inputs) {
            System.out.print(inputsElement + " ");
        }
    }
}