package JF08ArraysExercise;

/*
The clone factory in Kamino got another order to clone troops. But this time you are tasked to find the best DNA sequence to use in the production.
You will receive the DNA length and until you receive the command "Clone them!" you will be receiving DNA sequences of ones and zeroes, split by "!" (one or several).
You should select the sequence with the longest subsequence of ones. If there are several sequences with the same length of a subsequence of ones, print the one with the leftmost starting index, if there are several sequences with the same length and starting index, select the sequence with the greater sum of its elements.
After you receive the last command "Clone them!" you should print the collected information in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"
Input / Constraints
•	The first line holds the length of the sequences – integer in the range [1…100].
•	On the next lines until you receive "Clone them!" you will be receiving sequences (at least one) of ones and zeroes, split by "!" (one or several).
 Output
The output should be printed on the console and consists of two lines in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X09KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int searchedMaxNumber = 0;          //дължина
        String searchedDNA = "";
        int searchedIndex = Integer.MAX_VALUE;
        int searchedMaxCountOnes = 0;
        int counterSample = 0;
        int searchedCounterSample = 0;

        while (!input.equals("Clone them!")) {
            String currentDNA = input.replaceAll("\\!", "");
            //10110
            counterSample++;
            int counter = 0;
            int currentCountAllONes = 0;
            int currentMaxNumber = 0; //от колко символа е най-голямата поредица кърънт

            for (int i = 0; i < currentDNA.length(); i++) {
                if (currentDNA.charAt(i) == '1') {
                    currentCountAllONes++;
                    counter++;
                    if (counter > currentMaxNumber) {
                        currentMaxNumber = counter;
                        //тук е най-голямата поредица
                    }
                } else {
                    counter = 0;
                }
            }

            // да намерим кое е числото, което е най-голямо за да намеря на кой индекс е в стринга
            String currentBiggestNum = "";
            for (int i = 0; i < currentMaxNumber; i++) {
                currentBiggestNum += "1";
            }

            int currentIndex = currentDNA.indexOf(currentBiggestNum);
            //да сравним дължините currentMaxNumber е дължина
            if (currentMaxNumber > searchedMaxNumber) {
                searchedMaxNumber = currentMaxNumber;
                searchedDNA = currentDNA;
                searchedIndex = currentIndex;
                searchedMaxCountOnes = currentCountAllONes;
                searchedCounterSample = counterSample;

            } else if (currentMaxNumber == searchedMaxNumber) {
                if (currentIndex < searchedIndex) {
                    searchedDNA = currentDNA;
                    searchedIndex = currentIndex;
                    searchedMaxCountOnes = currentCountAllONes;
                    searchedCounterSample = counterSample;

                } else if (currentIndex == searchedIndex) {
                    if (currentCountAllONes > searchedMaxCountOnes) {
                        searchedDNA = currentDNA;
                        searchedMaxCountOnes = currentCountAllONes;
                        searchedCounterSample = counterSample;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", searchedCounterSample, searchedMaxCountOnes);
        //System.out.printf("%s", searchedDNA);
        List<String> printDNA = new ArrayList<>();
        for (int i = 0; i < searchedDNA.length(); i++) {
            printDNA.add(searchedDNA.charAt(i) + "");
        }
        System.out.println(String.join(" ", printDNA));
    }
}