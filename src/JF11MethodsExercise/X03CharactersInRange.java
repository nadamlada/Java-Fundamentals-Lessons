package JF11MethodsExercise;

/*
Write a method that receives two characters and prints on a single line all the characters in between them according to ASCII.
 */

import java.util.Scanner;

public class X03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();
        char aa = a.charAt(0);
        char bb = b.charAt(0);

        printAllElements(aa, bb);
    }

    private static void printAllElements(char aa, char bb) {

        //започвам принтирането от по-малкия код
        if (aa > bb) {
            for (char i = (char) (bb + 1); i < aa; i++) {               // така започваме да печатаме от следващия чар
                System.out.print(i + " ");
            }

        } else {
            for (char i = aa; i < bb; i++) {
                if (i != aa) {
                    System.out.print(i + " ");                              // или просто не принтираме първия чар
                }
            }
        }
    }
}