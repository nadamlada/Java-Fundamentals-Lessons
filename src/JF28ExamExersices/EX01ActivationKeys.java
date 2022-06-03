package JF28ExamExersices;

/*
You are about to make some good money, but first, you need to think of a way to verify who paid for your product and who didn't. You have decided to let people use the software for a free trial period and then require an activation key to continue using the product. Before you can cash out, the last step is to design a program that creates unique activation keys for each user. So, waste no more time and start typing!
The first line of the input will be your raw activation key. It will consist of letters and numbers only.
After that, until the "Generate" command is given, you will be receiving strings with instructions for different operations that need to be performed upon the raw activation key.
There are several types of instructions, split by ">>>":
•	"Contains>>>{substring}":
o	If the raw activation key contains the given substring, prints: "{raw activation key} contains {substring}".
o	Otherwise, prints: "Substring not found!"
•	"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}":
o	Changes the substring between the given indices (the end index is exclusive) to upper or lower case and then prints the activation key.
o	All given indexes will be valid.
•	"Slice>>>{startIndex}>>>{endIndex}":
o	Deletes the characters between the start and end indices (the end index is exclusive) and prints the activation key.
o	Both indices will be valid.
Input
•	The first line of the input will be a string consisting of letters and numbers only.
•	After the first line, until the "Generate" command is given, you will be receiving strings.
Output
•	After the "Generate" command is received, print:
o	"Your activation key is: {activation key}"
 */

import java.util.Scanner;

public class EX01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        boolean print = false;
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] inputs = input.split(">>>");
            switch (inputs[0]) {
                case "Contains":
                    String substring = inputs[1];
                    if (password.toString().contains(substring)) {
                        //"{raw activation key} contains {substring}"
                        System.out.printf("%s contains %s%n", password, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    print = false;
                    break;

                case "Flip":
                    String command = inputs[1];
                    int startIndex = Integer.parseInt(inputs[2]);
                    int endIndex = Integer.parseInt(inputs[3]);
                    if (command.equals("Upper")) {
                        password.replace(startIndex, endIndex, password.substring(startIndex, endIndex).toUpperCase());
                    } else {
                        password.replace(startIndex, endIndex, password.substring(startIndex, endIndex).toLowerCase());
                    }
                    print = true;
                    break;

                case "Slice":
                    startIndex = Integer.parseInt(inputs[1]);
                    endIndex = Integer.parseInt(inputs[2]);
                    password.delete(startIndex, endIndex);
                    print = true;
                    break;
            }
            if (print) {
                System.out.println(password);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", password);
    }
}
