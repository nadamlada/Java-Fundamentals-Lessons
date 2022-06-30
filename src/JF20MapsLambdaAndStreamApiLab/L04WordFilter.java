package JF20MapsLambdaAndStreamApiLab;

/*
Read an array of strings, take only words which length is even. Print each word on a new line.
 */

import java.util.Arrays;
import java.util.Scanner;

public class L04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Arrays.stream(input)
                .filter(word -> word.length() % 2 == 0)
                .forEach(word -> System.out.println(word));
    }
}
