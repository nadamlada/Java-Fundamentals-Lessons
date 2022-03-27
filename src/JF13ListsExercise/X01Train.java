package JF13ListsExercise;

/*
On the first line, you will be given a list of wagons (integers). Each integer represents the number of passengers that are currently in each wagon. On the next line, you will get the max capacity of each wagon (single integer).
Until you receive "end" you will be given two types of input:
 •	Add {passengers} - add a wagon to the end with the given number of passengers
 •	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)
At the end print the final state of the train (all the wagons separated by a space)
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        String[] buffer = input.split("\\s+");

        for (String s : buffer) {
            numbers.add(Integer.parseInt(s));
        }

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String commands = scanner.nextLine();

        while (!commands.equals("end")) {
            String[] commandsArray = commands.split(" ");

            if (commandsArray[0].equals("Add")) {
                numbers.add(Integer.parseInt(commandsArray[1]));
            } else {
                int passengers = Integer.parseInt(commands);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) + passengers <= maxCapacity) {
                        numbers.set(i, passengers + numbers.get(i));
                        break;
                    }
                }
            }

            commands = scanner.nextLine();
        }

        System.out.println(numbers.toString().
                replace("[", "")
                .replace("]", "")
                .replaceAll(",", ""));
    }
}