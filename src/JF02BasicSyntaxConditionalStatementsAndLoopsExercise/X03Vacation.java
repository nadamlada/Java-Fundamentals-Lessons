package JF02BasicSyntaxConditionalStatementsAndLoopsExercise;

/*
You are given a group of people, type of the group, on which day of the week they are going to stay. Based on that information calculate how much they have to pay and print that price on the console. Use the table below. In each cell is the price for a single person. The output should look like that: "Total price: {price}". The price should be formatted to the second decimal point.
    Friday	Saturday	Sunday
Students	8.45	9.80	10.46
Business	10.90	15.60	16
Regular	15	20	22.50
There are also discounts based on some conditions:
•	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
•	Business – if the group is bigger than or equal to 100 people 10 of them can stay for free.
•	Regular – if the group is bigger than or equal to 10 and less than or equal to 20 reduce the total price by 5%
You should reduce the prices in that EXACT order.
 */

import java.util.Scanner;

public class X03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int qty = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0.0;
        double totalPrice = 0.0;

        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                totalPrice = qty * price;
                if (qty >= 30) {
                    totalPrice = totalPrice - 0.15 * totalPrice;
                }
                break;

            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16.00;
                        break;
                }

                if (qty >= 100) {
                    qty = qty - 10;
                }
                totalPrice = qty * price;
                break;

            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15.0;
                        break;
                    case "Saturday":
                        price = 20.;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }

                totalPrice = qty * price;

                if (qty >= 10 && qty <= 20) {
                    totalPrice = totalPrice - 0.05 * totalPrice;
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);

    }
}
