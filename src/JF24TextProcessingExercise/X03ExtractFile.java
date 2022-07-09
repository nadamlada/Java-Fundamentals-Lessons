package JF24TextProcessingExercise;

/*
Write a program that reads the path to a file and subtracts the file name and its extension.
 */

import java.util.Scanner;

public class X03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // \\\\ -> escapes \
        String[] fullPath = input.split("\\\\");
        String filenameExtension = fullPath[fullPath.length - 1];
        // \\. -> escapes .
        String[] fileNames = filenameExtension.split("\\.");
        String fileName = fileNames[0];
        String extension = fileNames[1];

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s", extension);
    }
}