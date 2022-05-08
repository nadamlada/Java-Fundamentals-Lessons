package JF20MapsLambdaAndStreamApiExercise;

/*
Write a program, which keeps the information about products and their prices. Each product has a name, a price, and its quantity. If the product doesn't exist yet, add it with its starting quantity.
If you receive a product, which already exists, increases its quantity by the input quantity and if its price is different, replace the price as well.
You will receive products' names, prices, and quantities on new lines. Until you receive the command "buy", keep adding items. When you do receive the command "buy", print the items with their names and the total price of all the products with that name.
Input
•	Until you receive "buy", the products come in the format: "{name} {price} {quantity}".
•	The product data is always delimited by a single space.
Output
•	Print information about each product, following the format:
"{productName} -> {totalPrice}"
•	Format the average total price to the 2nd decimal place.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class X04Orders {

    static class Product {
        String name;
        double price;
        int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        Map<String, Product> book = new LinkedHashMap<>();

        while (!firstInput.equals("buy")) {
            String[] input = firstInput.split(" ");
            String item = input[0];
            double costs = Double.parseDouble(input[1]);
            int qty = Integer.parseInt(input[2]);

            Product product = new Product(item, costs, qty);

            if (!book.containsKey(item)) {
                book.put(item, product);
            } else {
                product = book.get(item);
                product.setPrice(costs);
                int newQuantity = product.getQuantity() + qty;
                product.setQuantity(newQuantity);
                book.put(item, product);
            }

            firstInput = scanner.nextLine();
        }

        for (Map.Entry<String, Product> entry : book.entrySet()) {
            Product product = entry.getValue();
            double totalPrice = product.getPrice() * product.getQuantity();
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }
    }
}