package JF03BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

/*
Write a program, which helps you buy the games. The valid games are the following games in this table:
Name	Price
OutFall 4	$39.99
CS: OG	$15.99
Zplinter Zell	$19.99
Honored 2	$59.99
RoverWatch	$29.99
RoverWatch Origins Edition	$39.99
On the first line, you will receive your current balance – a floating-point number in the range [0.00…5000.00].
Until you receive the command "Game Time", you have to keep buying games. When a game is bought, the user’s balance decreases by the price of the game.
Additionally, the program should obey the following conditions:
•	If a game the user is trying to buy is not present in the table above, print "Not Found" and read the next line.
•	If at any point, the user has $0 left, print "Out of money!" and end the program.
•	Alternatively, if the user is trying to buy a game that they can’t afford, print "Too Expensive" and read the next line.
When you receive "Game Time", print the user’s remaining money and total spent on games, rounded to the 2nd decimal place.
 */

import java.util.Scanner;

public class MX03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double allMoney = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double spent = 0;
        boolean foundGame = false;

        while (!input.equals("Game Time")) {
            boolean tooExpensive = false;
            if (allMoney <= 0) {
                System.out.printf("Out of money!%n");
                break;
            }

            if (input.equals("OutFall 4")) {
                foundGame = true;
                if (allMoney >= 39.99) {
                    allMoney -= 39.99;
                    spent += 39.99;
                    System.out.printf("Bought OutFall 4%n");
                } else {
                    tooExpensive = true;
                }
            }

            if (input.equals("CS: OG")) {
                foundGame = true;
                if (allMoney >= 15.99) {
                    allMoney -= 15.99;
                    spent += 15.99;
                    System.out.printf("Bought CS: OG%n");
                } else {
                    tooExpensive = true;
                }
            }

            if (input.equals("Zplinter Zell")) {
                foundGame = true;
                if (allMoney >= 19.99) {
                    allMoney -= 19.99;
                    spent += 19.99;
                    System.out.printf("Bought Zplinter Zell%n");
                } else {
                    tooExpensive = true;
                }
            }

            if (input.equals("Honored 2")) {
                foundGame = true;
                if (allMoney >= 59.99) {
                    allMoney -= 59.99;
                    spent += 59.99;
                    System.out.printf("Bought Honored 2%n");
                } else {
                    tooExpensive = true;
                }
            }

            if (input.equals("RoverWatch")) {
                foundGame = true;
                if (allMoney >= 29.99) {
                    allMoney -= 29.99;
                    spent += 29.99;
                    System.out.printf("Bought RoverWatch%n");
                } else {
                    tooExpensive = true;
                }
            }

            if (input.equals("RoverWatch Origins Edition")) {
                foundGame = true;
                if (allMoney >= 39.99) {
                    allMoney -= 39.99;
                    spent += 39.99;
                    System.out.printf("Bought RoverWatch Origins Edition%n");
                } else {
                    tooExpensive = true;
                }
            }

            if (!foundGame)
                System.out.printf("Not Found%n");

            if (tooExpensive) {
                System.out.printf("Too Expensive%n");
            }

            input = scanner.nextLine();
        }

        if (allMoney > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, allMoney);
        } else {
            System.out.println("Out of mo-ney!");
        }
    }
}