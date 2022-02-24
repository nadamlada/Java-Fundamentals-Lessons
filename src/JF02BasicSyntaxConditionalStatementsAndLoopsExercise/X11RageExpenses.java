package JF02BasicSyntaxConditionalStatementsAndLoopsExercise;

/*
As a MOBA challenger player, Peter has the bad habit to trash his PC when he loses a game and rage quits. His gaming setup consists of a headset, mouse, keyboard, and display. You will receive Peter`s lost games count.
Every second lost game, Peter trashes his headset.
Every third lost game, Peter trashes his mouse.
When Peter trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
Every second time, when he trashes his keyboard, he also trashes his display.
You will receive the price of each item in his gaming setup. Calculate his rage expenses for renewing his gaming equipment.
Input / Constraints
•	On the first input line - lost games count – integer in the range [0, 1000].
•	On the second line – headset price - the floating-point number in the range [0, 1000].
•	On the third line – mouse price - the floating-point number in the range [0, 1000].
•	On the fourth line – keyboard price - the floating-point number in the range [0, 1000].
•	On the fifth line – display price - the floating-point number in the range [0, 1000].
Output
•	As output you must print Peter`s total expenses: "Rage expenses: {expenses} lv."
•	Allowed working time / memory: 100ms / 16MB.
 */

import java.util.Scanner;

public class X11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lost = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int countHeadset = 0;
        int countMouse = 0;
        int countKeyboard = 0;
        int countDisplay = 0;

        for (int i = 1; i <= lost; i++) {

            if (i % 2 == 0) {
                countHeadset++;
            }

            if (i % 3 == 0) {
                countMouse++;
            }

            if ((i % 2 == 0) && (i % 3 == 0)) {
                countKeyboard++;
                if (countKeyboard % 2 == 0) {
                    countDisplay++;
                }
            }
        }

        double expenses =
                (countHeadset * headsetPrice) +
                        (countMouse * mousePrice) +
                        (countKeyboard * keyboardPrice) +
                        (countDisplay * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", expenses);

    }
}