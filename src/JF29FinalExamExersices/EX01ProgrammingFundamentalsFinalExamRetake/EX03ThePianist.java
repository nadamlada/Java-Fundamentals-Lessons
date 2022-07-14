package JF29FinalExamExersices.EX01ProgrammingFundamentalsFinalExamRetake;

/*
You are a pianist, and you like to keep a list of your favorite piano pieces. Create a program to help you organize it and add, change, remove pieces from it!
On the first line of the standard input, you will receive an integer n – the number of pieces you will initially have. On the next n lines, the pieces themselves will follow with their composer and key, separated by "|" in the following format: "{piece}|{composer}|{key}".
Then, you will be receiving different commands, each on a new line, separated by "|", until the "Stop" command is given:
•	"Add|{piece}|{composer}|{key}":
o	You need to add the given piece with the information about it to the other pieces and print:
"{piece} by {composer} in {key} added to the collection!"
o	If the piece is already in the collection, print:
"{piece} is already in the collection!"
•	"Remove|{piece}":
o	If the piece is in the collection, remove it and print:
"Successfully removed {piece}!"
o	Otherwise, print:
"Invalid operation! {piece} does not exist in the collection."
•	"ChangeKey|{piece}|{new key}":
o	If the piece is in the collection, change its key with the given one and print:
"Changed the key of {piece} to {new key}!"
o	Otherwise, print:
"Invalid operation! {piece} does not exist in the collection."
Upon receiving the "Stop" command, you need to print all pieces in your collection in the following format:
"{Piece} -> Composer: {composer}, Key: {key}"
Input/Constraints
•	You will receive a single integer at first – the initial number of pieces in the collection
•	For each piece, you will receive a single line of text with information about it.
•	Then you will receive multiple commands in the way described above until the command "Stop".
Output
•	All the output messages with the appropriate formats are described in the problem description.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> collection = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split("\\|");
            String piece = inputs[0];
            String composer = inputs[1];
            String key = inputs[2];

            collection.put(piece, new String[2]);
            collection.get(piece)[0] = composer;
            collection.get(piece)[1] = key;
        }

        String text = scanner.nextLine();

        while (!text.equals("Stop")) {
            String[] commands = text.split("\\|");
            String currentPiece = commands[1];

            switch (commands[0]) {
                case "Add":
                    String composer = commands[2];
                    String key = commands[3];

                    if (!collection.containsKey(currentPiece)) {
                        collection.put(currentPiece, new String[2]);
                        collection.get(currentPiece)[0] = composer;
                        collection.get(currentPiece)[1] = key;
                        System.out.printf("%s by %s in %s added to the collection!%n", currentPiece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!%n", currentPiece);
                    }

                    break;

                case "Remove":

                    if (collection.containsKey(currentPiece)) {
                        collection.remove(currentPiece);
                        System.out.printf("Successfully removed %s!%n", currentPiece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    }

                    break;

                case "ChangeKey":
                    String newKey = commands[2];

                    if (collection.containsKey(currentPiece)) {
                        collection.get(currentPiece)[1] = newKey;
                        System.out.printf("Changed the key of %s to %s!%n", currentPiece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    }

                    break;
            }

            text = scanner.nextLine();
        }

        for (Map.Entry<String, String[]> entry : collection.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }
    }
}

