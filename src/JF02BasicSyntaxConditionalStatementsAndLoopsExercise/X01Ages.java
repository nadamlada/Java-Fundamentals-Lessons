package JF02BasicSyntaxConditionalStatementsAndLoopsExercise;

/*
1.	Ages
Write a program that determines whether based on the given age a person is: baby, child, teenager, adult, elder. The bounders are:
•	0-2 – baby;
•	3-13 – child;
•	14-19 – teenager;
•	20-65 – adult;
•	>=66 – elder;
•	All the values are inclusive.
 */

import java.util.Scanner;

public class X01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        String type = "";

        if (0 <= age && age <= 2) {
            type = "baby";
        }
        if (3 <= age && age <= 13) {
            type = "child";
        }
        if (14 <= age && age <= 19) {
            type = "teenager";
        }
        if (20 <= age && age <= 65) {
            type = "adult";
        }

        if (age >= 66) {
            type = "elder";
        }

        System.out.println(type);
    }
}
