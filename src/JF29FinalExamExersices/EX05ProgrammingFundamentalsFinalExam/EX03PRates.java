package JF29FinalExamExersices.EX05ProgrammingFundamentalsFinalExam;

/*
Anno 1681. The Caribbean. The golden age of piracy. You are a well-known pirate captain by the name of Jack Daniels. Together with your comrades Jim (Beam) and Johnny (Walker), you have been roaming the seas, looking for gold and treasure… and the occasional killing, of course. Go ahead, target some wealthy settlements and show them the pirate's way!
Until the "Sail" command is given, you will be receiving:
•	You and your crew have targeted cities, with their population and gold, separated by "||".
•	If you receive a city that has already been received, you have to increase the population and gold with the given values.
After the "Sail" command, you will start receiving lines of text representing events until the "End" command is given.
Events will be in the following format:
•	"Plunder=>{town}=>{people}=>{gold}"
o	You have successfully attacked and plundered the town, killing the given number of people and stealing the respective amount of gold.
o	For every town you attack print this message: "{town} plundered! {gold} gold stolen, {people} citizens killed."
o	If any of those two values (population or gold) reaches zero, the town is disbanded.
	You need to remove it from your collection of targeted cities and print the following message: "{town} has been wiped off the map!"
o	There will be no case of receiving more people or gold than there is in the city.
•	"Prosper=>{town}=>{gold}"
o	There has been dramatic economic growth in the given city, increasing its treasury by the given amount of gold.
o	The gold amount can be a negative number, so be careful. If a negative amount of gold is given, print: "Gold added cannot be a negative number!" and ignore the command.
o	If the given gold is a valid amount, increase the town's gold reserves by the respective amount and print the following message:
"{gold added} gold added to the city treasury. {town} now has {total gold} gold."
Input
•	On the first lines, until the "Sail" command, you will be receiving strings representing the cities with their gold and population, separated by "||"
•	On the following lines, until the "End" command, you will be receiving strings representing the actions described above, separated by "=>"
Output
•	After receiving the "End" command, if there are any existing settlements on your list of targets, you need to print all of them, in the following format:
"Ahoy, Captain! There are {count} wealthy settlements to go to:
{town1} -> Population: {people} citizens, Gold: {gold} kg
{town2} -> Population: {people} citizens, Gold: {gold} kg
   …
{town…n} -> Population: {people} citizens, Gold: {gold} kg"
•	If there are no settlements left to plunder, print:
"Ahoy, Captain! All targets have been plundered and destroyed!"
Constraints
•	The initial population and gold of the settlements will be valid 32-bit integers, never negative, or exceed the respective limits.
•	The town names in the events will always be valid towns that should be on your list.
 */

import java.util.*;

public class EX03PRates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Integer>> data = new LinkedHashMap<>();

        String city = null;
        int population = 0;
        int gold = 0;

        while (!input.equals("Sail")) {
            String[] dataInput = input.split("\\|\\|");
            city = dataInput[0];
            population = Integer.parseInt(dataInput[1]);
            gold = Integer.parseInt(dataInput[2]);

            if (data.containsKey(city)) {
                int currentPopulation = data.get(city).get(0);
                int currentGold = data.get(city).get(1);
                //в листа на позиция нула сложи currentPopulation + population
                data.get(city).set(0, currentPopulation + population);
                // в листа на позиция едно сложи currentGold + gold
                data.get(city).set(1, currentGold + gold);
            } else {
                data.put(city, new ArrayList<>());
                data.get(city).add(population);
                data.get(city).add(gold);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split("=>");
            city = commands[1];
            int currentPopulation = data.get(city).get(0);
            int currentGold = data.get(city).get(1);

            switch (commands[0]) {
                case "Plunder":
                    int killedPeople = Integer.parseInt(commands[2]);
                    int stolenGold = Integer.parseInt(commands[3]);
                    data.get(city).set(0, currentPopulation - killedPeople);
                    data.get(city).set(1, currentGold - stolenGold);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, stolenGold, killedPeople);

                    if ((data.get(city).get(0) == 0) || (data.get(city).get(1) == 0)) {
                        data.remove(city);
                        System.out.printf("%s has been wiped off the map!%n", city);
                    }

                    break;

                case "Prosper":
                    int addGold = Integer.parseInt(commands[2]);
                    if (addGold < 0) {
                        System.out.printf("Gold added cannot be a negative number!%n");
                    } else if (addGold > 0) {
                        data.get(city).set(1, currentGold + addGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", addGold, city, data.get(city).get(1));
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        if (!data.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", data.size());

            for (Map.Entry<String, List<Integer>> entry : data.entrySet()) {
                List<Integer> print = entry.getValue();
                int printPopulation = print.get(0);
                int printGold = print.get(1);
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), printPopulation, printGold);
            }

        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}