package JF15MidExamExercises.EX04ProgrammingFundamentalsMidExam;

/*
You will receive an initial list with groceries separated by an exclamation mark "!".
After that, you will be receiving 4 types of commands until you receive "Go Shopping!".
•	"Urgent {item}" - add the item at the start of the list.  If the item already exists, skip this command.
•	"Unnecessary {item}" - remove the item with the given name, only if it exists in the list. Otherwise, skip this command.
•	"Correct {oldItem} {newItem}" - if the item with the given old name exists, change its name with the new one. Otherwise, skip this command.
•	"Rearrange {item}" - if the grocery exists in the list, remove it from its current position and add it at the end of the list. Otherwise, skip this command.
Constraints
•	There won't be any duplicate items in the initial list
Output
•	Print the list with all the groceries, joined by ", ":
"{firstGrocery}, {secondGrocery}, … {nthGrocery}"
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> market = new ArrayList<>();
        String[] buffer = input.split("!");

        for (String s : buffer) {
            market.add(s);
        }

        String commands = scanner.nextLine();

        while (true) {

            if (commands.equals("Go Shopping!")) {
                break;
            }

            String[] newItems = commands.split(" ");
            String item = newItems[0];

            switch (newItems[0]) {
                case "Urgent":
                    String product = newItems[1];
                    if (!market.contains(product)) {
                        market.add(0, product);
                    }

                    break;

                case "Unnecessary":

                    product = newItems[1];
                    market.remove(product);
                    break;

                case "Correct":
                    String oldItem = newItems[1];
                    String replaceItems = newItems[2];

                    if (market.contains(oldItem)) {
                        int index = market.indexOf(oldItem);
                        market.set(index, replaceItems);
                    }

                    break;

                case "Rearrange":
                    product = newItems[1];

                    if (market.contains(product)) {
                        market.add(product);
                        market.remove(product);
                    }

                    break;
            }

            commands = scanner.nextLine();
        }

        System.out.println(market.toString().replace("[", "").replace("]", ""));
    }
}
