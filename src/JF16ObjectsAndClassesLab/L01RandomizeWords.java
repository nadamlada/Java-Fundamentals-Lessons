package JF16ObjectsAndClassesLab;

/*
You are given a list of words in one line. Randomize their order and print each word on a separate line.
 */

import java.util.Random;
import java.util.Scanner;

public class L01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int indexX = rnd.nextInt(words.length);
            int indexY = rnd.nextInt(words.length);

            String buffer = words[indexX];
            words[indexX] = words[indexY];
            words[indexY] = buffer;
        }
        //lineSeparator принтира на нов ред, когато имаме println
        System.out.println(String.join(System.lineSeparator(), words));
    }
}