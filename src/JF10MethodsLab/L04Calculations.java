package JF10MethodsLab;

 /*
 Write a program that receives a string on the first line ("add", "multiply", "subtract", "divide") and on the next two lines
 receives two numbers. Create four methods (for each calculation) and invoke the right one depending on the command. The method
 should also print the result (needs to be void).
  */

import java.util.Scanner;

public class L04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        if (input.equals("subtract")) {
            subtracted(num1, num2);
        } else if (input.equals("add")) {
            added(num1, num2);
        } else if (input.equals("multiply")) {
            multiplied(num1, num2);
        } else if (input.equals("divide")) {
            divided(num1, num2);
        }
    }

    private static void subtracted(int num1, int num2) {
        int result = num1 - num2;
        System.out.println(result);
    }

    public static void added(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(result);
    }

    public static void multiplied(int num1, int num2) {
        int result = num1 * num2;
        System.out.println(result);
    }

    public static void divided(int num1, int num2) {
        int result = (num1) / num2;
        System.out.println(result);
    }
}