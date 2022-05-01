package JF13ListsExercise;

/*
Write a program, which reads a list of integers from the console and receives commands, which manipulate the list.
Your program may receive the following commands:
•	Delete {element} - delete all elements in the array, which are equal to the given element
•	Insert {element} {position} - insert element at the given position
You should stop the program when you receive the command "end". Print all numbers in the array separated with a single whitespace.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class X02ChangeList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");

        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        String newCommand = scanner.nextLine();

        while (!newCommand.equals("end")) {
            String[] commands = newCommand.split(" ");

            int element = Integer.parseInt(commands[1]);

            switch (commands[0]) {
                //изтрива всички еднакви числа в листа
                case "Delete":
                    numbers.removeAll(Arrays.asList(element));
                    break;

                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    numbers.add(index, element);
                    break;
            }

            newCommand = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}