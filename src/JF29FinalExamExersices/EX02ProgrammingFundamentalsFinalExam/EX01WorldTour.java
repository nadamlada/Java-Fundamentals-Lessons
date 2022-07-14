package JF29FinalExamExersices.EX02ProgrammingFundamentalsFinalExam;

/*
You are a world traveler, and your next goal is to make a world tour. To do that, you have to plan out everything first.
To start with, you would like to plan out all of your stops where you will have a break.
On the first line, you will be given a string containing all of your stops. Until you receive the command "Travel",
you will be given some commands to manipulate that initial string. The commands can be:
•	"Add Stop:{index}:{string}":
o	Insert the given string at that index only if the index is valid
•	"Remove Stop:{start_index}:{end_index}":
o	Remove the elements of the string from the starting index to the end index (inclusive) if both indices are valid
•	"Switch:{old_string}:{new_string}":
o	If the old string is in the initial string, replace it with the new one (all occurrences)
Note: After each command, print the current state of the string
After the "Travel" command, print the following: "Ready for world tour! Planned stops: {string}"
Input / Constraints
•	JavaScript: you will receive a list of strings
•	An index is valid if it is between the first and the last element index (inclusive) in the sequence.
Output
•	Print the proper output messages in the proper cases as described in the problem description
 */

import java.util.Scanner;

public class EX01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder route = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] commands = command.split(":");

            switch (commands[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);

                    if (isValidIndex(route, index)) {
                        String newString = commands[2];
                        route.insert(index, newString);
                    }

                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);

                    if (isValidIndex(route, startIndex)) {

                        if (isValidIndex(route, endIndex)) {
                            route.delete(startIndex, endIndex + 1);
                        }
                    }

                    break;

                case "Switch":
                    String oldString = commands[1];
                    String newString = commands[2];

                    // когато ползваме риплейс няма нужда да проверяваме дали го има или не, то го риплейсва на всякъде
                    // само, ако го има. работи със стирнгове. по-бързо е от проверка с -1

                    String printThis = route.toString().replace(oldString, newString);
                    route = new StringBuilder(printThis);

//                    index = route.indexOf(oldString);
//                    while (index != -1) {
//                        route.delete(index, index + oldString.length());
//                        route.insert(index, newString);
//                        index = route.indexOf(oldString);
//                    }

                    break;

            }

            System.out.println(route);
            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", route);
    }

    public static boolean isValidIndex(StringBuilder route, int index) {
        boolean isValid = false;

        if (index >= 0 && index <= (route.length() - 1)) {
            isValid = true;
        }

        return isValid;
    }
}