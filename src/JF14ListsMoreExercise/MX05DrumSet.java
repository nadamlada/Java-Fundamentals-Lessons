package JF14ListsMoreExercise;

/*
Gabsy is Orgolt's Final Revenge charming drummer. She has a drum set but the different drums have different origins – some she bought, some are gifts,
so they are all with different quality. Every day she practices on each of them, so she does damage and reduces the drum`s quality. Sometimes a drum brakes,
so she needs to buy new one. Help her keep her drum set organized.
You will receive Gabsy's savings, the money she can spend on new drums. Next you receive a sequence of integers which represent the initial quality of each
drum in Gabsy's drum set.
Until you receive the command "Hit it again, Gabsy!", you will be receiving integer: the hit power Gabsy applies on each drum while practicing. When the power
is applied you should decrease the value of the drum's quality with the current power.
When a certain drum reaches 0 quality, it breaks. Then Gabsy should buy a replacement. She needs to buy the exact same model. Therefore, its quality will be
the same as the initial quality of the broken drum. The price is calculated by the formula: {initialQuality} * 3. Gabsy will always replace her broken drums
until the moment she can no longer afford it. If she doesn't have enough money for a replacement, the broken drum is removed from the drum set.
When you receive the command "Hit it again, Gabsy!", the program ends and you should print the current state of the drum set. On the second line you should
print the remaining money in Gabsy's savings account.
Input
•	On the first line you receive the savings – a floating-point number;
•	On the second line you receive the drum set: sequence of integers, separated by spaces.
•	Until you receive the command "Hit it again, Gabsy!" you will be receiving integers – the hit power Gabsy applies on each drum.
Output
•	On the first line you should print each drum in the drum set, separated by space.
•	Then you must print the money that are left on the second line in the format "Gabsy has {money left}lv.", formatted with two digits after the decimal point.
Constraints
•	The savings – floating-point number in the range [0.00, 10000.00]
•	The quality of each drum in the drum set – integer in the range [1, 1000].
•	The hit power will be in the range [0, 1000]
•	Allowed working time / memory: 100ms / 16MB.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MX05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        List<Integer> drums = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> pricesDividedBy3 = new ArrayList<>();
        String[] firstInput = input.split(" ");

        for (String s : firstInput) {
            pricesDividedBy3.add(Integer.parseInt(s));
        }

        String commands = scanner.nextLine();

        while (!commands.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(commands);

            for (int i = 0; i < drums.size(); i++) {
                drums.set(i, drums.get(i) - power);

                if (drums.get(i) <= 0) {
                    int whenBroke = i;
                    //счупил се е

                    if ((pricesDividedBy3.get(i) * 3 <= savings)) {
                        //купуваме го
                        savings = savings - (pricesDividedBy3.get(i) * 3);

                        drums.set(i, pricesDividedBy3.get(i));
                    } else {
                        drums.remove(i);
                        pricesDividedBy3.remove(i);
                        i--;
                    }
                }
            }

            commands = scanner.nextLine();
        }

        String drumsPrint = drums.toString().replaceAll("[\\[\\],]", "");
        System.out.println(drumsPrint);
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}