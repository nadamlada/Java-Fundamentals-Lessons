package JF29FinalExamExersices.EXExamTasksOfOthers;

import java.util.Scanner;

public class X01StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String commands = scanner.nextLine();

        StringBuilder sb = new StringBuilder(input);
        while (!commands.equals("Done")) {
            String[] buff = commands.split(" ");

            switch (buff[0]) {
                case "Change":
                    String forReplace = buff[1];
                    String newString = buff[2];

                    //replace all Заменя стрингове
                    //replace заменя чарове

                    String buffer = sb.toString().replaceAll(forReplace, newString);
                    System.out.println(buffer);
                    sb = new StringBuilder(buffer);
                    break;

                case "Includes":
                    String substring = buff[1];

                    if (sb.toString().contains(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }

                    break;

                case "End":
                    substring = buff[1];
                    buffer = sb.substring(sb.length() - substring.length() + 1, sb.length());

                    if (buffer.equals(substring)) {
                        System.out.println("TrueEnd");
                    } else {
                        System.out.println("False");
                    }

                    break;

                case "Uppercase":
                    String buff2 = sb.toString().toUpperCase();
                    System.out.println(buff2);
                    sb = new StringBuilder(buff2);
                    break;

                case "FindIndex":
                    String findChar = buff[1];
                    int index = sb.indexOf(findChar);
                    System.out.println(index);
                    break;

                case "Cut":

                    int startIndex = Integer.parseInt(buff[1]);
                    int count = Integer.parseInt(buff[2]);

                    String buff3 = sb.substring(startIndex, startIndex + count);
                    System.out.println(buff3);
                    sb = new StringBuilder(buff3);
                    break;
            }

            commands = scanner.nextLine();
        }
    }
}