package JF24TextProcessingMoreExercise;
/*
Write a program that reads n lines of strings and extracts the name and age of a given person.
The name of the person will be between "@" and "|". The person’s age will be between "#" and "*".
Example: "Hello my name is @Peter| and I am #20* years old."
For each found name and age print a line in the following format "{name} is {age} years old."
 */

import java.util.Scanner;

public class MX1ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder(scanner.nextLine());
            String name = sb.substring((sb.indexOf("@") + 1), sb.indexOf("|"));
            String years = sb.substring((sb.indexOf("#") + 1), sb.indexOf("*"));

            System.out.printf("%s is %s years old.%n", name, years);
        }
    }
}