package JF19MapsLambdaAndStreamApiLab;

/*
Read a list of real numbers and print them in ascending order along with their number of occurrences.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //деклариране на дъбъл масив
        String[] items = input.split("\\s+");
        double[] numbers = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            numbers[i] = Double.parseDouble(items[i]);
        }

        //TreeMap сортира по ключа
        Map<Double, Integer> countsNumberMap = new TreeMap<>();
        for (int i = 0; i < numbers.length; i++) {
            double currentNum = numbers[i];

            //get връща стойността на контретен ключ

            if (countsNumberMap.containsKey(currentNum)) {
                countsNumberMap.put(currentNum, countsNumberMap.get(currentNum) + 1);
            } else {
                countsNumberMap.put(currentNum, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : countsNumberMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}