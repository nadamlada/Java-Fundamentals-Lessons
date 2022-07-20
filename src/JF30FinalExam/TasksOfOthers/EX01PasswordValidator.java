package JF30FinalExam.TasksOfOthers;

import java.util.Scanner;

public class EX01PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();
        StringBuilder password = new StringBuilder(pass);

        while (!pass.equals("Complete")) {
            String[] commands = pass.split(" ");

            switch (commands[0]) {
                case "Make":
                    int index = Integer.parseInt(commands[2]);
                    String firstPart = password.substring(0, index);
                    String secondPart = password.substring(index + 1);
                    int currentChar = password.toString().charAt(index);
                    password.setLength(0);
                    password.append(firstPart);

                    String middle = "";

                    if (commands[1].equals("Upper")) {
                        char foo = (char) Character.toUpperCase(currentChar);
                        middle = foo + "";
                    } else {
                        char foo = (char) Character.toLowerCase(currentChar);
                        middle = foo + "";
                    }

                    password.append(middle);
                    password.append(secondPart);
                    System.out.println(password);
                    break;

                case "Insert":
                    index = Integer.parseInt(commands[1]);
                    String asChar = commands[2];

                    if (ValidIndex(index, password)) {
                        password.insert(index, asChar);
                        System.out.println(password);
                    }

                    break;

                case "Replace":
                    asChar = commands[1];
                    int value = Integer.parseInt(commands[2]);
                    int oldChar = asChar.charAt(0);
                    char newSymbol = (char) (oldChar + value);

                    String buff = password.toString().replace(asChar.charAt(0), newSymbol);
                    password = new StringBuilder(buff);
                    System.out.println(password);
                    break;

                case "Validation":

                    if (password.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    }

                    if (!lettersAndDigitsAndUnderscore(password)) {
                        System.out.println("Password must consist only of letters, digits and _!");
                    }

                    if (!digit(password, 'A', 'Z')) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }

                    if (!digit(password, 'a', 'z')) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }

                    if (!digit(password, '0', '9')) {
                        System.out.println("Password must consist at least one digit!");
                    }

                    break;
            }

            pass = scanner.nextLine();
        }
    }

    private static boolean ValidIndex(int index, StringBuilder passNew) {
        boolean isValid = true;

        if (index > 0 && index < passNew.length()) {
            return true;
        }

        return false;
    }

    public static boolean digit(StringBuilder password, char firstChar, char secondChar) {
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            char current = password.charAt(i);

            if ((firstChar <= current && current <= secondChar)) {
                count++;
            }
        }

        return count >= 1;
    }

    public static boolean lettersAndDigitsAndUnderscore(StringBuilder password) {

        for (int i = 0; i < password.length(); i++) {

            if (!Character.isLetterOrDigit(password.charAt(i))) {

                if (!(password.charAt(i) == '_')) {
                    return false;
                }
            }
        }

        return true;
    }
}