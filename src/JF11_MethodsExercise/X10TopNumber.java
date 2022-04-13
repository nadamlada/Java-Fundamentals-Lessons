package JF11_MethodsExercise;

/*
Read an integer n from the console. Find all top numbers in the range [1 … n] and print them. A top number holds the following properties:
•	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
•	Holds at least one odd digit, e.g. 232, 707, 87578.
 */

import java.util.Scanner;

public class X10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        // обхождаме всички числа от едно до n
        // за всяко правя проверка лаи изпълнява условията

        for (int input = 1; input <= n; input++) {

            if (holdsOneOddDgit(input) && isSumOfDigitsDivisibleBy8(input)) {
                System.out.println(input);
            }
        }
    }

    private static boolean isSumOfDigitsDivisibleBy8(int input) {

        int sum = 0;

        while (input > 0) {
            //1. взимаме последната цифра
            int lastDigit = input % 10;
            // 2. добавяме към сумата
            sum += lastDigit;
            //3. премахвам последната цифра
            input = input / 10;
        }

        return sum % 8 == 0;
    }

    private static boolean holdsOneOddDgit(int input) {

        //true -> има поне една нечетна
        while (input > 0) {
            //1. Взимам последната цифра
            int lastDigit = input % 10;
            //2. Проверка дали е нечетна
            if (lastDigit % 2 == 1) {
                return true;
            }
            //3. Премахвам последната цифра
            input = input / 10;
        }

        return false;
    }
}