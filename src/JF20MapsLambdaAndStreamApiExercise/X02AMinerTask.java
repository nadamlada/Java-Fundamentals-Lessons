package JF20MapsLambdaAndStreamApiExercise;

/*
Until you receive the "stop" command, you will be given a sequence of strings, each on a new line. Every odd line on the console is representing
a resource (e.g. Gold, Silver, Copper, etc.) and every even - quantity. Your task is to collect the resources and print them each on a new line.
Print the resources and their quantities in format: {resource} –> {quantity}
The quantities inputs will be in the range [1 … 2 000 000 000].
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class X02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map<String, Integer> book = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int qty = Integer.parseInt(scanner.nextLine());

            book.putIfAbsent(resource, 0);
            book.put(resource, book.get(resource) + qty);

            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : book.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}