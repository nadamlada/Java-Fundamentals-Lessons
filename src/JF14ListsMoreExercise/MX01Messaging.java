package JF14ListsMoreExercise;

/*
You will be given some list of numbers and a string. For each element of the list you have to take the sum of its
digits and take the element corresponding to that index from the text. If the index is greater than the length of the text,
start counting from the beginning (so that you always have a valid index). After getting the element from the text,
you have to remove the character you have taken from it (so for the next index, the text will be with one character less).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MX01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nums = scanner.nextLine();
        List<String> numbers = new ArrayList<>();
        String[] buff = nums.split("\\s+");

        for (String s : buff) {
            numbers.add(s);
        }

        String text = scanner.nextLine();

        //обхождаме всички от листа numbers 1234 666666
        for (int i = 0; i < numbers.size(); i++) {

            //обхождаме числото ен-та позиция от листа, и събираме елементите му
            int lengthOfCurrentNum = numbers.get(i).length();
            int sum = 0;

            for (int j = 0; j < lengthOfCurrentNum; j++) {
                String currentNumber = numbers.get(i);

                //123456 като стринг
                char element = (currentNumber.charAt(j));
                int elem = element - '0';

                sum += elem;
            }

            //кой елемент от текста съответстве на индекс сум

            //колко е дължината на текста
            int lenghtOfText = text.length();

            //ако сумата е повече от дължината на текста, се връщаме и започваме да търсим отначало
            while (sum > lenghtOfText) {
                sum = sum - lenghtOfText;
            }

            // като намерим кой елемент съответства на сум, да го изтрием
            List<String> trimmedText = new ArrayList<>();

            for (int j = 0; j < sum; j++) {
                trimmedText.add(text.charAt(j) + "");
            }

            for (int j = sum + 1; j < text.length(); j++) {
                trimmedText.add(text.charAt(j) + "");
            }

            String trimmedElement = text.charAt(sum) + "";
            text = String.join("", trimmedText);

            //за следващия интекс текста ще е с един символ по-къс
            List<String> print = new ArrayList<>();
            print.add(trimmedElement);

            String result = String.join("", print);
            System.out.print(result);
        }
    }
}