package JF15MidExamExercises.EX01ProgrammingFundamentalsMidExamRetake;

 /*
Write a program that recreates the Memory game.
On the first line, you will receive a sequence of elements. Each element in the sequence will have a twin. Until the player receives "end" from the console, you will receive strings with two integers separated by a space, representing the indexes of elements in the sequence.
If the player tries to cheat and enters two equal indexes or indexes which are out of bounds of the sequence, you should add two matching elements at the middle of the sequence in the following format:
"-{number of moves until now}a"
Then print this message on the console:
"Invalid input! Adding additional elements to the board"
Input
•	On the first line, you will receive a sequence of elements
•	On the following lines, you will receive integers until the command "end"
Output
•	Every time the player hit two matching elements, you should remove them from the sequence and print on the console the following message:
"Congrats! You have found matching elements - ${element}!"
•	If the player hit two different elements, you should print on the console the following message:
"Try again!"
•	If the player hit all matching elements before he receives "end" from the console, you should print on the console the following message:
"You have won in {number of moves until now} turns!"
•	If the player receives "end" before he hits all matching elements, you should print on the console the following message:
"Sorry you lose :(
{the current sequence's state}"
Constraints
•	All elements in the sequence will always have a matching element.
 */

import java.util.*;
import java.util.stream.Collectors;

public class EX03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> numbers = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        int numbersOfmoves = 0;
        String commands = scanner.nextLine();

        while (!commands.equals("end")) {
            numbersOfmoves++;
            String[] indexes = commands.split(" ");
            int index1 = Integer.parseInt(indexes[0]);
            int index2 = Integer.parseInt(indexes[1]);

            if ((index1 == index2) ||
                    (index1 < 0 || index1 >= numbers.size()) ||
                    (index2 < 0 || index2 >= numbers.size())) {
                //add two matching in the middle

                String forInsert = "-" + numbersOfmoves + "a";
                int middleOfnumbers = numbers.size() / 2;
                numbers.add(middleOfnumbers, forInsert);
                numbers.add(middleOfnumbers, forInsert);

                System.out.println("Invalid input! Adding additional elements to the board");

            } else {
                int smallerIndex = Math.min(index1, index2);
                int biggerIndex = Math.max(index1, index2);

                String element1 = numbers.get(index1);
                String element2 = numbers.get(index2);

                if (element1.equals(element2)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", numbers.get(smallerIndex));
                    numbers.remove(biggerIndex);
                    numbers.remove(smallerIndex);
                } else {
                    System.out.println("Try again!");
                }
            }

            commands = scanner.nextLine();

            if (numbers.size() == 0) {
                System.out.printf("You have won in %d turns!%n", numbersOfmoves);

                break;
            }
        }

        List<String> originalListCopy = new ArrayList<>();

        for (String number : numbers) {
            originalListCopy.add(number);
        }

        for (int i = 1; i < numbers.size(); i++) {
            Collections.sort(numbers);
            String nextEl = numbers.get(i - 1);
            String prevEl = numbers.get(i);

            if (nextEl.equals(prevEl)) {
                //има еднакви
                System.out.println("Sorry you lose :(");
                String printt = originalListCopy.toString().replace("[", "").replace("]", "").replaceAll(",", "");
                System.out.println(printt);
                break;
            }
        }
    }
}