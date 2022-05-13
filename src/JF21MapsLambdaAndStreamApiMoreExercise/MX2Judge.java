package JF21MapsLambdaAndStreamApiMoreExercise;

/*
You know the Judge system, right?! Your job is to create a program similar to the Judge system.
You will receive several input lines in the following format:
"{username} -> {contest} -> {points}"
The constestName and username are strings, the given points will be an integer number. You need to keep track of every contest and individual statistics of every user. You should check if such a contest already exists, and if not, add it, otherwise, check if the current user is participating in the contest, if he is participating take the higher score, otherwise, just add it.
Also, you need to keep individual statistics for each user - the total points of all contests.
You should end your program when you receive the command "no more time". At that point, you should print each contest in order of input, for each contest print the participants ordered by points in descending order, then ordered by name in ascending order. After that, you should print individual statistics for every participant ordered by total points in descending order, and then by alphabetical order.
Input / Constraints
•	The input comes in the form of commands in the format specified above.
•	Username and contest name always will be one word.
•	Points will be an integer in the range [0, 1000].
•	There will be no invalid input lines.
•	If all sorting criteria fail, the order should be by order of input.
•	The input ends when you receive the command "no more time".
Output
•	The output format for the contests is:
"{constestName}: {participants.Count} participants
{position}. {username} <::> {points}"
•	After you print all contests, print the individual statistics for every participant.
•	The output format is:
"Individual standings:
{position}. {username} -> {totalPoints}"
 */

import java.util.*;

public class MX2Judge {

    public static void main(String[] args) {

        Map<String, List<String>> gameContest = new LinkedHashMap();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("no more time")) {
            String[] commands = input.split(" -> ");
            String name = commands[0];
            String contest = commands[1];
            String points = commands[2];

            //проверяваме дали контеста го има, и ако го няма го добавяме
            //ако юзъра го няма в контеста, го добавяме

            gameContest.putIfAbsent(contest, new ArrayList<>());

            int indexOfRepeated = gameContest.get(contest).indexOf(name);

            if (indexOfRepeated >= 0) {
                int currentPoints = Integer.parseInt(gameContest.get(contest).get(indexOfRepeated + 1));
                int maxPoints = Math.max(currentPoints, Integer.parseInt(points));
                gameContest.get(contest).set(indexOfRepeated + 1, (maxPoints + ""));
            } else {
                gameContest.get(contest).add(name);
                gameContest.get(contest).add(points);
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> personTotalPoints = new TreeMap<>();

        for (Map.Entry<String, List<String>> entry : gameContest.entrySet()) {
            Map<String, Integer> personPoints = new TreeMap<>();

            int numberOfParticipants = (entry.getValue().size()) / 2;
            System.out.printf("%s: %d participants%n", entry.getKey(), numberOfParticipants);

            //ordered by points in descending order
            //than ordered by name in ascending
            List<String> buff = entry.getValue();

            for (int i = 0; i < buff.size(); i += 2) {
                String currentParticipant = buff.get(i);
                String points = buff.get(i + 1);

                personPoints.putIfAbsent(currentParticipant, 0);
                personPoints.put(currentParticipant, personPoints.get(currentParticipant) + Integer.parseInt(points));

                personTotalPoints.putIfAbsent(currentParticipant, 0);
                personTotalPoints.put(currentParticipant, personTotalPoints.get(currentParticipant) + Integer.parseInt(points));
            }

            LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
            //Use Comparator.reverseOrder() for reverse ordering
            personPoints.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

            int counter = 0;

            for (Map.Entry<String, Integer> stringIntegerEntry : reverseSortedMap.entrySet()) {
                counter++;
                System.out.printf("%d. %s <::> %s%n", counter, stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            }
        }

        System.out.println("Individual standings:");

        LinkedHashMap<String, Integer> reverseSortedMap2 = new LinkedHashMap<>();
        personTotalPoints.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap2.put(x.getKey(), x.getValue()));

        int count = 0;

        for (Map.Entry<String, Integer> entry : reverseSortedMap2.entrySet()) {
            count++;
            System.out.printf("%d. %s -> %d%n", count, entry.getKey(), entry.getValue());
        }
    }
}