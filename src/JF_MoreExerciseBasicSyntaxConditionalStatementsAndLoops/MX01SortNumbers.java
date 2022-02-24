package JF_MoreExerciseBasicSyntaxConditionalStatementsAndLoops;

/*
 Read three real numbers and sort them in descending order. Print each number on a new line.
 */

import java.util.Scanner;

public class MX01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int sec = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        if (first > sec && first > third) {
            //first biggest
            if (sec > third) {
                System.out.printf("%d%n%d%n%d%n", first, sec, third);
            } else {
                System.out.printf("%d%n%d%n%d%n", first, third, sec);
            }
        }

        //sec biggest
        if (sec > first && sec > third) {

            if (first > third) {
                System.out.printf("%d%n%d%n%d%n", sec, first, third);
            } else {
                System.out.printf("%d%n%d%n%d%n", sec, third, first);
            }
        }

        //third biggest
        if (third > first && third > sec) {
            if (first > sec) {
                System.out.printf("%d%n%d%n%d%n", third, first, sec);
            } else {
                System.out.printf("%d%n%d%n%d%n", third, sec, first);
            }
        }
    }
}