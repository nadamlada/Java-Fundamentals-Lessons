package JF10MethodsLab;

/*
Create a method that calculates and returns the value of a number raised to a given power.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class L08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double main = Double.parseDouble(scanner.nextLine());
        int pow = Integer.parseInt(scanner.nextLine());
        double result = powCalculation(main, pow);

        //принтира само цифрите след запетайката, броят им е равен на броят на диесите
        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(result));
    }

    public static double powCalculation(double a, int pow) {

        double result = 1;
        for (int i = 1; i <= pow; i++) {
            result = a * result;
        }
        return result;
    }
}