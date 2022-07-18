package JF29FinalExamExersices.EXProgrammingFundamentaAdditionalRetakeExam10January2019PartIA;

/*
You will be given an array of integers, which represent the house numbers you should visit. The commands will lead you to them. If they lead you to non-existing places, don’t move.
•	Forward {numberOfSteps}
•	Back {numberOfSteps}
o	When you receive the “Forward” or “Back” command, you move the given number of times in this direction and remove the house in this position from your list. Also, when you receive the next command, you continue from this position.
•	Gift {index} {houseNumber}
o	Enter a new house number, which the dwarves have left out on purpose, at the given position and move to its position.
•	Swap {indexOfFirst} {indexOfSecond}
o	Santa wants to rearrange his path and swap the order of two houses. You will receive the numbers of the houses, that need to be switched and he doesn’t need to move to fulfill this command.
Input
•	On the first line you will receive the number of commands – integer in the range [1-50]
•	On the second line you will receive the array of integers, that represent the houses, split by a single space – valid integers in the range [1 – 500]
•	On the next n lines, you will receive the commands in the following format:
o	Forward {steps}
o	Back {steps}
o	Gift {index} {value}
o	Swap {value1} {value2}
Output
•	Print the last position and the remaining houses in the following format:
“Position {position}”
“{houseNumber}, {houseNumber}………, {houseNumber}”
Constraints
•	The house numbers will be valid integers in the range [1 - 1000]
•	The number of commands will be a valid integer in the range [1 - 50]
•	The commands will be given in the exact format as they are written above
•	There will always be at least one valid command
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class X02SantasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> houses = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int currentIndex = 0;

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {

                case "Forward":
                    int numberOfSteps = Integer.parseInt(commands[1]);
                    currentIndex += numberOfSteps;

                    if (currentIndex >= 0 && currentIndex < houses.size()) {
                        houses.remove(currentIndex);
                    } else {
                        currentIndex -= numberOfSteps;
                    }

                    break;

                case "Back":
                    int steps = Integer.parseInt(commands[1]);
                    currentIndex -= steps;

                    if (currentIndex >= 0 && currentIndex < houses.size()) {
                        houses.remove(currentIndex);
                    } else {
                        currentIndex += steps;
                    }

                    break;

                case "Gift":
                    int index = Integer.parseInt(commands[1]);
                    int houseNumber = Integer.parseInt(commands[2]);

                    if (index >= 0 && index < houses.size()) {
                        houses.add(index, houseNumber);
                        currentIndex = index;
                    }

                    break;

                case "Swap":
                    int first = Integer.parseInt(commands[1]);
                    int second = Integer.parseInt(commands[2]);
                    int firstIndex = houses.indexOf(first);
                    int secondIndex = houses.indexOf(second);

                    if (firstIndex >= 0 && firstIndex < houses.size()) {

                        if (secondIndex >= 0 && secondIndex < houses.size()) {
                            houses.set(firstIndex, second);
                            houses.set(secondIndex, first);
                        }
                    }

                    break;
            }
        }

        System.out.printf("Position: %d%n", currentIndex);
        System.out.println(houses.toString().replaceAll("]", "").replaceAll("\\[", ""));
    }
}
