package JF15MidExamExercises.EX05ProgrammingFundamentalsMidExam;

 /*
         You have initial health 100 and initial bitcoins 0. You will be given a string representing the dungeon's rooms. Each room is separated with '|' (vertical bar): "room1|room2|room3…"
 Each room contains a command and a number, separated by space. The command can be:
 •	"potion"
 o	You are healed with the number in the second part. But your health cannot exceed your initial health (100).
 o	First print: "You healed for {amount} hp."
 o	After that, print your current health: "Current health: {health} hp."
 •	"chest"
 o	You've found some bitcoins, the number in the second part.
 o	Print: "You found {amount} bitcoins."
 •	In any other case, you are facing a monster, which you will fight. The second part of the room contains the attack of the monster. You should remove the monster's attack from your health.
 o	If you are not dead (health <= 0), you've slain the monster, and you should print: "You slayed {monster}."
 o	If you've died, print "You died! Killed by {monster}." and your quest is over. Print the best room you've manage to reach: "Best room: {room}"
 If you managed to go through all the rooms in the dungeon, print on the following three lines:
 "You've made it!"
 "Bitcoins: {bitcoins}"
 "Health: {health}"
 Input / Constraints
 You receive a string representing the dungeon's rooms, separated with '|' (vertical bar): "room1|room2|room3…".
 Output
 Print the corresponding messages described above.
  */

import java.util.Scanner;

public class EX02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] commands = input.split("\\|");

        int currentHealth = 100;
        int sumBitcoins = 0;

        for (int i = 0; i < commands.length; i++) {
            String[] splitCommands = commands[i].split(" ");

            switch (splitCommands[0]) {

                case ("potion"):
                    int forPrint = 0;
                    int index = Integer.parseInt(splitCommands[1]);
                    currentHealth += index;
                    if (currentHealth > 100) {

                        forPrint = 100 - (currentHealth - index);
                        currentHealth = 100;
                    } else {
                        forPrint = index;
                    }

                    System.out.printf("You healed for %d hp.%n", forPrint);
                    System.out.printf("Current health: %d hp.%n", currentHealth);
                    break;

                case ("chest"):
                    int bitcoins = Integer.parseInt(splitCommands[1]);
                    System.out.printf("You found %d bitcoins.%n", bitcoins);
                    sumBitcoins += bitcoins;
                    break;

                default:
                    String monster = splitCommands[0];
                    int index2 = Integer.parseInt(splitCommands[1]);
                    currentHealth -= index2;

                    if (currentHealth > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", i + 1);
                        return;
                    }

                    break;
            }
        }

        System.out.printf("You've made it!%n");
        System.out.printf("Bitcoins: %d%n", sumBitcoins);
        System.out.printf("Health: %d%n", currentHealth);
    }
}