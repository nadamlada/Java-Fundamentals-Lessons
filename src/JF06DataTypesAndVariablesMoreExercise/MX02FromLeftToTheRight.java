package JF06DataTypesAndVariablesMoreExercise;

/*
You will receive a number that represents how many lines we will get as input. On the next N lines, you will receive a string with
2 numbers separated by a single space. You need to compare them. If the left number is greater than the right number, you need to print
the sum of all digits in the left number, otherwise, print the sum of all digits in the right number.
 */

import java.util.Scanner;

public class MX02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nan = Integer.parseInt(scanner.nextLine());

        for (int p = 1; p <= nan; p++) {
            String input = scanner.nextLine();
            int lengthInput = input.length();
            String firstNum = "";
            int countDigitsFirst = 0;

            for (int i = 0; i < lengthInput; i++) {
                char first = input.charAt(i);

                if (first == 32) {                   // сравняване на чарове
                    break;
                }

                firstNum += first;
                countDigitsFirst++;
            }

            String secondNum = "";

            for (int j = countDigitsFirst + 1; j < lengthInput; j++) {
                char second = input.charAt(j);
                secondNum += second;
            }

            double parseFirst = Double.parseDouble(firstNum);
            double parseSecond = Double.parseDouble(secondNum);
            int sum = 0;

            if (parseFirst > parseSecond) {
                double first = Math.abs(parseFirst);

                while (first > 0) {
                    double digit = first % 10;                             //взима последната цифра
                    sum += digit;
                    first /= 10;                                             // премахваме последния диджит
                }
            } else {
                double second = Math.abs(parseSecond);

                while (second > 0) {
                    double digit = second % 10;
                    sum += digit;
                    second /= 10;
                }
            }

            System.out.println(sum);
        }
    }
}