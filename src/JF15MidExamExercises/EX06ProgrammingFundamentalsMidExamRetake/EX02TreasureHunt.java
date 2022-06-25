package JF15MidExamExercises.EX06ProgrammingFundamentalsMidExamRetake;

/*
The pirates need to carry a treasure chest safely back to the ship, looting along the way.
Create a program that manages the state of the treasure chest along the way. On the first line, you will receive the initial loot of the treasure chest, which is a string of items separated by a "|".
"{loot1}|{loot2}|{loot3} … {lootn}"
The following lines represent commands until "Yohoho!" which ends the treasure hunt:
•	"Loot {item1} {item2}…{itemn}":
o	Pick up treasure loot along the way. Insert the items at the beginning of the chest.
o	If an item is already contained, don't insert it.
•	"Drop {index}":
o	Remove the loot at the given position and add it at the end of the treasure chest.
o	If the index is invalid, skip the command.
•	"Steal {count}":
o	Someone steals the last count loot items. If there are fewer items than the given count, remove as much as there are.
o	Print the stolen items separated by ", ":
"{item1}, {item2}, {item3} … {itemn}"
In the end, output the average treasure gain, which is the sum of all treasure items length divided by the count of all items inside the chest formatted to the second decimal point:
"Average treasure gain: {averageGain} pirate credits."
If the chest is empty, print the following message:
"Failed treasure hunt."
Input
•	On the 1st line, you are going to receive the initial treasure chest (loot separated by "|")
•	On the following lines, until "Yohoho!", you will be receiving commands.
Output
•	Print the output in the format described above.
Constraints
•	The loot items will be strings containing any ASCII code.
•	The indexes will be integers in the range [-200…200]
•	The count will be an integer in the range [1….100]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> items = new ArrayList<>();
        String[] buff = input.split("\\|");

        for (String s : buff) {
            items.add(s);
        }

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            List<String> commands = new ArrayList<>();
            String[] buffer = command.split("\\s+");

            for (String s : buffer) {
                commands.add(s);
            }

            switch (commands.get(0)) {
                case "Loot":

                    for (int i = 1; i < commands.size(); i++) {
                        if (!items.contains(commands.get(i))) {
                            items.add(0, commands.get(i));
                        }
                    }

                    break;

                case "Drop":
                    int index = Integer.parseInt(commands.get(1));

                    if (index >= 0 && index < items.size()) {

                        for (int i = 0; i < items.size(); i++) {
                            items.add(items.get(index));
                            items.remove(index);
                            break;
                        }
                    }

                    break;

                case "Steal":
                    int count = Integer.parseInt(commands.get(1));
                    int length = items.size();

                    if (count > length) {
                        count = length;
                    }

                    List<String> sublist = items.subList(length - count, length);

                    System.out.println(String.join(", ", sublist));
                    items = items.subList(0, length - count);
                    break;
            }

            command = scanner.nextLine();
        }

        if (items.isEmpty()) {
            System.out.println("Failed treasure hunt.");

        } else {
            double sumLengths = 0.0;

            for (int i = 0; i < items.size(); i++) {
                int currentLength = items.get(i).length();
                sumLengths += currentLength;
            }

            double result = sumLengths * 1.0 / items.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", result);
        }
    }
}
