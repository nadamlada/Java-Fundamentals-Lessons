package JF13ListsExercise;

/*
You will be given two hands of cards, which will be integer numbers. Assume that you have two players.
You have to find out the winning deck and respectively the winner.
You start from the beginning of both hands. Compare the cards from the first deck to the cards from the second deck.
The player, who has a bigger card, takes both cards and puts them at the back of his hand - the second player's card is last,
and the first person's card (the winning one) is before it (second to last) and the player with the smaller card must remove
the card from his deck. If both players' cards have the same values - no one wins, and the two cards must be removed from the decks.
The game is over when one of the decks is left without any cards.
You have to print the winner on the console and the sum of the left cards: "{First/Second} player wins! Sum: {sum}".
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        List<Integer> first = new ArrayList<>();
        String[] fInput = firstInput.split(" ");

        for (String s : fInput) {
            first.add(Integer.parseInt(s));
        }

        String secondInput = scanner.nextLine();
        List<Integer> second = new ArrayList<>();
        String[] sInput = secondInput.split(" ");

        for (String s : sInput) {
            second.add(Integer.parseInt(s));
        }

        while (first.size() != 0 && second.size() != 0) {

            if (first.get(0) > second.get(0)) {
                first.add(first.get(0));
                first.add(second.get(0));
            } else if (second.get(0) > first.get(0)) {
                second.add(second.get(0));
                second.add(first.get(0));
            }

            first.remove(0);
            second.remove(0);
        }

        //втория печели
        if (first.size() == 0) {
            System.out.printf("Second player wins! Sum: %d", sum(second));

            //първия печели
        } else if (second.size() == 0) {
            System.out.printf("First player wins! Sum: %d", sum(first));
        }
    }

    private static int sum(List<Integer> someList) {
        int sum = 0;

        for (int element : someList) {
            sum += element;
        }

        return sum;
    }
}