package JF15MidExamExercises.EX06ProgrammingFundamentalsMidExamRetake;

/*
The pirates encounter a huge Man-O-War at sea.
Create a program that tracks the battle and either chooses a winner or prints a stalemate. On the first line, you will receive the status of the pirate ship, which is a string representing integer sections separated by ">". On the second line, you will receive the same type of status, but for the warship:
"{section1}>{section2}>{section3}… {sectionn}"
On the third line, you will receive the maximum health capacity a section of the ship can reach.
The following lines represent commands until "Retire":
•	"Fire {index} {damage}" - the pirate ship attacks the warship with the given damage at that section. Check if the index is valid and if not, skip the command. If the section breaks (health <= 0) the warship sinks, print the following and stop the program: "You won! The enemy ship has sunken."
•	"Defend {startIndex} {endIndex} {damage}" - the warship attacks the pirate ship with the given damage at that range (indexes are inclusive). Check if both indexes are valid and if not, skip the command. If the section breaks (health <= 0) the pirate ship sinks, print the following and stop the program:
"You lost! The pirate ship has sunken."
•	"Repair {index} {health}" - the crew repairs a section of the pirate ship with the given health. Check if the index is valid and if not, skip the command. The health of the section cannot exceed the maximum health capacity.
•	"Status" - prints the count of all sections of the pirate ship that need repair soon, which are all sections that are lower than 20% of the maximum health capacity. Print the following:
"{count} sections need repair."
In the end, if a stalemate occurs, print the status of both ships, which is the sum of their individual sections, in the following format:
"Pirate ship status: {pirateShipSum}
Warship status: {warshipSum}"
Input
•	On the 1st line, you are going to receive the status of the pirate ship (integers separated by '>')
•	On the 2nd line, you are going to receive the status of the warship
•	On the 3rd line, you will receive the maximum health a section of a ship can reach.
•	On the following lines, until "Retire", you will be receiving commands.
Output
•	Print the output in the format described above.
Constraints
•	The section numbers will be integers in the range [1….1000]
•	The indexes will be integers [-200….200]
•	The damage will be an integer in the range [1….1000]
•	The health will be an integer in the range [1….1000]
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        List<Integer> pirate = Arrays.stream(one.split(">")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        List<Integer> warship = Arrays.stream(input.split(">")).map(Integer::parseInt).collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());
        String commands = scanner.nextLine();

        while (!commands.equals("Retire")) {
            String[] commandsArr = commands.split(" ");

            switch (commandsArr[0]) {
                case "Fire":
                    int index = Integer.parseInt(commandsArr[1]);
                    int damage = Integer.parseInt(commandsArr[2]);

                    if (index >= 0 && index < warship.size()) {
                        int setValue = warship.get(index) - damage;

                        if (setValue <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }

                        for (int i = 0; i < warship.size(); i++) {
                            warship.set(index, setValue);
                            break;
                        }
                    }

                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(commandsArr[1]);
                    int endIndex = Integer.parseInt(commandsArr[2]);
                    int damage2 = Integer.parseInt(commandsArr[3]);

                    if ((startIndex >= 0 && startIndex < pirate.size()) && (endIndex >= 0 && endIndex < pirate.size())) {
                        int a = Math.min(startIndex, endIndex);
                        int b = Math.max(startIndex, endIndex);

                        for (int i = a; i <= b; i++) {
                            int current = pirate.get(i);
                            int afterDamage = current - damage2;

                            if (afterDamage <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }

                            pirate.set(i, afterDamage);
                        }
                    }

                    break;

                case "Repair":
                    int index2 = Integer.parseInt(commandsArr[1]);
                    int health = Integer.parseInt(commandsArr[2]);

                    if (index2 >= 0 && index2 < pirate.size()) {
                        int afterIncreased = pirate.get(index2) + health;

                        if (maxHealth <= afterIncreased) {
                            afterIncreased = maxHealth;
                        }

                        pirate.set(index2, afterIncreased);
                    }

                    break;

                case "Status":
                    double maxBeforeRepair = 0.2 * maxHealth;
                    int countForRepair = 0;

                    for (int i = 0; i < pirate.size(); i++) {
                        if (pirate.get(i) < maxBeforeRepair) {
                            countForRepair++;
                        }
                    }

                    System.out.printf("%d sections need repair.%n", countForRepair);
                    break;
            }

            commands = scanner.nextLine();
        }

        //sum of sections in pirate
        int sumPirate = 0;

        for (int i = 0; i < pirate.size(); i++) {
            sumPirate += pirate.get(i);
        }

        //sum of sections war
        int sumWarShip = 0;

        for (int i = 0; i < warship.size(); i++) {
            sumWarShip += warship.get(i);
        }

        System.out.printf("Pirate ship status: %d%n", sumPirate);
        System.out.printf("Warship status: %d%n", sumWarShip);
    }
}
