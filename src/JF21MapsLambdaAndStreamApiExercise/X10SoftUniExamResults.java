package JF21MapsLambdaAndStreamApiExercise;

/*
Judge statistics on the last Programing Fundamentals exam were not working correctly, so you have the task to take all the submissions and analyze them properly. You should collect all the submissions and print the final results and statistics about each language that the participants submitted their solutions in.
You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive "exam finished". You should store each username and their submissions and points.
You can receive a command to ban a user for cheating in the following format: "{username}-banned". In that case, you should remove the user from the contest but preserve his submissions in the total count of submissions for each language.
After receiving "exam finished", print each of the participants in the following format:
"Results:
{username} | {points}
{username2} | {points}
…
{usernameN} | {points}"
After that, print each language, used in the exam in the following format:
"Submissions:
{language1} - {submissions_count}
{language2} - {submissions_count}
…
{language3} - {submissions_count}"
Input / Constraints
Until you receive "exam finished", you will be receiving participant submissions in the following format: "{username}-{language}-{points}"
You can receive a ban command -> "{username}-banned".
The points of the participant will always be a valid integer in the range [0-100].
Output
•	Print the exam results for each participant.
•	After that, print each language in the format shown above.
•	Allowed working time / memory: 100ms / 16MB.
 */

import java.util.*;

public class X10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int numberOfUsers = 0;

        Map<String, List<String>> languageBook = new LinkedHashMap<>();
        Map<String, Integer> nameBook = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] commands = input.split("-");
            String user = commands[0];
            String language = commands[1];

            switch (commands.length) {
                case 3:
                    String points = commands[2];
                    int pointsInt = Integer.parseInt(points);

                    languageBook.putIfAbsent(language, new ArrayList<>());
                    languageBook.get(language).add(user);
                    languageBook.get(language).add(points);

                    nameBook.putIfAbsent(user, 0);
                    int maxPoints = Math.max(pointsInt, nameBook.get(user));

                    nameBook.put(user, maxPoints);
                    int currentPoints = nameBook.get(user);
                    break;

                //banned
                case 2:
                    nameBook.remove(user);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");

        for (Map.Entry<String, Integer> entry : nameBook.entrySet()) {
            System.out.printf("%s | %s%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Submissions:");

        for (Map.Entry<String, List<String>> entry : languageBook.entrySet()) {
            numberOfUsers = entry.getValue().size() / 2;
            System.out.printf("%s - %d%n", entry.getKey(), numberOfUsers);
        }
    }
}