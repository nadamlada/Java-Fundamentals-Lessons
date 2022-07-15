package JF29FinalExamExersices.EX03ProgrammingFundamentalsFinalExamRetake;

/*
The SoftUni Spelling Bee competition is here. But it`s not like any other Spelling Bee competition out there. It`s different and a lot more fun! You, of course, are a participant, and you are eager to show the competition that you are the best, so go ahead, learn the rules and win!
On the first line of the input, you will be given a text string. To win the competition, you have to find all hidden word pairs, read them, and mark the ones that are mirror images of each other.
First of all, you have to extract the hidden word pairs. Hidden word pairs are:
•	Surrounded by "@" or "#" (only one of the two) in the following pattern #wordOne##wordTwo# or @wordOne@@wordTwo@
•	At least 3 characters long each (without the surrounding symbols)
•	Made up of letters only
If the second word, spelled backward, is the same as the first word and vice versa (casing matters!), they are a match, and you have to store them somewhere. Examples of mirror words:
#Part##traP# @leveL@@Level@ #sAw##wAs#
•	If you don`t find any valid pairs, print: "No word pairs found!"
•	If you find valid pairs print their count: "{valid pairs count} word pairs found!"
•	If there are no mirror words, print: "No mirror words!"
•	If there are mirror words print:
"The mirror words are:
{wordOne} <=> {wordtwo}, {wordOne} <=> {wordtwo}, … {wordOne} <=> {wordtwo}"
Input / Constraints
•	You will recive a string.
Output
•	Print the proper output messages in the proper cases as described in the problem description.
•	If there are pairs of mirror words, print them in the end, each pair separated by ", ".
•	Each pair of mirror word must be printed with " <=> " between the words.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([\\@|\\#])(?<text1>[A-Za-z]{3,})\\1\\1(?<text2>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> paired = new ArrayList<>();
        int count = 0;

        while (matcher.find()) {
            count++;
            String pair1 = matcher.group("text1");
            String pair2 = new StringBuilder(matcher.group("text2")).reverse().toString();

            if (pair2.equals(pair1)) {
                paired.add(pair1);
            }
        }

        // така се проверява дали има въобще намерено. matcher found с удивителна отпред не работи

        if (count == 0) {
            System.out.printf("No word pairs found!%n");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }

        if (paired.isEmpty()) {
            System.out.printf("No mirror words!%n");
        } else {
            System.out.printf("The mirror words are:%n", paired.size());
            int i = 0;

            for (String s : paired) {
                i++;

                if (i < paired.size()) {
                    System.out.printf("%s <=> %s, ", s, new StringBuilder(s).reverse());
                } else {
                    System.out.printf("%s <=> %s%n", s, new StringBuilder(s).reverse());
                }
            }
        }
    }
}

