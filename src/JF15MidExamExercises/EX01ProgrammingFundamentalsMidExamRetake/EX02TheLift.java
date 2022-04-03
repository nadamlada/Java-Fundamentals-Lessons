package JF15MidExamExercises.EX01ProgrammingFundamentalsMidExamRetake;

/*
Write a program that finds a place for the tourist on a lift.
Every wagon should have a maximum of 4 people on it. If a wagon is full, you should direct the people to the next one with space available.
Input
•	On the first line, you will receive how many people are waiting to get on the lift
•	On the second line, you will receive the current state of the lift separated by a single space: " ".
Output
When there is no more available space left on the lift, or there are no more people in the queue, you should print on the console the final state of the lift's wagons separated by " " and one of the following messages:
•	If there are no more people and the lift have empty spots, you should print:
"The lift has empty spots!
{wagons separated by ' '}"
•	If there are still people in the queue and no more available space, you should print:
"There isn't enough space! {people} people in a queue!
{wagons separated by ' '}"
•	If the lift is full and there are no more people in the queue, you should print only the wagons separated by " "
 */

import java.util.Arrays;
import java.util.Scanner;

public class EX02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {

            for (int j = lift[i]; j <= 4; j++) {

                if ((lift[i] < 4) && people > 0) {
                    lift[i]++;
                    people--;

                    if (lift[i] == 4) {
                        break;
                    }
                }
            }
        }

        if ((people == 0) && (!IsFull(lift))) {
            System.out.println("The lift has empty spots!");
            printLift(lift);
        } else if (people > 0 && IsFull(lift)) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            printLift(lift);
        }

        if (IsFull(lift) && people == 0) {
            printLift(lift);
        }

    }

    private static void printLift(int[] lift) {

        for (int i = 0; i < lift.length; i++) {
            System.out.print(lift[i] + " ");
        }
    }

    public static boolean IsFull(int[] lift) {
        boolean isFull = false;
        int sum = 0;

        for (int i : lift) {
            sum += i;

            if (sum == lift.length * 4) {
                isFull = true;
            }

        }


        return isFull;
    }
}