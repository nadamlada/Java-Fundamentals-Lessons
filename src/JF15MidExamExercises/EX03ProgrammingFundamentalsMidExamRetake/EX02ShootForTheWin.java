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
import java.util.Scanner;

public class EX02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.next();

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);

            if (index >= 0 && index < numbers.length) {
                int currentOperation = numbers[index];

                for (int i = 0; i < numbers.length; i++) {

                    if (numbers[i] == -1) {
                        continue;
                    }

                    if (numbers[i] > currentOperation) {
                        numbers[i] -= currentOperation;
                    } else if (numbers[i] <= currentOperation) {
                        numbers[i] += currentOperation;
                    }
                }

                for (int i = 0; i < numbers.length; i++) {

                    if (i == index) {
                        numbers[i] = -1;
                    }
                }

            } else {
                command = scanner.next();
                continue;
            }

            command = scanner.next();
        }

        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == -1) {
                count++;
            }
        }

        System.out.printf("Shot targets: %d -> ", count);

        for (int number : numbers) {
            System.out.print(number + " ");

        }
    }
}