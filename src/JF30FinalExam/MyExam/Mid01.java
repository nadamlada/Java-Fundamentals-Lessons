package JF30FinalExam.MyExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mid01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();
        String[] buff = input.split(", ");

        for (String s : buff) {
            numbers.add(Integer.parseInt(s));
        }

        int index = Integer.parseInt(scanner.nextLine());
        String expensiveOrCheap = scanner.nextLine();

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {

            if (i < index) {
                left.add(numbers.get(i));
            } else if (i > index) {
                right.add(numbers.get(i));
            }
        }

        if (expensiveOrCheap.equals("expensive")) {

            int sumLeft = 0;

            for (int j = 0; j < left.size(); j++) {

                if (left.get(j) >= numbers.get(index)) {
                    sumLeft += left.get(j);
                }
            }

            int sumRight = 0;

            for (int j = 0; j < right.size(); j++) {

                if (right.get(j) >= numbers.get(index)) {
                    sumRight += right.get(j);
                }
            }

            if (sumRight > sumLeft) {
                System.out.printf("Right - %d", sumRight);
            } else {
                System.out.printf("Left - %d", sumLeft);
            }

        } else if (expensiveOrCheap.equals("cheap")) {
            int sumLeft = 0;

            for (int j = 0; j < left.size(); j++) {

                if (left.get(j) < numbers.get(index)) {
                    sumLeft += left.get(j);
                }
            }

            int sumRight = 0;

            for (int j = 0; j < right.size(); j++) {

                if (right.get(j) < numbers.get(index)) {
                    sumRight += right.get(j);
                }
            }

            if (sumRight > sumLeft) {
                System.out.printf("Right - %d", sumRight);
            } else {
                System.out.printf("Left - %d", sumLeft);
            }
        }
    }
}

