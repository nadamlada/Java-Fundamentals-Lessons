package JF30FinalExam.TasksOfOthers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03Followers {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, int[]> map = new LinkedHashMap<>();

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
                        System.out.printf("%s doesn't exist.%n", username);
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("%d followers%n", map.size());

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue()[0] + entry.getValue()[1]);
        }
    }
}
