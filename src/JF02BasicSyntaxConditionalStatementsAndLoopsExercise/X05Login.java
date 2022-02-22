package JF02BasicSyntaxConditionalStatementsAndLoopsExercise;

/*
You will be given a string representing a username. The password will be that username reversed.
Until you receive the correct password print on the console "Incorrect password. Try again.".
When you receive the correct password print "User {username} logged in."
However on the fourth try if the password is still not correct print "User {username} blocked!" and end the program.

https://youtu.be/VC6ZycPsUEU?t=6666
 */

import java.util.Scanner;

public class X05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String pass = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            pass = pass + username.charAt(i);                 //pass += username.chatAt(i)
        }

        String input = scanner.nextLine();
        int count = 0;

        while (true) {
            count++;
            if (input.equals(pass)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {

                if (count == 4) {
                    System.out.printf("User %s blocked!", username);
                    break;
                }

                System.out.println("Incorrect password. Try again.");
            }
            input = scanner.nextLine();
        }
    }
}
