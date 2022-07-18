package JF29FinalExamExersices.EXExamTasksOfOthers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class X03MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String lines = scanner.nextLine();

        Map<String, int[]> userSentReceived = new HashMap<>();

        while (!lines.equals("Statistics")) {
            String[] commands = lines.split("=");

            switch (commands[0]) {
                case "Add":
                    String username = commands[1];
                    int sent = Integer.parseInt(commands[2]);
                    int received = Integer.parseInt(commands[3]);

                    if (!(userSentReceived.containsKey(username))) {
                        userSentReceived.putIfAbsent(username, new int[2]);
                        userSentReceived.get(username)[0] = sent;
                        userSentReceived.get(username)[1] = received;
                    }

                    break;

                case "Message":
                    String sender = commands[1];
                    String receiver = commands[2];

                    if (userSentReceived.containsKey(sender) && userSentReceived.containsKey(receiver)) {
                        userSentReceived.get(sender)[0] += 1;
                        int currentCapacity = userSentReceived.get(sender)[0] + userSentReceived.get(sender)[1];

                        if (currentCapacity >= capacity) {
                            System.out.printf("%s reached the capacity!%n", sender);
                            userSentReceived.remove(sender);
                        }

                        userSentReceived.get(receiver)[1] += 1;
                        currentCapacity = userSentReceived.get(receiver)[0] + userSentReceived.get(receiver)[1];

                        if (currentCapacity >= capacity) {
                            System.out.printf("%s reached the capacity!%n", receiver);
                            userSentReceived.remove(receiver);
                        }
                    }

                    break;

                case "Empty":
                    username = commands[1];

                    if (userSentReceived.containsKey(username)) {
                        userSentReceived.remove(username);
                    }

                    if (username.equals("All")) {
                        //userSentReceived = new HashMap<>();
                        userSentReceived.clear();
                    }

                    break;
            }

            lines = scanner.nextLine();
        }

        System.out.printf("Users count: %d%n", userSentReceived.size());
        for (Map.Entry<String, int[]> entry : userSentReceived.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()[0] + entry.getValue()[1]);
        }
    }
}
