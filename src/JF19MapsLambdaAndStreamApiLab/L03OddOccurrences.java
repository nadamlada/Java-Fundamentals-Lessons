package JF19MapsLambdaAndStreamApiLab;

/*
Write a program that extracts from a given sequence of words all elements that are present in it an odd number of times (case-insensitive).
•	Words are given in a single line, space-separated.
•	Print the result elements in lowercase in their order of appearance.
 */

import java.util.*;

public class L03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        Map<String, Integer> wordsQtyMap = new LinkedHashMap<>();

        for (String word : words) {
            String lowerCase = word.toLowerCase();
            if (!wordsQtyMap.containsKey(lowerCase)) {
                wordsQtyMap.put(lowerCase, 1);
            } else {
                int currentQty = wordsQtyMap.get(lowerCase);
                wordsQtyMap.put(lowerCase, currentQty + 1);
            }
        }

        List<String> oddOccurrences = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordsQtyMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddOccurrences.add(entry.getKey());
            }
        }

        String print = oddOccurrences.toString().replace("[", "").replace("]", "");
        System.out.println(print);
    }
}