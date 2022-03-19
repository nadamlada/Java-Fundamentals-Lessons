package JF13ListsExercise;

/*
Write a program to append several arrays of numbers.
	Arrays are separated by "|".
	Values are separated by spaces (" ", one or several).
	Order the arrays from the last to the first, and their values from left to right.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class X07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String thisIs = scanner.nextLine();
        List<String> input = new ArrayList<>();
        String[] sth = thisIs.split("\\|");

        for (String s : sth) {
            input.add(s);
        }

        Collections.reverse(input);

        System.out.println(input.toString()
                .replace("[", "")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+", " "));
    }
}