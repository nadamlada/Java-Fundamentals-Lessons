package JF12ListsLab;

/*
Read a list of integers, remove all negative numbers from it and print the remaining elements in reversed order. In case of no elements left in the list, print "empty".
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class L07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        String[] nums = input.split(" ");

        for (String elements : nums) {
            numbers.add(Integer.parseInt(elements));
        }

        List<Integer> forPrint = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) < 0) {
                // вместо да ги трия правя нов лист, в който ги слагам
            } else {
                forPrint.add(numbers.get(i));
            }
        }

        //Проверка дали лист е празен
        if (forPrint.isEmpty()) {
            System.out.println("empty");
        } else {
            //подрежда наобратно
            Collections.reverse(forPrint);
            //на жоро принтирането за листове
            for (int element : forPrint) {
                System.out.print(element + " ");
            }
        }
    }
}