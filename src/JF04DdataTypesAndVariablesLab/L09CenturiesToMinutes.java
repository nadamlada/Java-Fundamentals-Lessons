package JF04DdataTypesAndVariablesLab;

/*
Write a program to enter an integer number of centuries and convert it to years, days, hours, and minutes.
 */

import java.util.Scanner;

public class L09CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());

        int years = centuries * 100;            //2000
        double days = years * 365.2422;
        double hours = days * 24;
        double min = hours * 60;

        System.out.printf("%d centuries = %d years = %.0f days = %.0f hours = %.0f minutes", centuries, years, days, hours, min);
    }
}