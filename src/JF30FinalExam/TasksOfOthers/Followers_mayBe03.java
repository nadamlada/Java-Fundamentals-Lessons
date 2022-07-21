package JF30FinalExam.TasksOfOthers;

/*
Now that Pesho has successfully created an account, he wants to connect with other users and gain as many followers, likes and comments as possible.

Create a program that keeps information about Pesho's followers, likes and comments. Keep a record of the followers, each with the likes and comments Pesho has received from them.

You will be receiving lines with commands until you receive the "Log out" command.  There are four possible commands:

"New follower: {username}":
Add the username, to your records (with 0 likes and 0 comments). If person with the given username already exists ignore the line.
"Like: {username}: {count}":
If the username doesn't exist, add it to your records with the given count of likes.
If the username exist, increase the count of likes with the given count.
"Comment: {username}":
If the username doesn't exist, add it to your records with 1 comment.
If the username exists, increase the count of commens with 1.
"Blocked: {username}":
Delete all records of the given username. If it doesn’t exist, print:
 "{Username} doesn't exist."

In the end, you have to print the count of followers, each follower with his/her likes and comments (the sum of likes and comments) sorted in descending order by the likes and then by their username in ascending order in the following format:

{count} followers

{username}: {likes+comments}

{username}: {likes+comments}

...

Input
You will be receiving lines until you receive the "Log out" command.
The input will always be valid.
Output
Print the users with their likes in the format described above.
Examples
 */

import java.util.*;

public class Followers_mayBe03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, int[]> map = new HashMap<>();

        while (!input.equals("Log out")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "New":
                    String username = commands[2];

                    if (!(map.containsKey(username))) {
                        map.put(username, new int[2]);
                    }

                    break;

                case "Like:":
                    String buffUsername = commands[1];
                    username = buffUsername.substring(0, buffUsername.length() - 1);
                    int count = Integer.parseInt(commands[2]);
                    map.putIfAbsent(username, new int[2]);
                    map.get(username)[0] += count;

                    break;

                case "Comment:":
                    username = commands[1];

                    if (map.containsKey(username)) {
                        map.get(username)[1] += 1;
                    } else {
                        map.put(username, new int[2]);
                        map.get(username)[1] = 1;
                    }

                    break;

                case "Blocked:":
                    username = commands[1];

                    if (map.containsKey(username)) {
                        map.remove(username);
                    } else {
                        System.out.printf("%s doesn't exist.", username);
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> usersLikes = new HashMap<>();
        Map<String, Integer> userLikedSumComments = new TreeMap<>();

        System.out.printf("%d followers%n", map.size());

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            usersLikes.put(entry.getKey(), entry.getValue()[0]);
            userLikedSumComments.put(entry.getKey(), entry.getValue()[0] + entry.getValue()[1]);
        }

        Map<String, Integer> reverseusersLikes = new LinkedHashMap<>();

        usersLikes.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseusersLikes.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : reverseusersLikes.entrySet()) {

            for (Map.Entry<String, Integer> entry2 : userLikedSumComments.entrySet()) {

                if(entry.getKey().equals(entry2.getKey())){
                System.out.printf("%s: %d%n", entry.getKey(),entry2.getValue());}
            }
        }

//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry
//                .<String, int[]>comparingByValue(Comparator.comparingInt(l -> l[0]))
//                .reversed()
//                .thenComparing(Map.Entry.comparingByKey()));
//
//        for (Map.Entry<String, int[]> entry : map.entrySet()) {
//            System.out.printf("%s: %d%n", entry.getKey(),entry.getValue()[0]+entry.getValue()[1]);
//        }
    }
}

