package JF_DataTypesAndVariablesExercise;

/*
Read four integer numbers. Add first to the second, divide (integer) the sum by the third number,
and multiply the result by the fourth number. Print the result.
 */

import java.util.Scanner;

public class X01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());

        System.out.println(((a + b) / c) * d);

    }
}