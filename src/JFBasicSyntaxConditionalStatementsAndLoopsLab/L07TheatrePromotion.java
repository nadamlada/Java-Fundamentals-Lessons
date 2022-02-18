package JFBasicSyntaxConditionalStatementsAndLoopsLab;

/*
A theatre is doing a ticket sale, but they need a program to calculate the price of a single ticket. If the given age does not fit one of the categories, you should print "Error!".
You can see the prices in the table below:
Day / Age	0 <= age <= 18	    18 < age <= 64	    64 < age <= 122
Weekday	    12$             	18$	                12$
Weekend	    15$             	20$	                15$
Holiday	    5$	                12$	                10$

Input
The input comes in two lines. On the first line, you will receive the type of day. On the second – the age of the person.

Output
Print the price of the ticket according to the table, or "Error!" if the age is not in the table.
Constraints
•	The age will be in the interval [-1000…1000].
•	The type of day will always be valid.
 */

import java.util.Scanner;

public class L07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if (0 <= age && age <= 18) {

            switch (day) {
                case "weekday":
                    price = 12;
                    break;
                case "weekend":
                    price = 15;
                    break;
                case "holiday":
                    price = 5;
                    break;
            }

        } else if (18 < age && age <= 64) {
            switch (day) {
                case "weekday":
                    price = 18;
                    break;
                case "weekend":
                    price = 20;
                    break;
                case "holiday":
                    price = 12;
                    break;
            }

        } else if (64 < age && age <= 122) {
            switch (day) {
                case "weekday":
                    price = 12;
                    break;
                case "weekend":
                    price = 15;
                    break;
                case "holiday":
                    price = 10;
                    break;
            }
        }

        if (price > 0) {
            System.out.printf("%d$", price);
        } else {
            System.out.println("Error!");
        }
    }
}