package JF29FinalExamExersices.EXProgrammingFundamentaAdditionalRetakeExam10January2019PartII;

/*
Santa needs to start creating his new list for the next Christmas. Your job is to help him receive and keep the incoming information. He will receive information about the names of the children, the type of present they want (toy, candy, clothing) and the wanted amount in the following format:
{childName}->{typeOfToy}->{amount}
You can receive a command “Remove->{childName}”. In this case, you need to exclude the child from the new list with good children, but don’t change the information about the type of present he or she wanted and the wanted amount. Santa has already gotten the presents, so he might give them to another very good child.
When you receive the “END” command, you need to process it and print it, ordered descending by the total amount of presents for a child and then by their names. The format is given bellow.
Input
Until you receive "END" command you will be receiving information about the wanted presents in the following format:
 "{childName}->{typeOfPresent}->{amount}".
You can receive a command to remove a child from the list -> "Remove->{childName}"
Output
•	Print the presents for each child, ordered descending by the total amount and then by their name, in the following format:
Children:
{childName} -> {points}
•	After that print type of present and the total count for it in the following format:
Presents:
{type} –> {count}
Constraints
•	The count of presents will always be a valid integer in the range [0-100];
 */

import java.util.*;

public class X04SantasNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> kidsQuantity = new TreeMap<>();
        Map<String, Integer> giftQuantity = new LinkedHashMap<>();

        while (!input.equals("END")) {
            String[] commands = input.split("->");

            if (commands.length == 2) {
                String childName = commands[1];
                kidsQuantity.remove(childName);
            } else {
                String childName = commands[0];
                String typeOfToy = commands[1];
                int amount = Integer.parseInt(commands[2]);

                kidsQuantity.putIfAbsent(childName, 0);
                int currentAmount = kidsQuantity.get(childName) + amount;
                kidsQuantity.put(childName, currentAmount);

                giftQuantity.putIfAbsent(typeOfToy, 0);
                int currentToysAmount = giftQuantity.get(typeOfToy) + amount;
                giftQuantity.put(typeOfToy, currentToysAmount);
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        // сортираме по values, и ако са еднакви keys са по азбучен ред
        // 1. правим оригиналния мап да е treMaр,за да са по азбучен ред
        // 2. новосъздадения мап, в който ги местим е LinkedHashMap
        kidsQuantity.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.printf("Children:%n");

        for (Map.Entry<String, Integer> entry : reverseSortedMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

        System.out.printf("Presents:%n");

        for (Map.Entry<String, Integer> entry : giftQuantity.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
