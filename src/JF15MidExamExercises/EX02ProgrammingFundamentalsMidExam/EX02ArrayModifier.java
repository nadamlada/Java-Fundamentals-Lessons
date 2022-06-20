package JF15MidExamExercises.EX02ProgrammingFundamentalsMidExam;

/*
You are given an array with integers. Write a program to modify the elements after receiving the following commands:
•	"swap {index1} {index2}" takes two elements and swap their places.
•	"multiply {index1} {index2}" takes element at the 1st index and multiply it with the element at 2nd index. Save the product at the 1st index.
•	"decrease" decreases all elements in the array with 1.
Input
On the first input line, you will be given the initial array values separated by a single space.
On the next lines you will receive commands until you receive the command "end". The commands are as follow:
•	"swap {index1} {index2}"
•	"multiply {index1} {index2}"
•	"decrease"
Output
The output should be printed on the console and consist of elements of the modified array – separated by a comma and a single space ", ".
Constraints
•	Elements of the array will be integer numbers in the range [-231...231]
•	Count of the array elements will be in the range [2...100]
•	Indexes will be always in the range of the array
 */

import java.util.Arrays;
import java.util.Scanner;

public class EX02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        String commands = scanner.nextLine();

        while (!commands.equals("end")) {
            String[] toDo = commands.split(" ");

            switch (toDo[0]) {
                case "swap":
                    int index1 = Integer.parseInt(toDo[1]);
                    int index2 = Integer.parseInt(toDo[2]);

                    int buffer = numbers[index1];
                    numbers[index1] = numbers[index2];
                    numbers[index2] = buffer;
                    break;

                case "multiply":
                    index1 = Integer.parseInt(toDo[1]);
                    index2 = Integer.parseInt(toDo[2]);

                    int buff = numbers[index1] * numbers[index2];
                    numbers[index1] = buff;
                    break;

                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] - 1;
                    }

                    break;
            }

            commands = scanner.nextLine();
        }

        for (int i = 0; i < numbers.length; i++) {

            if (i == numbers.length - 1) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }
    }
}
