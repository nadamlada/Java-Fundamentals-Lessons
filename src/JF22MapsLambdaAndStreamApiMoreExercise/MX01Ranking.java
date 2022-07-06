package JF22MapsLambdaAndStreamApiMoreExercise;

/*
Here comes the final and the most interesting part - the Final ranking of the candidate-interns. The final ranking is determined by the points of the interview tasks and from the exams in SoftUni. Here is your final task. You will receive some lines of input in the format "{contest}:{password for contest}" until you receive "end of contests". Save that data because you will need it later. After that, you will receive another type of inputs in the format "{contest}=>{password}=>{username}=>{points}" until you receive "end of submissions". Here is what you need to do:
•	Check if the contest is valid (if you received it in the first type of input);
•	Check if the password is correct for the given contest;
•	Save the user with the contest they take part in (a user can take part in many contests) and the points the user has in the given contest. If you receive the same contest and the same user, update the points only if the new ones are more than the older ones.
In the end, you have to print the info for the user with the most points in the format "Best candidate is {user} with total {total points} points.". After that print all students ordered by their names. For each user print each contest with the points in descending order. See the examples.
Input
•	Strings in format "{contest}:{password for contest}" until the "end of contests" command. There will be no case with two equal contests.
•	Strings in format "{contest}=>{password}=>{username}=>{points}" until the "end of submissions" command.
•	There will be no case with 2 or more users with the same total points!
Output
•	On the first line print the best user in a format:
"Best candidate is {user} with total {total points} points.".
•	Then print all students ordered as mentioned above in format:
"{user1 name}
#  {contest1} -> {points}
#  {contest2} -> {points}"
Constraints
•	The strings may contain any ASCII character except (:, =, >).
•	The numbers will be in the range [0 - 10000].
•	The second input is always valid.
 */

import java.util.*;

public class MX01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestsAndPass = new HashMap<>();
        Map<String, Integer> userConcatCoursePoints = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            //"{contest}:{password for contest}"

            String[] buff = input.split(":");
            String currentContest = buff[0];
            String currentPass = buff[1];

            contestsAndPass.put(currentContest, currentPass);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            //"{contest}=>{password}=>{username}=>{points}"
            String[] buffer = input.split("=>");
            String course = buffer[0];
            String password = buffer[1];
            String user = buffer[2];
            int points = Integer.parseInt(buffer[3]);

            //        Map<String, String> contestsPass = new HashMap<>();
            //         Map<String, Integer> userConcatCoursePoints = new HashMap<>();

            if (contestsAndPass.containsKey(course)) {

                if (contestsAndPass.get(course).equals(password)) {
                    String currentUserConcatCourse = (user + "+" + course);

                    userConcatCoursePoints.putIfAbsent(currentUserConcatCourse, 0);
                    userConcatCoursePoints.put(currentUserConcatCourse, Math.max(userConcatCoursePoints.get(currentUserConcatCourse), points));
                }
            }

            input = scanner.nextLine();
        }

        //users concatenated course -> points. сортирни по точки

        Map<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        userConcatCoursePoints.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        //users -> all points. най-много точки са първи
        Map<String, Integer> users = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : reverseSortedMap.entrySet()) {
            int indexOfConcat = entry.getKey().indexOf("+");
            String currentName = entry.getKey().substring(0, indexOfConcat);

            users.putIfAbsent(currentName, 0);
            users.put(currentName, users.get(currentName) + entry.getValue());
        }

        Map<String, Integer> reverseSortedMap2 = new LinkedHashMap<>();
        users.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap2.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : reverseSortedMap2.entrySet()) {
            System.out.printf("Best candidate is %s with total %d points.%n", entry.getKey(), entry.getValue());
            break;
        }

        System.out.printf("Ranking:%n");
        String previousUser = "";
        String currentUser = "";

        for (Map.Entry<String, Integer> entry : reverseSortedMap.entrySet()) {
            int indexOfConcat = entry.getKey().indexOf("+");
            currentUser = entry.getKey().substring(0, indexOfConcat);

            if (!previousUser.equals(currentUser)) {

                System.out.printf("%s%n", currentUser);
                previousUser = currentUser;
            }

            System.out.printf("#  %s -> %d%n", entry.getKey().substring(indexOfConcat + 1), entry.getValue());
        }
    }
}