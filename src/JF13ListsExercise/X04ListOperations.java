package JF13ListsExercise;

/*
    You will be given numbers (list of integers) on the first input line. Until you receive "End" you will be given operations you have to apply on the list. The possible commands are:
•	Add {number} - add number at the end
•	Insert {number} {index} - insert number at given index
•	Remove {index} - remove that index
•	Shift left {count} - first number becomes last 'count' times
•	Shift right {count} - last number becomes first 'count' times
Note: The index given may be outside of the bounds of the array. In that case print "Invalid index".
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();
        String[] buffer = input.split("\\s+");

        for (String s : buffer) {
            numbers.add(Integer.parseInt(s));
        }

        String comm = scanner.nextLine();

        while (!comm.equals("End")) {
            String[] commands = comm.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    int inputNumber = Integer.parseInt(commands[1]);
                    //number
                    numbers.add(inputNumber);
                    break;

                case "Insert":
                    //number
                    //index
                    inputNumber = Integer.parseInt(commands[1]);
                    int index = Integer.parseInt(commands[2]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, inputNumber);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;

                case "Remove":
                    //index
                    index = Integer.parseInt(commands[1]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;

                case "Shift":
                    String direction = commands[1];
                    int count = Integer.parseInt(commands[2]);

                    switch (commands[1]) {
                        case "left":
                            //first number becomes last 'count' times
                            for (int i = 0; i < count; i++) {
                                numbers.add(numbers.get(0));
                                numbers.remove(0);
                            }

                            break;

                        case "right":
                            //last number becomes first 'count' times
                            for (int i = 0; i < count; i++) {
                                //прибавя елемента на позиция 0
                                numbers.add(0, numbers.get(numbers.size() - 1));
                                //премахва последния елемент
                                numbers.remove(numbers.size() - 1);
                            }

                            break;
                    }

                    break;
            }

            comm = scanner.nextLine();
        }
        // System.out.println(numbers);
        System.out.println(numbers.toString().replace("[", "").replace("]", "").replaceAll(",", ""));
    }
}