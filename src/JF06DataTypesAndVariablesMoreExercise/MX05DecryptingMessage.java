package JF06DataTypesAndVariablesMoreExercise;

/*
 You will receive a key (integer) and n characters afterward. Add the key to each of the characters and append them to the message. At the end print the message, which you decrypted.
 Input
 •	On the first line, you will receive the key
 •	On the second line, you will receive n – the number of lines, which will follow
 •	On the next n lines – you will receive lower and uppercase characters from the Latin alphabet
 Output
 Print the decrypted message.
 Constraints
 •	The key will be in the interval [0…20].
 •	n will be in the interval [1…20].
 •	The characters will always be upper or lower-case letters from the English alphabet.
 •	You will receive one letter per line.
 */

import java.util.Scanner;

public class MX05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String text = "";

        for (int i = 0; i < n; i++) {
            String letter = scanner.nextLine();
            char letterChar = letter.charAt(0);             //превръщаме буквата от стринг в чар
            int decripted = letterChar + key;               // добавяме към чара инт
            char DecriptedChar = (char) decripted;          // прочитаме новоият инт като чар
            text += DecriptedChar;                          // добавяме чаровете в стринг
        }

        System.out.println(text);
    }
}