package JF29FinalExamExersices.EXExamTasksOfOthers;

import java.util.Scanner;

public class X01Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searched = scanner.nextLine();

        String newInputForCommands = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        while (!newInputForCommands.equals("Abracadabra")) {
            String[] commands = newInputForCommands.split(" ");

            switch (commands[0]) {
                case "Abjuration":
                    searched = searched.toUpperCase();
                    System.out.println(searched);
                    break;

                case "Necromancy":
                    searched = searched.toLowerCase();
                    System.out.println(searched);
                    break;

                case "Illusion":
                    //replace the letter at the index with given one letter
                    int index = Integer.parseInt(commands[1]);

                    //ако индекса е валиден
                    if (index < 0 || index >= searched.length()) {
                        System.out.printf("The spell was too weak!%n");
                        break;
                    } else {
                        String letter = commands[2];
                        sb = new StringBuilder(searched);
                        sb.replace(index, index + 1, letter);
                        System.out.printf("Done!%n");
                        searched = sb.toString();
                    }

                    break;

                case "Divination":
                    String firstSubstring = commands[1];
                    String secondSubstring = commands[2];

                    if (searched.contains(firstSubstring)) {
                        sb = new StringBuilder(searched);
                        int startIndexOfTextForReplacement = sb.indexOf(firstSubstring);
                        int endIndexOfTextForReplacement = sb.indexOf((firstSubstring) + firstSubstring.length());

                        sb.replace(startIndexOfTextForReplacement, endIndexOfTextForReplacement, secondSubstring);
                        searched = sb.toString();
                    }

                    break;

                case "Alteration":
                    String substring = commands[1];
                   String buff = searched.replace(substring, "");
                    System.out.printf("%s%n", buff);
                    searched = buff;
                    break;

                default:
                    System.out.printf("The spell did not work!%n");
            }

            newInputForCommands = scanner.nextLine();
        }
    }
}
