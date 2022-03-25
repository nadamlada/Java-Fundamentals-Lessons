package JF08ArraysExercise;

/*
Write a program, which prints common elements in two arrays. You have to compare the elements of the second array to the
elements of the first.
 */

import java.util.Scanner;

public class X02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1String = scanner.nextLine();
        String input2String = scanner.nextLine();

        String[] inputs2 = input2String.split("\\s");

        for (int j = 0; j < inputs2.length; j++) {

            String[] inputs1 = input1String.split("\\s");
            for (int i = 0; i < inputs1.length; i++) {

                if (inputs2[j].equals(inputs1[i])) {                                          ///без кавичките
                    System.out.print(inputs1[i] + " ");

                } else {
                    continue;
                }
            }
        }
    }
}