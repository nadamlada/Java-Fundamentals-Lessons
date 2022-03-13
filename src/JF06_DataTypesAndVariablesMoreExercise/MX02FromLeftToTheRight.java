package JF06_DataTypesAndVariablesMoreExercise;

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
            int countDigistSecond = 0;
            for (int i = 0; i < lengthInput; i++) {

                char first = input.charAt(i);
                if (first == 32) {                   // сравняване на чарове
                    break;
                }
                firstNum += first;
                countDigitsFirst++;
            }
            //           System.out.println(firstNum);

            String secondNum = "";
            for (int j = countDigitsFirst + 1; j < lengthInput; j++) {

                char second = input.charAt(j);
                secondNum += second;
                countDigistSecond++;
            }
            //            System.out.println(secondNum);

            double parseFirst = Double.parseDouble(firstNum);
            double parseSecond = Double.parseDouble(secondNum);

            int sumFirst = 0;

            double firstMathAbs = Math.abs(parseFirst);
            while (firstMathAbs > 0) {
                double digit = firstMathAbs % 10;                             //взима последната цифра
                sumFirst += digit;
                firstMathAbs = firstMathAbs / 10;                           // премахваме последния диджит
            }

            int sumSecond = 0;

            double secondMathAbs = Math.abs(parseSecond);
            while (secondMathAbs > 0) {

                double digit = secondMathAbs % 10;                        //взима последната цифра
                sumSecond += digit;
                secondMathAbs = secondMathAbs / 10;                       // премахваме последния диджит

            }
            ///// печаташ
            if (parseFirst > parseSecond) {
                System.out.println(sumFirst);
            } else {
                System.out.println(sumSecond);
            }
        }
    }
}