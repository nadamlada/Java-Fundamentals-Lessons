package JF01BasicSyntaxConditionalStatementsAndLoopsLab;

/*
Every time John tries to pay his bills he sees on the cash desk the sign: "I will be back in 30 minutes". One day John was sick of waiting and decided he needs a program, which prints the time after 30 minutes. That way he won’t have to wait at the desk and come at the appropriate time. He gave the assignment to you, so you have to do it.
Input
The input will be on two lines. On the first line, you will receive the hours and on the second you will receive the minutes.
Output
Print on the console the time after 30 minutes. The result should be in the format "hh:mm". The hours have one or two numbers and the minutes have always two numbers (with leading zero).
Constraints
•	The hours will be between 0 and 23.
•	The minutes will be between 0 and 59.
 */

import java.util.Scanner;

public class L04BackIn_30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        int newHour = hours;
        int newMin = min + 30;
        if (newMin > 59) {
            newMin = newMin - 60;
            newHour = hours + 1;
        }
        if (newHour > 23) {
            newHour = newHour - 24;
        }

        System.out.printf("%d:%02d", newHour, newMin);

    }
}
