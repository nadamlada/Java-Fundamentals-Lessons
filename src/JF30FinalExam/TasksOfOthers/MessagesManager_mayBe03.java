package JF30FinalExam.TasksOfOthers;

/*
Messages Manager

Create a program that manages messages sent and received of users. You need to keep information about username, their sent and received messages. You will receive the capacity of possible messages kept at once per user. You will be receiving lines with commands until you receive the "Statistics" command.  There are three possible commands:

"Add={username}={sent}={received}":
Add the username, his/her sent and received messages to your records. If person with the given username already exists ignore the line.
"Message={sender}={receiver}":
Check if both usernames exist and if they do, increase the sender’s sent messages by 1 and the receiver’s received messages by 1. If anyone reaches the capacity (first check the sender), he/she should be removed from the record and you should print the following message:
"{username} reached the capacity!"
"Empty={username}":
Delete all records of the given user, if he exists. If "All" is given as username - delete all records you have.
In the end, you have to print the count of users, each person with his/her messages (the count of both sent and received) sorted in descending order by the received messages and then by their username in ascending order in the following format:

Users count: {count}

{username} - {messages}

{username} - {messages}

Input
On the first line, you will receive the capacity - an integer number in the range [1-10000].
You will be receiving lines until you receive the "Statistics" command.
The initial messages (sent and received) will always be below the capacity.
The input will always be valid.
Output
Print the appropriate message after the "Message" command, if someone reaches the capacity.
Print the users with their messages in the format described above.
 */

import java.util.*;

public class MessagesManager_mayBe03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        Map<String, int[]> map = new HashMap<>();

        while (!input.equals("Statistics")) {
            String[] commands = input.split("=");

            switch (commands[0]) {
                case "Add":
                    String username = commands[1];
                    int sent = Integer.parseInt(commands[2]);
                    int received = Integer.parseInt(commands[3]);

                    if (!map.containsKey(username)) {
                        map.put(username, new int[2]);
                        map.get(username)[0] += sent;
                        map.get(username)[1] += received;
                    }

                    break;

                case "Message":
                    String sender = commands[1];
                    String receiver = commands[2];

                    if (map.containsKey(sender) && map.containsKey(receiver)) {
                        map.get(sender)[0] += 1;

                        if (map.get(sender)[0] >= capacity) {
                            System.out.printf("%s reached the capacity!", sender);
                            map.remove(sender);
                        }

                        map.get(receiver)[1] += 1;

                        if (map.get(receiver)[0] >= capacity) {
                            System.out.printf("%s reached the capacity!", sender);
                            map.remove(receiver);
                        }
                    }

                    break;

                case "Empty":
                    username = commands[1];

                    if (username.equals("All")) {
                        map.clear();
                    } else {
                        map.remove(username);
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> usersSums = new TreeMap<>();
        Map<String, Integer> usersReceived = new HashMap<>();

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            usersSums.put(entry.getKey(), entry.getValue()[0]+entry.getValue()[1]);
            usersReceived.put(entry.getKey(), entry.getValue()[1]);
        }

        Map<String, Integer> reverseusersReceived = new LinkedHashMap<>();

        usersReceived.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseusersReceived.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : reverseusersReceived.entrySet()) {

            for (Map.Entry<String, Integer> entry2 : usersSums.entrySet()) {

                if(entry.getKey().equals(entry2.getKey())){
                    System.out.printf("%s - %d%n", entry2.getKey(),entry2.getValue());
                }
            }
        }
    }
}
