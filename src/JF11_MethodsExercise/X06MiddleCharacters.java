package JF11_MethodsExercise;

 /*
 You will receive a single string. Write a method that prints the middle character.
 If the length of the string is even, there are two middle characters.
  */

import java.util.Scanner;

public class X06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        middleCharacters(input);
    }

    private static void middleCharacters(String input) {

        if (input.length() % 2 == 0) {
            //четна дължина, печатам два средни

            char middle = input.charAt((input.length() / 2) - 1);
            char middle2 = input.charAt(input.length() / 2);
            System.out.print(middle);
            System.out.print(middle2);
            //  System.out.println(middle + "" + middle2);

        } else {
            // нечетна дължина, печатам един среден
            char middle = input.charAt((input.length() / 2));
            System.out.println(middle);
        }
    }
}