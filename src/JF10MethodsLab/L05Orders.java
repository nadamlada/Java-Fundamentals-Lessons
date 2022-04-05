package JF10MethodsLab;

/*
Write a method that calculates the total price of an order and prints it on the console. The method should receive one of the following products:
coffee, water, coke, snacks; and a quantity of the product. The prices for a single piece of each product are:
•	coffee – 1.50
•	water – 1.00
•	coke – 1.40
•	snacks – 2.00
Print the result rounded to the second decimal place.
*/

import java.util.Scanner;

public class L05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int qty = Integer.parseInt(scanner.nextLine());
        double price = 0;

        if (input.equals("coffee")) {
            price = 1.50;
        }

        if (input.equals("water")) {
            price = 1.0;
        }

        if (input.equals("coke")) {
            price = 1.40;
        }

        if (input.equals("snacks")) {
            price = 2.0;
        }

        totalPrice(price, qty);
    }

    public static void totalPrice(double price, int qty) {

        double totalPrice = price * qty;
        System.out.printf("%.2f", totalPrice);
    }
}