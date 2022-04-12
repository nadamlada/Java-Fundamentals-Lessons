package JF11MethodsExercise;

/*
Write a method that receives a single string and prints the count of the vowels. Use an appropriate name for the method.
 */

import java.util.Scanner;

public class X02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = (scanner.nextLine()).toLowerCase();
        String[] inputString = input.split("");

        printTheCounOfVowels(inputString);
    }

    private static void printTheCounOfVowels(String[] inputString) {
        int count = 0;

        for (int i = 0; i < inputString.length; i++) {
            if (inputString[i].equals("a")) {
                count++;
            }

            if (inputString[i].equals("o")) {
                count++;
            }

            if (inputString[i].equals("e")) {
                count++;
            }

            if (inputString[i].equals("i")) {
                count++;
            }

            if (inputString[i].equals("y")) {
                count++;
            }

            if (inputString[i].equals("u")) {
                count++;
            }
        }

        System.out.println(count);
        return;
    }
}