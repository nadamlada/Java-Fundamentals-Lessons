package JF19MapsLambdaAndStreamApiLab;
/*
read list of numbers
print largest 3, if there are less than 3, print all of them
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LLargest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        //1 8 7 5
        //8 7 5 limit 3

        Arrays.stream(input)
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

    }
}
