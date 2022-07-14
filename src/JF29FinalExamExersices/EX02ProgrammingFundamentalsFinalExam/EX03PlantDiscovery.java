package JF29FinalExamExersices.EX02ProgrammingFundamentalsFinalExam;

/*
You have now returned from your world tour. On your way, you have discovered some new plants, and you want to gather some information about them and create an exhibition to see which plant is highest rated.
On the first line, you will receive a number n. On the next n lines, you will be given some information about the plants that you have discovered in the format: "{plant}<->{rarity}". Store that information because you will need it later. If you receive a plant more than once, update its rarity.
After that, until you receive the command "Exhibition", you will be given some of these commands:
•	"Rate: {plant} - {rating}" – add the given rating to the plant (store all ratings)
•	"Update: {plant} - {new_rarity}" – update the rarity of the plant with the new one
•	"Reset: {plant}" – remove all the ratings of the given plant
Note: If any given plant name is invalid, print "error"
After the command "Exhibition", print the information that you have about the plants in the following format:
"Plants for the exhibition:
- {plant_name1}; Rarity: {rarity}; Rating: {average_rating}
- {plant_name2}; Rarity: {rarity}; Rating: {average_rating}
…
- {plant_nameN}; Rarity: {rarity}; Rating: {average_rating}"
The average rating should be formatted to the second decimal place.
Input / Constraints
•	You will receive the input as described above
•	JavaScript: you will receive a list of strings
Output
•	Print the information about all plants as described above
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, int[]> dictionary = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split("<->");
            String plant = inputs[0];
            int rarity = Integer.parseInt(inputs[1]);
            dictionary.put(plant, new int[3]);
            dictionary.get(plant)[0] = rarity;
            //counter in [2];
            dictionary.get(plant)[2] = 0;
        }

        String text = scanner.nextLine();

        while (!text.equals("Exhibition")) {
            String[] commands = text.split(" ");
            String currentPlant = commands[1];

            if (!(dictionary.containsKey(currentPlant))) {
                System.out.println("error");
            } else {

                switch (commands[0]) {
                    case "Rate:":
                        int rating = Integer.parseInt(commands[3]);
                        int sumRatings = dictionary.get(currentPlant)[1] + rating;
                        dictionary.get(currentPlant)[1] = sumRatings;
                        dictionary.get(currentPlant)[2] += 1;
                        break;

                    case "Update:":
                        int newRarity = Integer.parseInt(commands[3]);
                        dictionary.get(currentPlant)[0] = newRarity;
                        break;

                    case "Reset:":
                        dictionary.get(currentPlant)[1] = 0;
                        dictionary.get(currentPlant)[2] = 0;
                }
            }

            text = scanner.nextLine();
        }

        System.out.printf("Plants for the exhibition:%n");

        for (Map.Entry<String, int[]> entry : dictionary.entrySet()) {
            double average = 0.00;

            if (entry.getValue()[1] != 0) {
                average = entry.getValue()[1] * 1.00 / entry.getValue()[2];
            }

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                    entry.getKey(), entry.getValue()[0], average);
        }
    }
}

