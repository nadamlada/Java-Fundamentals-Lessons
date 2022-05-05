package JF21MapsLambdaAndStreamApiExercise;

/*
SoftUni just got a new parking lot. It's so fancy, it even has online parking validation. Except, the online service doesn't work. It can only receive users' data but doesn't know what to do with it. Good thing you're on the dev team and know how to fix it, right?
Write a program, which validates parking for an online service. Users can register to park and unregister to leave.
The program receives 2 commands:
•	"register {username} {licensePlateNumber}":
o	The system only supports one car per user at the moment, so if a user tries to register another license plate, using the same username, the system should print:
"ERROR: already registered with plate number {licensePlateNumber}"
o	If the aforementioned checks pass successfully, the plate can be registered, so the
the system should print:
 "{username} registered {licensePlateNumber} successfully"
•	"unregister {username}":
o	If the user is not present in the database, the system should print:
"ERROR: user {username} not found"
o	If the aforementioned check passes successfully, the system should print:
"{username} unregistered successfully"
After you execute all of the commands, print all the currently registered users and their license plates in the format:
•	"{username} => {licensePlateNumber}"
Input
•	First line: n - number of commands – integer.
•	Next n lines: commands in one of two possible formats:
o	Register: "register {username} {licensePlateNumber}"
o	Unregister: "unregister {username}"
The input will always be valid and you do not need to check it explicitly.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class X05SoftUniParking {
    public static void main(String[] args) {

        Map<String, String> book = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String user = input[1];
            String command = input[0];

            if (command.equals("register")) {
                String plate = input[2];

                if (book.containsKey(user)) {
                    System.out.print("ERROR: already registered with plate number ");
                    System.out.println(plate);
                } else {
                    book.put(user, plate);
                    System.out.printf("%s registered %s successfully%n", user, plate);
                }
                //unregister
            } else {

                if (!book.containsKey(user)) {
                    System.out.printf("ERROR: user %s not found%n", user);
                } else {
                    book.remove(user);
                    System.out.printf("%s unregistered successfully%n", user);
                }
            }
        }

        for (Map.Entry<String, String> entry : book.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}