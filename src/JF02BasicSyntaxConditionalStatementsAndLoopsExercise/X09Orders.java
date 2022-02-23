package JF02BasicSyntaxConditionalStatementsAndLoopsExercise;

/*
We are placing N orders at a time. You need to calculate the price on the following formula:
((daysInMonth * capsulesCount) * pricePerCapsule)
Input / Constraints
•	On the first line you will receive integer N – the count of orders the shop will receive.
•	For each order you will receive the following information:
o	Price per capsule - floating-point number in range [0.00…1000.00]
o	Days – integer in range [1…31]
o	Capsules count - integer in range [0…2000]
The input will be in the described format, there is no need to check it explicitly.
Output
The output should consist of N + 1 lines. For each order you must print a single line in the following format:
•	"The price for the coffee is: ${price}"
On the last line you need to print the total price in the following format:
•	 "Total: ${totalPrice}"
The price must be formatted to 2 decimal places.

 */

import java.util.Scanner;

public class X09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOrders = Integer.parseInt(scanner.nextLine());
        double total = 0;

        for (int i = 1; i <= countOrders; i++) {
            double singlePrice = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int qty = Integer.parseInt(scanner.nextLine());
            double totalPerOrder = singlePrice * days * qty;
            System.out.printf("The price for the coffee is: $%.2f%n", totalPerOrder);
            total = totalPerOrder + total;
        }

        System.out.printf("Total: $%.2f", total);

    }
}