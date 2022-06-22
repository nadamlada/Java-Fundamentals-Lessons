package JF15MidExamExercises.EX03ProgrammingFundamentalsMidExamRetake;

/*
Write a program that helps you keep track of your shot targets. You will receive a sequence with integers, separated by a single space, representing targets and their value. Afterward, you will be receiving indices until the "End" command is given, and you need to print the targets and the count of shot targets.
Every time you receive an index, you need to shoot the target on that index, if it is possible.
Every time you shoot a target, its value becomes -1, and it is considered shot. Along with that, you also need to:
•	Reduce all the other targets, which have greater values than your current target, with its value.
•	Increase all the other targets, which have less than or equal value to the shot target, with its value.
Keep in mind that you can't shoot a target, which is already shot. You also can't increase or reduce a target, which is considered shot.
When you receive the "End" command, print the targets in their current state and the count of shot targets in the following format:
"Shot targets: {count} -> {target1} {target2}… {targetn}"
Input / Constraints
•	On the first line of input, you will receive a sequence of integers, separated by a single space – the targets sequence.
•	On the following lines, until the "End" command, you be receiving integers each on a single line – the index of the target to be shot.
Output
•	The format of the output is described above in the problem description.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> targets = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!commands.equals("End")) {
            String[] commandsArr = commands.split(" ");
            int index = Integer.parseInt(commandsArr[1]);
            int value = Integer.parseInt(commandsArr[2]);

            switch (commandsArr[0]) {
                case "Shoot":

                    if (index >= 0 && index < targets.size()) {
                        int reducedPower = targets.get(index) - value;
                        if (reducedPower <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, reducedPower);
                        }
                    }

                    break;

                case "Add":

                    if (index >= 0 && index < targets.size()) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }

                    break;

                case "Strike":
                    if (index < 0 && index >= targets.size()) {
                        break;
                    }

                    value = Math.abs(value);
                    int start = index - value;
                    int end = index + value;

                    if (start >= 0 && end < targets.size()) {

                        for (int i = start; i <= end; i++) {
                            targets.remove(start);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }

            commands = scanner.nextLine();
        }

        String print = targets.toString().replace("[", "").replace("]", "").replaceAll("\\, ", "\\|");
        System.out.println(print);
    }
}

