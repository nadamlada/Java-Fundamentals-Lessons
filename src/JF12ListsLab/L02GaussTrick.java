
package JF12ListsLab;

/*
Write a program that sum all numbers in a list in the following order:
first + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.
*/

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L02GaussTrick {
    public L02GaussTrick() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numbers = (List) Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int size = numbers.size();

        for (int i = 0; i < size / 2; ++i) {
            int firstNum = (Integer) numbers.get(i);
            int lastNum = (Integer) numbers.get(numbers.size() - 1);
            numbers.set(i, firstNum + lastNum);
            numbers.remove(numbers.size() - 1);
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}