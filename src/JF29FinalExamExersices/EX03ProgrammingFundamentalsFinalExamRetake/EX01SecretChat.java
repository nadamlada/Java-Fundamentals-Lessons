package JF29FinalExamExersices.EX03ProgrammingFundamentalsFinalExamRetake;

/*
You have plenty of free time, so you decide to write a program that conceals and reveals your received messages. Go ahead and type it in!
On the first line of the input, you will receive the concealed message. After that, until the "Reveal" command is given, you will receive strings with instructions for different operations that need to be performed upon the concealed message to interpret it and reveal its actual content. There are several types of instructions, split by ":|:"
•	"InsertSpace:|:{index}":
o	Inserts a single space at the given index. The given index will always be valid.
•	"Reverse:|:{substring}":
o	If the message contains the given substring, cut it out, reverse it and add it at the end of the message.
o	If not, print "error".
o	This operation should replace only the first occurrence of the given substring if there are two or more occurrences.
•	"ChangeAll:|:{substring}:|:{replacement}":
o	Changes all occurrences of the given substring with the replacement text.
Input / Constraints
•	On the first line, you will receive a string with a message.
•	On the following lines, you will be receiving commands, split by ":|:".
Output
•	After each set of instructions, print the resulting string.
•	After the "Reveal" command is received, print this message:
"You have a new text message: {message}"

 */

import java.util.Scanner;

public class EX01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] commands = input.split(":\\|:");

            switch (commands[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    // Може би е интекс плюс едно
                    password.insert(index, " ");
                    System.out.println(password);
                    break;

                case "Reverse":
                    StringBuilder subst = new StringBuilder(commands[1]);
                    index = password.indexOf(subst.toString());

                    if (index == -1) {
                        System.out.println("error");
                    } else {
                        int endIndex = index + subst.length();
                        password.delete(index, endIndex);
                        password.append(subst.reverse());
                        System.out.println(password);
                    }

                    break;

                case "ChangeAll":
                    // замени събстринга, докато се среща
                    String newSubstring = commands[1];
                    String replacement = commands[2];
                    index = password.indexOf(newSubstring);

                    while (index != -1) {
                        password.delete(index, index + newSubstring.length());
                        password.insert(index, replacement);
                        index = password.indexOf(newSubstring);
                    }

                    System.out.println(password);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", password);
    }
}
