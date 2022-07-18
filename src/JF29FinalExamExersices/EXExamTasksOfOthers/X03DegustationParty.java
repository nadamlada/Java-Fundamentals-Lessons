package JF29FinalExamExersices.EXExamTasksOfOthers;

import java.util.*;

public class X03DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<String>> map = new LinkedHashMap<>();
        List<String> unliked = new ArrayList<>();

        while (!input.equals("Stop")) {
            String[] commands = input.split("-");
            String guest = commands[1];
            String meal = commands[2];

            switch (commands[0]) {
                case "Like":
                    map.putIfAbsent(guest, new ArrayList<>());

                    if (!map.containsValue(meal)) {
                        map.get(guest).add(meal);
                    }

                    break;

                case "Dislike":

                    if (map.containsKey(guest)) {
                    } else {
                        System.out.printf("%s is not at the party%n", guest);
                        break;

                    }
                    //проверка дали се съдържа в кий велюто
                    if (!map.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        break;
                    }

                    unliked.add(meal);
                    System.out.printf("%s doesn't like the %s.%n", guest, meal);
                    map.get(guest).remove(meal);
                    break;
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s: ", entry.getKey());
            System.out.printf(entry.getValue().toString().replace("[", "").replace("]", ""));
            System.out.println();
        }

        System.out.printf("Unliked meals: %d", unliked.size());
    }
}