package JF05_DataTypesAndVariablesExercise;

/*
9.	*Spice Must Flow
Spice is Love, Spice is Life. And most importantly, Spice must flow. It must be extracted from the scorching sands of Arrakis, under the constant threat of giant sandworms. To make the work as efficient as possible, the Duke has tasked you with the creation of management software.
Write a program that calculates the total amount of spice that can be extracted from a source.
The source has a starting yield, which indicates how much spice can be mined on the first day. After it has been mined for a day, the yield drops by 10, meaning on the second day it’ll produce 10 less spice than on the first, on the third day 10 less than on the second, and so on (see examples).
A source is considered profitable only while its yield is at least 100 – when less than 100 spices are expected in a day, abandon the source.
The mining crew consumes 26 spices every day at the end of their shift and an additional 26 after the mine has been exhausted. Note that the workers cannot consume more spice than there is in storage.
When the operation is complete, print on the console on two separate lines how many days the mine has operated and the total amount of spice extracted.
Input
You will receive a number, representing the starting yield of the source.
Output
Print on the console on two separate lines how many days the mine has operated and the total amount of spice extracted.
 Constraints
•	The starting yield will be a positive integer within the range [0 … 2 147 483 647]
 */

import java.util.Scanner;

public class X09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yeld = Integer.parseInt(scanner.nextLine());
        int newYeld = 0;
        int leaving = 0;
        int sumleaving = 0;
        int counter = 0;

        while (yeld >= 100) {
            leaving = yeld - 26;
            newYeld = yeld - 10;
            yeld = newYeld;
            sumleaving += leaving;
            counter++;
        }
        if (sumleaving >= 26)
            leaving = sumleaving - 26;

        System.out.printf("%d%n%d", counter, leaving);

    }
}
/*

///това работи
{
            int startingYield = int.Parse(Console.ReadLine());

            int days = 0;
            int spice = 0;
            int realSpice = 0;
            while (startingYield >= 100)
            {
                spice = startingYield;
                days += 1;
                spice -= 26;
                realSpice += spice;
                startingYield -= 10;
            }
            if (realSpice >= 26)
            {
                realSpice -= 26;
            }
            Console.WriteLine(days);
            Console.WriteLine(realSpice);
        }

 */