package JF22TextProcessingLab;

/*
On the first line, you will receive a string. On the second line, you will receive a second string.
Write a program that removes all of the occurrences of the first string in the second until there is no match.
At the end print the remaining string.
 */

import java.util.Scanner;

public class L03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyword = scanner.nextLine();
        String text = scanner.nextLine();

        int index = text.indexOf(keyword);
//        while(index != -1){
//           String firstPart = text.substring(0,index);
//           String secondPart = text.substring(index + keyword.length());
//           text = firstPart + secondPart;
//
//           index = text.indexOf(keyword);
//        }

        while (index != -1) {
            text = text.replace(keyword, "");
            index = text.indexOf(keyword);
        }

        System.out.println(text);
    }
}