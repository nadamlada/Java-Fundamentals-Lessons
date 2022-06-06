package JF28ExamExersices;
/*
During World War 2, you are a mathematician who has joined the cryptography team to decipher the enemy's enigma code.
Your job is to create a program to crack the codes.
On the first line of the input, you will receive the encrypted message. After that, until the "Decode" command is given,
you will be receiving strings with instructions for different operations that need to be performed upon the concealed
message to interpret it and reveal its true content. There are several types of instructions, split by '|'
•	"Move {number of letters}":
o	Moves the first n letters to the back of the string
•	"Insert {index} {value}":
o	Inserts the given value before the given index in the string
•	"ChangeAll {substring} {replacement}":
o	Changes all occurrences of the given substring with the replacement text
Input / Constraints
•	On the first line, you will receive a string with a message.
•	On the following lines, you will be receiving commands, split by '|' .
Output
•	After the "Decode" command is received, print this message:
"The decrypted message is: {message}"

 */

import java.util.Scanner;

public class EX01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encrypted = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] commands = input.split("\\|");
            switch (commands[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commands[1]);
                    encrypted.append(encrypted.substring(0, numberOfLetters));
                    encrypted.delete(0, numberOfLetters);
                    break;

                case "Insert":
                    int index = Integer.parseInt(commands[1]);
                    String value = commands[2];
                    encrypted.insert(index, value);
                    break;

                case "ChangeAll":
                    String substring = commands[1];
                    String replacement = commands[2];
                    String buffer = encrypted.toString().replace(substring, replacement);
                    encrypted = new StringBuilder(buffer);
                    break;

            }

            input = scanner.nextLine();

        }
        System.out.print("The decrypted message is: ");
        System.out.println(encrypted);

    }
}
