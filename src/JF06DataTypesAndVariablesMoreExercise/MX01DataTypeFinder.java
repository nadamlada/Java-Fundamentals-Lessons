package JF06DataTypesAndVariablesMoreExercise;

/*
You will receive input until you receive "END". Find what data type is the input. Possible data types are:
•	Integer
•	Floating point
•	Characters
•	Boolean
•	Strings
Print the result in the following format: "{input} is {data type} type".
You will receive input until you receive "END". Find what data type is the input. Possible data types are:
•	Integer
•	Floating point
•	Characters
•	Boolean
•	Strings
Print the result in the following format: "{input} is {data type} type".

 */

import java.util.Scanner;

public class MX01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            int length = input.length();
            char charInput = input.charAt(0);
            char charInputLower = Character.toLowerCase(charInput);

            String lowerCaseInput = input.toLowerCase();

            int counterDots = 0;
            int counterNums = 0;

            for (int i = 0; i < length; i++) {
                char allSymbols = input.charAt(i);
                if (allSymbols == '.') {
                    counterDots++;
                } else if ('0' <= allSymbols && allSymbols <= '9') {                  //('0' <= allSymbols && allSymbols <= '9')
                    counterNums++;
                } else if (i == 0 && allSymbols == '-') {
                    counterNums++;
                }
            }

            if (counterNums == length) {
                System.out.printf("%s is integer type%n", input);
            } else if ((counterDots == 1) && (counterNums == length - 1)) {
                System.out.printf("%s is floating point type%n", input);
            } else if (lowerCaseInput.equals("true") || lowerCaseInput.equals("false")) {
                System.out.printf("%s is boolean type%n", input);
            } else if (length == 1) {
                System.out.printf("%s is character type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }

            input = scanner.nextLine();
        }
    }
}