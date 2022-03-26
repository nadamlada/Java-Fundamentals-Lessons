package JF13ListsExercise;

/*
You will receive a sequence of integers, separated by spaces - the distances to the Pokémons.
Then you will begin receiving integers, which will correspond to indexes in that sequence.
When you receive an index, you must remove the element at that index from the sequence (as if you've captured the Pokémon).
•	You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to the removed element, with the
value of the removed element.
•	You must DECREASE the value of all elements in the sequence which are GREATER than the removed element, with the value
of the removed element.
If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
If the given index is GREATER than the last index of the sequence, remove the last element from the sequence,
and COPY the first element to its place.
The increasing and decreasing of elements should be done in these cases, also. The element, whose value you should use,
is the REMOVED element.
The program ends when the sequence has no elements (there are no Pokémons left for Ely to catch).
Input
•	On the first line of input, you will receive a sequence of integers, separated by spaces.
•	On the next several lines you will receive integers – the indexes.
Output
•	When the program ends, you must print on the console, the summed up value of all REMOVED elements.
Constrains
•	The input data will consist ONLY of valid integers in the range [-2.147.483.648, 2.147.483.647].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> distToPoke = new ArrayList<>();
        String[] buffer = input.split("\\s+");

        for (String s : buffer) {
            distToPoke.add(Integer.parseInt(s));
        }

        //сумата та всички премахнати елементи

        int sum = 0;
        int removed = 0;

        while (distToPoke.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                //премахни нулевия
                // на мястото на нулевия сложи последния
                //+- с премахнатия елемент

                removed = distToPoke.get(0);
                int lastElement = distToPoke.get(distToPoke.size() - 1);
                distToPoke.set(0, lastElement);
                calculations(distToPoke, removed);
            } else if (index > distToPoke.size() - 1) {
                //премахни последния
                //сложи първия на мястото на последния
                //+- с премахнатия елемент
                removed = distToPoke.get(distToPoke.size() - 1);

                int firstElement = distToPoke.get(0);
                distToPoke.set(distToPoke.size() - 1, firstElement);
                calculations(distToPoke, removed);
            } else if (index >= 0 && index < distToPoke.size()) {
                //премахни елемента на индекс  index
                //+- (1. елементите, които са <= от премахнатия ги увеличаваме със ст-та премахнатия
                //    2. елементите, които са > от премахнатия ги намаляваме със ст-та на премахнатия)

                removed = distToPoke.get(index);
                distToPoke.remove(index);
                calculations(distToPoke, removed);
            }

            sum += removed;
        }

        System.out.println(sum);
    }

    private static void calculations(List<Integer> distToPoke, int removed) {

        for (int i = 0; i < distToPoke.size(); i++) {

            if (distToPoke.get(i) <= removed) {
                int increased = distToPoke.get(i) + removed;
                distToPoke.set(i, increased);
            } else if (distToPoke.get(i) > removed) {
                int decreased = distToPoke.get(i) - removed;
                distToPoke.set(i, decreased);
            }
        }
    }
}