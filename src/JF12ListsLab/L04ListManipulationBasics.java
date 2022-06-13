package JF12ListsLab;

/*
Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:
Add {number}: add a number to the end of the list
Remove {number}: remove a number from the list
RemoveAt {index}: remove a number at a given index
Insert {number} {index}: insert a number at a given index
Note: All the indices will be valid!
When you receive the "end" command print the final state of the list (separated by spaces).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        for (String element : input) {
            numbers.add(Integer.parseInt(element));
        }

        String commands = scanner.nextLine();

        while (!commands.equals("end")) {

            //създаваме лист от стрингове
            List<String> commandsList = new ArrayList<>();
            String[] commandsArray = commands.split(" ");

            for (String element : commandsArray) {
                commandsList.add(element);
            }

            switch (commandsList.get(0)) {
                //добавя след последния индекс
                case "Add":
                    int numberToAdd = Integer.parseInt(commandsList.get(1));
                    numbers.add(numberToAdd);
                    break;

                //премахва точно това число
                case "Remove":
                    int removeNumber = Integer.parseInt(commandsList.get(1));
                    numbers.remove(Integer.valueOf(removeNumber));
                    break;

                //премахва на тази позиция
                case "RemoveAt":
                    int removeAtIndex = Integer.parseInt(commandsList.get(1));
                    numbers.remove(removeAtIndex);
                    break;

                // инсърт цифра на индекса
                case "Insert":
                    int insertNumber = Integer.parseInt(commandsList.get(1));
                    int insertAtIndex = Integer.parseInt(commandsList.get(2));
                    numbers.add(insertAtIndex, insertNumber);
                    break;
            }

            commands = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}