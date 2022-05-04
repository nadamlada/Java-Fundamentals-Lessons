package JF19MapsLambdaAndStreamApiLab;

/*
Write a program that keeps a map with synonyms. The key of the map will be the word. The value will be a list of all the synonyms of that word. You will be given a number n. On the next 2 * n lines you will be given a word and a synonym each on a separate line like this:
•	{word}
•	{synonym}
If you get the same word for the second time, just add the new synonym to the list.
Print the words in the following format:
{word} - {synonym1, synonym2… synonymN}
 */

import java.util.*;

public class L02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonymDictionary.containsKey(word)) {
                //създаваме списък
                List<String> synonymsForCurrentWord = new ArrayList<>();
                synonymsForCurrentWord.add(synonym);
                synonymDictionary.put(word, synonymsForCurrentWord);
            } else {
                //взимаме съществуващия списък
                List<String> synonymsForCurrentWord = synonymDictionary.get(word);
                synonymsForCurrentWord.add(synonym);
                synonymDictionary.put(word, synonymsForCurrentWord);
            }
        }

        for (Map.Entry<String, List<String>> entry : synonymDictionary.entrySet()) {
            String currentWord = entry.getKey();
            List<String> synonymsForCurrentWord = entry.getValue();

            System.out.print(currentWord);
            System.out.print(" - ");
            String print = synonymsForCurrentWord.toString().replace("]", "").replace("[", "");
            System.out.println(print);

            // System.out.printf("%s - %s%n", currentWord, String.join(", ", synonymsForCurrentWord));
        }
    }
}