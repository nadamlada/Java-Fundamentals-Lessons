package JF12ListsLab;

/*
You are going to receive two lists with numbers. Create a result list that contains the numbers from both of the lists.
The first element should be from the first list, the second from the second list, and so on. If the length of the two lists is not equal,
just add the remaining elements at the end of the list.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //прочитаме първият ред и го пълним в лист
        String inputFirst = scanner.nextLine();

        List<Integer> firstNumbers = new ArrayList<>();
        String[] fNums = inputFirst.split(" ");

        for (int i = 0; i < fNums.length; i++) {
            firstNumbers.add(Integer.parseInt(fNums[i]));
        }

        //двата вида въвеждане са еднакви
        //прочитаме вторият ред и го пълним в лист
        String inputSecond = scanner.nextLine();

        List<Integer> secondNumbers = new ArrayList<>();
        String[] sNums = inputSecond.split(" ");

        for (String element : sNums) {
            secondNumbers.add(Integer.parseInt(element));
        }

        int shortestList = Math.min(firstNumbers.size(), secondNumbers.size());

        //създаваме лист, в който за ги помним
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < shortestList; i++) {
            result.add(firstNumbers.get(i));
            result.add(secondNumbers.get(i));
        }

        //създаване на съблиста
        if (firstNumbers.size() > secondNumbers.size()) {
            result.addAll(firstNumbers.subList(shortestList, firstNumbers.size()));
        } else {
            result.addAll(secondNumbers.subList(shortestList, secondNumbers.size()));
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}