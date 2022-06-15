package JF27RegularExpressionsExercises;

/*
Write a program that processes information about a race. On the first line, you will be given a list of participants
separated by ", ". On the next few lines until you receive a line "end of race" you will be given some info which will
be some alphanumeric characters. In between them, you could have some extra characters which you should ignore.
For example: "G!32e%o7r#32g$235@!2e". The letters are the name of the person and the sum of the digits is the distance
he ran. So here we have George who ran 29 km. Store the information about the person only if the list of racers contains
the name of the person. If you receive the same person more than once just add the distance to his old distance. At the
end print the top 3 racers in the format:
"1st place: {first racer}
2nd place: {second racer}
3rd place: {third racer}"

 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class X02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> catalog = new HashMap<>();
        String[] text = scanner.nextLine().split(",\\s+");

        for (int i = 0; i < text.length; i++) {
            String s = text[i];
            catalog.putIfAbsent(s, 0);
        }

        String regexName = "[A-Za-z]+";
        String regexPoints = "[0-9]";

        Pattern patternName = Pattern.compile(regexName);
        Pattern patternPoints = Pattern.compile(regexPoints);

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {

            StringBuilder name = new StringBuilder();
            Matcher matcherName = patternName.matcher(input);

            while (matcherName.find()) {
                name.append(matcherName.group());
            }

            Matcher matcherPoints = patternPoints.matcher(input);

            int distance = 0;

            while (matcherPoints.find()) {
                distance += Integer.parseInt(matcherPoints.group());
            }

            String nameString = name.toString();

            if (catalog.containsKey(nameString)) {
                catalog.put(nameString, distance + catalog.get(nameString));
            }

            input = scanner.nextLine();
        }

//        сортиране по Map Value;
//        Map<Integer, String> print = new HashMap<>();
//        print.put(1, "1st");
//        print.put(2, "2nd");
//        print.put(3, "3rd");
//
//        int counter = 0;
//        while (counter <= 2) {
//            int max = Integer.MIN_VALUE;
//            String savePlayer = "";
//
//            for (Map.Entry<String, Integer> entry : catalog.entrySet()) {
//                if (entry.getValue() > max) {
//                    max = entry.getValue();
//                    savePlayer = entry.getKey();
//                }
//            }
//
//            System.out.printf("%s place: %s%n", print.get(counter + 1), savePlayer);
//            catalog.remove(savePlayer);
//            counter++;
//        }
//
//        System.out.println();

        //1. сортираме по value (дистанция) в descending order
        //racersDistances.entrySet().stream().sorted(Map.Entry.comparingByValue()) -> ascending order (нарастващ ред)
        //начин 2:
        //списък с имената на първите трима

        List<String> firstThreeNames = catalog.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3) //получавам мап с 3 записа
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThreeNames.get(0));
        System.out.println("2nd place: " + firstThreeNames.get(1));
        System.out.println("3rd place: " + firstThreeNames.get(2));
    }
}