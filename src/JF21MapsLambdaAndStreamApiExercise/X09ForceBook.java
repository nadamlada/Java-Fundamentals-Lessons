package JF21MapsLambdaAndStreamApiExercise;

/*
The force users are struggling to remember which side is the different forceUsers from because they switch them too often. So you are tasked to create a web application to manage their profiles.
You will receive several input lines in one of the following formats:
"{force_side} | {force_user}"
"{force_user} -> {force_side}"
The "force_user" and "force_side" are strings, containing any character.
If you receive "force_side | force_user":
•	If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
•	Only if there is no such force user in any force side -> add the force user to the corresponding side.
•	If there is such force user already -> skip the command and continue to the next operation.
If you receive a "force_user -> force_side":
•	If there is such force user already -> change their side.
•	If there is no such force user in any force side -> add the force user to the corresponding force side.
•	If there is no such force user and no such force side -> create new force side and add the force user to the corresponding side.
•	Then you should print on the console: "{force_user} joins the {force_side} side!".
You should end your program when you receive the command "Lumpawaroo". At that point, you should print each force side. For each side, print the force users.
In case there are no force users on a side, you shouldn't print the side information.
Input / Constraints
•	The input comes in the form of commands in one of the formats specified above.
•	The input ends when you receive the command "Lumpawaroo".
Output
•	As output for each force side, you must print all the force users.
•	The output format is:
"Side: {forceSide}, Members: {forceUsers.Count}
! {forceUser}
! {forceUser}
! {forceUser}"
•	In case there are NO forceUsers, don't print this side.
 */

import java.util.*;

public class X09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // side is key

        Map<String, List<String>> book = new LinkedHashMap<>();

        String input = scanner.nextLine();
        String side = "";
        String user = "";

        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" | ")) {
                String[] one = input.split(" \\| ");
                side = one[0];
                user = one[1];

                book.putIfAbsent(side, new ArrayList<>());

                boolean userExists = isUserExists(book, user);

                if (!isUserExists(book, user)) {
                    book.get(side).add(user);
                }

            } else if (input.contains(" -> ")) {
                String[] two = input.split(" -> ");
                side = two[1];
                user = two[0];

                if (isUserExists(book, user)) {
                    //премахваме юзъра от текущата му страна
                    for (Map.Entry<String, List<String>> entry : book.entrySet()) {
                        List<String> person = entry.getValue();
                        person.remove(user);
                    }
                }

                //проверяваме дали я има страната
                // създаваме, ако я няма

                book.putIfAbsent(side, new ArrayList<>());
                book.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : book.entrySet()) {
            List<String> usersList = entry.getValue();
            int memberscount = usersList.size();

            if (!usersList.isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), memberscount);
            }

            for (String s : usersList) {
                System.out.printf("! %s%n", s);
            }
        }
    }

    private static boolean isUserExists(Map<String, List<String>> book, String user) {
        //проверка дали юзъра го има
        boolean userExists = false;

        for (Map.Entry<String, List<String>> entry : book.entrySet()) {
            List<String> whereItIsNow = entry.getValue();

            if (whereItIsNow.contains(user)) {
                userExists = true;
            }
        }

        return userExists;
    }
}

/*
test 10 expected
e | b
e | a
f | d
f | c
f | e
g | e
Lumpawaroo

 */