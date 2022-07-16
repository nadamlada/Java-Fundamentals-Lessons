package JF29FinalExamExersices.EX04ProgrammingFundamentalsFinalExam;

/*
Yet again, you have forgotten your password. Naturally, it's not the first time this has happened. Actually, you got so tired of it that you decided to help yourself with an intelligent solution.
Write a password reset program that performs a series of commands upon a predefined string. First, you will receive a string, and afterward, until the command "Done" is given, you will be receiving strings with commands split by a single space. The commands will be the following:
•	"TakeOdd"
o	 Takes only the characters at odd indices and concatenates them to obtain the new raw password and then prints it.
•	"Cut {index} {length}"
o	Gets the substring with the given length starting from the given index from the password and removes its first occurrence, then prints the password on the console.
o	The given index and the length will always be valid.
•	"Substitute {substring} {substitute}"
o	If the raw password contains the given substring, replaces all of its occurrences with the substitute text given and prints the result.
o	If it doesn't, prints "Nothing to replace!".
Input
•	You will be receiving strings until the "Done" command is given.
Output
•	After the "Done" command is received, print:
o	"Your password is: {password}"
Constraints
•	The indexes from the "Cut {index} {length}" command will always be valid.
 */

import java.util.Scanner;

public class EX01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();

                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword.append(password.charAt(i));
                    }

                    password = newPassword;
                    System.out.println(password);
                    break;

                case "Cut":
                    int index = Integer.parseInt(commands[1]);
                    int length = Integer.parseInt(commands[2]);
                    String deleteThis = password.substring(index, index + length);
                    int indexForRemove = password.indexOf(deleteThis);
                    password.delete(indexForRemove, indexForRemove + length);

                    System.out.println(password);
                    break;

                case "Substitute":
                    String substring = commands[1];
                    String substitute = commands[2];
                    int indexForSubstitute = password.indexOf(substring);

                    if (indexForSubstitute == -1) {
                        System.out.println("Nothing to replace!");
                    } else {

                        while (indexForSubstitute != -1) {
                            password.replace(indexForSubstitute, indexForSubstitute + substring.length(), substitute);
                            indexForSubstitute = password.indexOf(substring);
                        }

                        System.out.println(password);
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.print("Your password is: ");
        System.out.println(password);
    }
}
