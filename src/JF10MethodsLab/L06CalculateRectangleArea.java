package JF10MethodsLab;

/*
Create a method that calculates and returns the area of a rectangle by given width and length.
 */

import java.util.Scanner;

public class L06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        double area = calculateArea(a, b);
        System.out.printf("%.0f", area);
    }

    private static double calculateArea(double a, double b) {
        return a * b;
    }

}

