package JF15MidExamExercises.EX05ProgrammingFundamentalsMidExam;

/*
You will receive a journal with some collecting items, separated with a comma and a space (", "). After that, until receiving "Craft!" you will be receiving different commands split by " - ":
•	"Collect - {item}" - you should add the given item to your inventory. If the item already exists, you should skip this line.
•	"Drop - {item}" - you should remove the item from your inventory if it exists.
•	"Combine Items - {old_item}:{new_item}" - you should check if the old item exists. If so, add the new item after the old one. Otherwise, ignore the command.
•	"Renew – {item}" – if the given item exists, you should change its position and put it last in your inventory.
Output
After receiving "Craft!" print the items in your inventory, separated by ", ".
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inventory = new ArrayList<>();
        String[] buff = input.split(", ");

        for (String s : buff) {
            inventory.add(s);
        }

        String commands = scanner.nextLine();

        while (!commands.equals("Craft!")) {
            String[] whatIsThis = commands.split(" - ");
            String item = whatIsThis[1];

            switch (whatIsThis[0]) {
                case "Collect":
                    if (!inventory.contains(item)) {
                        inventory.add(item);
                    }

                    break;

                case "Drop":

                    if (inventory.contains(item)) {
                        inventory.remove(item);
                    }

                    break;

                case "Combine Items":
                    String[] oldNew = whatIsThis[1].split(":");
                    String oldItem = oldNew[0];
                    String newItem = oldNew[1];

                    if (inventory.contains(oldItem)) {
                        int indexOld = inventory.indexOf(oldItem);
                        inventory.add(indexOld + 1, newItem);
                    }

                    break;

                case "Renew":

                    if (inventory.contains(item)) {
                        int index = inventory.indexOf(item);
                        inventory.add(item);
                        inventory.remove(index);
                    }

                    break;
            }

            commands = scanner.nextLine();
        }

        String print = inventory.toString().replace("[", "").replace("]", "");
        System.out.println(print);
    }
}