package JF29FinalExamExersices.EXProgrammingFundamentaAdditionalRetakeExam_10January_2019PartI;

import java.util.Scanner;

/*
 You need to make cookies for Santa and his dwarfs.
You will receive the amount of batches – n that you need to bake. For every batch you will receive ingredients:  flour, sugar and cocoa in grams, each on a new line. You need to calculate how many boxes of cookies you get for every batch with the given ingredients and total boxes of cookies for all batches. To calculate the number of boxes per batch you need to divide total cookies per bake by cookies per box (see the table below). To get the total cookies per bake use the following formula and round the result to the nearest lower number:
({cup} + {smallSpoon} + {bigSpoon}) * min from({flourCups}, {sugarSpoons}, {cocoaSpoons}) / singleCookieGrams
To get the flourCups divide flour by cups.
To get the sugarSpoons divide sugar by bigSpoon.
And for the cocoaSpoons divide cocoa by smallSpoon.
The cups and the spoons must be integer numbers.
(see the table below)
If flourCups, sugarSpoons or cocoaSpoons for a single bake are not enough (<=0), print the following message: "Ingredients are not enough for a box of cookies."
Otherwise calculate the cookies and print the number of boxes you get for the current batch:
  "Boxes of cookies: {boxes of cookies per current bake}"
Item	Grams
Single cookie Grams 	25
Cup	140
Small Spoon	10
Big Spoon	20
Cookies per Box	5
Use the following table for calculations:
When you finish baking, pack the all the cookies in boxes and send them to Santa and his dwarfs and print the total number of boxes on the console.
"Total boxes: {totalBoxes for all bakes}"
Input
The input data should be read from the console. It will consist of:
•	Amount of batches - integer  number in range [0…1,000,000,000]
For every batch:
•	Amount of flour in grams – integer number in range [0…1,000]
•	Amount of sugar in grams – integer number in range [0…1,000]
•	Amount of cоcоа in grams – integer number in range [0…1,000]

The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
The output should be printed on the console.
•	If the ingredients for current bake are not enough:
"Ingredients are not enough for a box of cookies."
•	If the ingredients for current bake are enough:
"Boxes of cookies: {boxes of cookies per current bake}."
•	On the last line print:
"Total boxes: {totalBoxes for all bakes}"
 */

public class X01SantaSCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int cup = 140;
        int smallSpoon = 10;
        int bigSpoon = 20;
        double floorCups = 0;
        double sugarSpoons = 0;
        double cocoaSpoons = 0;
        int singleCookieGrams = 25;

        double sum = 0;

        for (int i = 0; i < n; i++) {
            double floorGrams = Integer.parseInt(scanner.nextLine());
            double sugarGrams = Integer.parseInt(scanner.nextLine());
            double cocoaGrams = Integer.parseInt(scanner.nextLine());

            floorCups = Math.floor(floorGrams / cup);
            sugarSpoons = Math.floor(sugarGrams / bigSpoon);
            cocoaSpoons = Math.floor(cocoaGrams / smallSpoon);

            double min1 = Math.min(floorCups, sugarSpoons);
            double min = Math.min(min1, cocoaSpoons);

            double cookiesPerBake = (cup + smallSpoon + bigSpoon) * min / singleCookieGrams;
            sum += Math.floor(cookiesPerBake / 5);

            if (floorCups <= 0 || sugarSpoons <= 0 || cocoaSpoons <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
            } else {
                System.out.printf("Boxes of cookies: %.0f%n", Math.floor(cookiesPerBake / 5));
            }
        }

        System.out.printf("Total boxes: %.0f%n", Math.floor(sum));
    }
}
