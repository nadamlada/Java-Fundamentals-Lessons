package JF04DdataTypesAndVariablesLab;

/*
You will be given an integer that will be a distance in meters. Write a program that converts meters to kilometers formatted to the second decimal point.
*/

import java.util.Scanner;

public class L01ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());
        double km = meters * 0.1 / 100;
        System.out.printf("%.2f", km);

    }
}