package JF14ListsMoreExercise;

 /*
 Write a program that mixes up two lists by some rules. You will receive two lines of input, each one being a list of numbers. The rules for mixing are:
 •	Start from the beginning of the first list and from the ending of the second
 •	Add element from the first and element from the second
 •	At the end there will always be a list in which there are 2 elements remaining
 •	These elements will be the range of the elements you need to print
 •	Loop through the result list and take only the elements that fulfill the condition
 •	Print the elements ordered in ascending order and separated by a space
  */

import java.util.*;
import java.util.stream.Collectors;

public class MX04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first1 = scanner.nextLine();
        List<Integer> first = Arrays.stream(first1.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String second1 = scanner.nextLine();
        List<Integer> second = Arrays.stream(second1.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(second);

        List<Integer> combined = new ArrayList<>();
        int lengthOfBoth = Math.min(first.size(), second.size());

        for (int i = 0; i < lengthOfBoth; i++) {
            int currentNumberFirst = first.get(i);
            int currentNumberSecond = second.get(i);

            combined.add(currentNumberFirst);
            combined.add(currentNumberSecond);
        }

        //кой е по-дългия лист, за да му вземем последните два елемента

        int startCount = 0;
        int endCount = 0;

        if (lengthOfBoth == first.size()) {
            //първия е по-къс, значи втория е по-дълъг
            Collections.reverse(second);
            startCount = Math.min(second.get(0), second.get(1));
            endCount = Math.max(second.get(0), second.get(1));
        } else {
            //първия е по-дълъг
            startCount = Math.min(first.get(first.size() - 1), first.get(first.size() - 2));
            endCount = Math.max(first.get(first.size() - 1), first.get(first.size() - 2));
        }

        combined.add(startCount);
        combined.add(endCount);
        Collections.sort(combined);
        List<Integer> forPrint = new ArrayList<>();

        for (int i = 0; i < combined.size(); i++) {
            if (startCount < combined.get(i) && (combined.get(i) < endCount)) {
                forPrint.add(combined.get(i));
            }
        }

        String print = forPrint.toString().replace("[", "").replace("]", "").replaceAll(",", "");
        System.out.println(print);
    }
}