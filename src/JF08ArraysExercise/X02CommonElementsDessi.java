package JF08ArraysExercise;

 /*
 Write a program, which prints common elements in two arrays. You have to compare the elements of the second array to the
 elements of the first.
  */

import java.util.Scanner;

public class X02CommonElementsDessi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        String[] input1Array = input1.split("\\s");
        String[] input2Array = input2.split("\\s");

        for (String inp2 : input2Array) {
            for (String inp1 : input1Array) {

                if (inp2.equals(inp1)) {
                    System.out.print(inp2 + " ");
                }
            }
        }
    }
}