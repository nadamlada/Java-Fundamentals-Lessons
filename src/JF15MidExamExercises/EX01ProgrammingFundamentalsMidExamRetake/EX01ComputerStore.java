package JF15MidExamExercises.EX01ProgrammingFundamentalsMidExamRetake;

/*
Write a program that prints you a receipt for your new computer. You will receive the parts' prices (without tax) until you receive what type of customer this is - special or regular. Once you receive the type of customer you should print the receipt.
The taxes are 20% of each part's price you receive.
If the customer is special, he has a 10% discount on the total price with taxes.
If a given price is not a positive number, you should print "Invalid price!" on the console and continue with the next price.
If the total price is equal to zero, you should print "Invalid order!" on the console.
Input
•	You will receive numbers representing prices (without tax) until command "special" or "regular":
Output
•	The receipt should be in the following format:
"Congratulations you've just bought a new computer!
Price without taxes: {total price without taxes}$
Taxes: {total amount of taxes}$
-----------
Total price: {total price with taxes}$"
Note: All prices should be displayed to the second digit after the decimal point! The discount is applied only on the total price. Discount is only applicable to the final price!
 */

import java.util.Scanner;

public class EX01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double calculatePrices = 0;
        double taxes = 0;
        double totalPrice = 0;

        while (true) {
            if ("special".equals(input)) {

                if (totalPrice == 0) {
                    System.out.println("Invalid order!");
                    break;
                }

                totalPrice = totalPrice * 0.9;
                print(calculatePrices, taxes, totalPrice);
                break;
            }

            if ("regular".equals(input)) {

                if (totalPrice == 0) {
                    System.out.println("Invalid order!");
                    break;
                }

                print(calculatePrices, taxes, totalPrice);
                break;
            }

            double price = Double.parseDouble(input);

            if (price < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }

            calculatePrices += price;
            taxes = calculatePrices * 0.2;
            totalPrice = taxes + calculatePrices;
            input = scanner.nextLine();
        }
    }

    private static void print(double calculatePrices, double taxes, double totalPrice) {

        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", calculatePrices);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$", totalPrice);
    }
}