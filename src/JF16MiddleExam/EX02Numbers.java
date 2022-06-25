package JF16MiddleExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX02Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!commands.equals("Finish")) {
            String[] buffer = commands.split(" ");

            switch (buffer[0]) {
                case "Add":
                    int value = Integer.parseInt(buffer[1]);
                    numbers.add(value);
                    break;

                case "Remove":
                    int removeThis = Integer.parseInt(buffer[1]);

                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == removeThis) {
                            numbers.remove(i);
                            break;
                        }
                    }

                    break;

                case "Replace":
                    int value1 = Integer.parseInt(buffer[1]);
                    int value2 = Integer.parseInt(buffer[2]);

                    for (int i = 0; i < numbers.size(); i++) {

                        if (numbers.get(i) == value1) {
                            numbers.remove(i);
                            numbers.add(i, value2);
                            break;
                        }
                    }

                    break;

                case "Collapse":
                    int maxNum = Integer.parseInt(buffer[1]);

                    for (int i = 0; i < numbers.size(); i++) {

                        if (numbers.get(i) < maxNum) {
                            numbers.remove(i);
                            i--;
                        }
                    }

                    break;
            }

            commands = scanner.nextLine();
        }

        String print = numbers.toString().replace("[", "").replace("]", "").replaceAll(",", "");
        System.out.println(print);
    }
}