package JF13ListsLab;

/*
Now we will implement more complicated list commands. Again, read a list, and until you receive "end" read commands:
Contains {number} – check if the list contains the number. If yes print "Yes", otherwise print "No such number"
Print even – print all the numbers that are even separated by a space
Print odd – print all the numbers that are oddly separated by a space
Get sum – print the sum of all the numbers
Filter {condition} {number} – print all the numbers that fulfill that condition. The condition will be either '<', '>', ">=", "<="
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        String[] input = scanner.nextLine().split(" ");

        for (String element : input) {
            numbers.add(Integer.parseInt(element));
        }

        String inputCommands = scanner.nextLine();

        List<Integer> print = new ArrayList<>();

        boolean printPrintList = false;

        while (!inputCommands.equals("end")) {
            String[] commands = inputCommands.split(" ");

            switch (commands[0]) {
                //дали числото го има в инпута
                case "Contains":
                    int containedNum = Integer.parseInt(commands[1]);

                    if (numbers.contains(containedNum)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    printPrintList = false;
                    break;

                //печатай четните в листа и нечетните
                case "Print":
                    if (commands[1].equals("even")) {

                        for (int number : numbers) {
                            if (number % 2 == 0) {
                                print.add(number);
                            }
                        }

                    } else if (commands[1].equals("odd")) {

                        for (int number : numbers) {
                            if (number % 2 != 0) {
                                print.add(number);
                            }
                        }
                    }

                    printPrintList = true;
                    break;

                //get sum
                case "Get":
                    int sum = 0;

                    for (Integer number : numbers) {
                        sum += number;
                    }

                    System.out.println(sum);
                    printPrintList = false;
                    break;

                case "Filter":
                    int evaluationNum = Integer.parseInt(commands[2]);

                    if (commands[1].equals("<")) {

                        for (Integer number : numbers) {
                            if (number < evaluationNum) {
                                print.add(number);
                            }
                        }

                    } else if (commands[1].equals(">")) {

                        for (Integer number : numbers) {
                            if (number > evaluationNum) {
                                print.add(number);
                            }
                        }

                    } else if (commands[1].equals(">=")) {

                        for (Integer number : numbers) {
                            if (number >= evaluationNum) {
                                print.add(number);
                            }
                        }

                    } else if (commands[1].equals("<=")) {

                        for (Integer number : numbers) {
                            if (number <= evaluationNum) {
                                print.add(number);
                            }
                        }
                    }
                    printPrintList = true;
                    break;
            }

            inputCommands = scanner.nextLine();

            if (printPrintList) {
                System.out.println(print.toString().replaceAll("[\\[\\],]", ""));
            }
            // трие всичко от листа
            print.clear();
        }
    }
}