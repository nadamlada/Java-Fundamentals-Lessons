package JF14ListsExercise;

/*
Write a program that keeps track of the guests that are going to a house party.
On the first input line, you are going to receive how many commands you are going to have. On the next lines you are going to receive some of the following inputs:
•	"{name} is going!"
•	"{name} is not going!"
If you receive the first type of input, you have to add the person if he/she is not on the list. (If he/she is in the list print on the console: "{name} is already in the list!"). If you receive the second type of input, you have to remove the person if he/she is on the list. (If not print: "{name} is not in the list!"). At the end print all guests.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        List<String> output = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            String line = scanner.nextLine();
            String[] commands = line.split(" ");
            String name = commands[0];

            //if line.contains("going")
            if (commands[2].equals("going!")) {
                //ако не е в листата я добави
                //ако е в листата
                if (output.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    output.add(name);
                }

            } else if (commands[2].equals("not")) {
                //ако е в листата я махни от листата
                if (output.contains(name)) {
                    output.remove(name);
                    //ако не е в листата принтирай
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }

        for (String s : output) {
            System.out.println(s + " ");
        }
    }
}