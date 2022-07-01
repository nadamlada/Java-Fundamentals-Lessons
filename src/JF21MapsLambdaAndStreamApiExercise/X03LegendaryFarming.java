package JF21MapsLambdaAndStreamApiExercise;

/*
You are playing a game, and your goal is to win a legendary item - any legendary item will be good enough. However,
it's a tedious process, and it requires quite a bit of farming. The possible items are:
•	"Shadowmourne" - requires 250 Shards
•	"Valanyr" - requires 250 Fragments
•	"Dragonwrath" - requires 250 Motes
"Shards", "Fragments", and "Motes" are the key materials 	(case-insensitive), and everything else is junk.
You will be given lines of input in the format:
"{quantity1} {material1} {quantity2} {material2} … {quantityN} {materialN}"
Keep track of the key materials - the first one that reaches 250, wins the race. At that point, you have to print that
the corresponding legendary item is obtained.
In the end, print the remaining shards, fragments, motes in the format:
"shards: {numberOfShards}
fragments: {numberOfFragments}
motes: {numberOfMotes}"
Finally, print the collected junk items in the order of appearance.
Input
•	Each line comes in the following format: "{quantity1} {material1} {quantity2} {material2} … {quantityN} {materialN}"
Output
•	On the first line, print the obtained item in the format: "{Legendary item} obtained!" .
•	On the next three lines, print the remaining key materials.
•	On the several final lines, print the junk items.
•	All materials should be printed in the format: "{material}: {quantity}".
•	The output should be lowercase, except for the first letter of the legendary.
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class X03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> print = new HashMap<>();
        print.put("fragments", "Valanyr obtained!");
        print.put("motes", "Dragonwrath obtained!");
        print.put("shards", "Shadowmourne obtained!");

        boolean endGame = false;

        Map<String, Integer> preciousItems = new LinkedHashMap<>();
        preciousItems.put("shards", 0);
        preciousItems.put("fragments", 0);
        preciousItems.put("motes", 0);

        Map<String, Integer> junk = new LinkedHashMap<>();

        while (!endGame) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length - 1; i += 2) {
                int qty = Integer.parseInt(input[i]);
                String object = input[i + 1].toLowerCase();

                if (object.equals("shards") || object.equals("fragments") || object.equals("motes")) {

                    if (!preciousItems.containsKey(object)) {
                        preciousItems.put(object, qty);
                    } else {
                        preciousItems.put(object, preciousItems.get(object) + qty);
                    }

                    if (preciousItems.get(object) >= 250) {
                        preciousItems.put(object, preciousItems.get(object) - 250);
                        System.out.println(print.get(object));
                        endGame = true;
                        break;
                    }
                } else {
                    junk.putIfAbsent(object, 0);
                    junk.put(object, junk.get(object) + qty);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : preciousItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}