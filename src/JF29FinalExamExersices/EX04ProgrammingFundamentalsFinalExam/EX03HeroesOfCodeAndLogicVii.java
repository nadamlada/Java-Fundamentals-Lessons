package JF29FinalExamExersices.EX04ProgrammingFundamentalsFinalExam;

/*
You got your hands on the most recent update on the best MMORPG of all time – Heroes of Code and Logic. You want to play it all day long! So cancel all other arrangements and create your party!
On the first line of the standard input, you will receive an integer n – the number of heroes that you can choose for your party. On the next n lines, the heroes themselves will follow with their hit points and mana points separated by a single space in the following format:
"{hero name} {HP} {MP}"
-	HP stands for hit points and MP for mana points
-	a hero can have a maximum of 100 HP and 200 MP
After you have successfully picked your heroes, you can start playing the game. You will be receiving different commands, each on a new line, separated by " – ", until the "End" command is given.
There are several actions that the heroes can perform:
"CastSpell – {hero name} – {MP needed} – {spell name}"
•	If the hero has the required MP, he casts the spell, thus reducing his MP. Print this message:
o	"{hero name} has successfully cast {spell name} and now has {mana points left} MP!"
•	If the hero is unable to cast the spell print:
o	"{hero name} does not have enough MP to cast {spell name}!"
"TakeDamage – {hero name} – {damage} – {attacker}"
•	Reduce the hero HP by the given damage amount. If the hero is still alive (his HP is greater than 0) print:
o	"{hero name} was hit for {damage} HP by {attacker} and now has {current HP} HP left!"
•	If the hero has died, remove him from your party and print:
o	"{hero name} has been killed by {attacker}!"
"Recharge – {hero name} – {amount}"
•	The hero increases his MP. If it brings the MP of the hero above the maximum value (200), MP is increased to 200. (the MP can't go over the maximum value).
•	 Print the following message:
o	"{hero name} recharged for {amount recovered} MP!"
"Heal – {hero name} – {amount}"
•	The hero increases his HP. If a command is given that would bring the HP of the hero above the maximum value (100), HP is increased to 100 (the HP can't go over the maximum value).
•	 Print the following message:
o	"{hero name} healed for {amount recovered} HP!"
Input
•	On the first line of the standard input, you will receive an integer n
•	On the following n lines, the heroes themselves will follow with their hit points and mana points separated by a space in the following format
•	You will be receiving different commands, each on a new line, separated by " – ", until the "End" command is given
Output
•	Print all members of your party who are still alive, in the following format (their HP/MP need to be indented 2 spaces):
"{hero name}
  HP: {current HP}
  MP: {current MP}"
Constraints
•	The starting HP/MP of the heroes will be valid, 32-bit integers will never be negative or exceed the respective limits.
•	The HP/MP amounts in the commands will never be negative.
•	The hero names in the commands will always be valid members of your party. No need to check that explicitly.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03HeroesOfCodeAndLogicVii {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, int[]> catalog = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);

            //много важно -> мап с масив и извикване на елементите от масива
            catalog.putIfAbsent(name, new int[2]);
            catalog.get(name)[0] += hp;
            catalog.get(name)[1] += mp;

            if (catalog.get(name)[0] > 100) {
                catalog.get(name)[0] = 100;
            }

            if (catalog.get(name)[1] > 200) {
                catalog.get(name)[1] = 200;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" - ");
            String currentName = commands[1];

            switch (commands[0]) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(commands[2]);
                    String spellName = commands[3];

                    if (catalog.get(currentName)[1] >= mpNeeded) {
                        catalog.get(currentName)[1] -= mpNeeded;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                currentName, spellName, catalog.get(currentName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", currentName, spellName);
                    }

                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    catalog.get(currentName)[0] -= damage;

                    if (catalog.get(currentName)[0] > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                currentName, damage, attacker, catalog.get(currentName)[0]);
                    } else {
                        catalog.remove(currentName);
                        System.out.printf("%s has been killed by %s!%n", currentName, attacker);
                    }

                    break;

                case "Recharge":
                    int current = catalog.get(currentName)[1];
                    int amount = Integer.parseInt(commands[2]);
                    catalog.get(currentName)[1] += amount;

                    if (catalog.get(currentName)[1] > 200) {
                        catalog.get(currentName)[1] = 200;
                        amount = 200 - current;
                    }

                    System.out.printf("%s recharged for %d MP!%n", currentName, amount);
                    break;

                case "Heal":
                    current = catalog.get(currentName)[0];
                    amount = Integer.parseInt(commands[2]);
                    catalog.get(currentName)[0] += amount;

                    if (catalog.get(currentName)[0] > 100) {
                        catalog.get(currentName)[0] = 100;
                        amount = 100 - current;
                    }

                    System.out.printf("%s healed for %d HP!%n", currentName, amount);
                    break;
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, int[]> entry : catalog.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf("  HP: %s%n", entry.getValue()[0]);
            System.out.printf("  MP: %s%n", entry.getValue()[1]);
        }
    }
}
