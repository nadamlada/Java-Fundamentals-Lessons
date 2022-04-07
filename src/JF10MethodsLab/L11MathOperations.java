package JF10MethodsLab;

/*
Write a method that receives two numbers and an operator, calculates the result, and returns it. You will be given three lines of input. The first will be the first number, the second one will be the operator and the last one will be the second number. The possible operators are: / * + -
Print the result rounded up to the second decimal point.
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class L11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double b = Double.parseDouble(scanner.nextLine());

        double searched = operations(a, operator, b);
        DecimalFormat df = new DecimalFormat("0.##");           //принтиране десимал формат
        System.out.println(df.format(searched));
    }

    private static double operations(double a, String operator, double b) {

        double result = 0.0;
        switch (operator) {
            case "*":
                result = a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "/":
                result = a / b;
                break;
            case "-":
                result = a - b;
                break;
        }

        return result;
    }
}