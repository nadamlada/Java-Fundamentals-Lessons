package JF29FinalExamExersices.EX03ProgrammingFundamentalsFinalExamRetake;

/*
You have just bought the latest and greatest computer game – Need for Seed III. Pick your favorite cars and drive them all you want! We know that you can't wait to start playing.
On the first line of the standard input, you will receive an integer n – the number of cars that you can obtain. On the next n lines, the cars themselves will follow with their mileage and fuel available, separated by "|" in the following format:
"{car}|{mileage}|{fuel}"
Then, you will be receiving different commands, each on a new line, separated by " : ", until the "Stop" command is given:
•	"Drive : {car} : {distance} : {fuel}":
o	You need to drive the given distance, and you will need the given fuel to do that. If the car doesn't have enough fuel, print: "Not enough fuel to make that ride"
o	If the car has the required fuel available in the tank, increase its mileage with the given distance, decrease its fuel with the given fuel, and print:
"{car} driven for {distance} kilometers. {fuel} liters of fuel consumed."
o	You like driving new cars only, so if a car's mileage reaches 100 000 km, remove it from the collection(s) and print: "Time to sell the {car}!"
•	"Refuel : {car} : {fuel}":
o	Refill the tank of your car.
o	Each tank can hold a maximum of 75 liters of fuel, so if the given amount of fuel is more than you can fit in the tank, take only what is required to fill it up.
o	Print a message in the following format: "{car} refueled with {fuel} liters"
•	"Revert : {car} : {kilometers}":
o	Decrease the mileage of the given car with the given kilometers and print the kilometers you have decreased it with in the following format:
"{car} mileage decreased by {amount reverted} kilometers"
o	If the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km and
DO NOT print anything.
Upon receiving the "Stop" command, you need to print all cars in your possession in the following format:
"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
Input/Constraints
•	The mileage and fuel of the cars will be valid, 32-bit integers, and will never be negative.
•	The fuel and distance amounts in the commands will never be negative.
•	The car names in the commands will always be valid cars in your possession.
Output
•	All the output messages with the appropriate formats are described in the problem description.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03NeedForSpeedIii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, int[]> catalog = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split("\\|");
            String car = inputs[0];
            int miles = Integer.parseInt(inputs[1]);
            int fuel = Integer.parseInt(inputs[2]);

            catalog.putIfAbsent(car, new int[2]);
            catalog.get(car)[0] = miles;
            catalog.get(car)[1] = fuel;
        }

        String newInput = scanner.nextLine();

        while (!newInput.equals("Stop")) {
            String[] commands = newInput.split(" : ");
            String currentCar = commands[1];

            switch (commands[0]) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuel = Integer.parseInt(commands[3]);

                    if (catalog.get(currentCar)[1] < fuel) {
                        System.out.printf("Not enough fuel to make that ride%n");
                    } else {
                        catalog.get(currentCar)[0] += distance;
                        catalog.get(currentCar)[1] -= fuel;

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                currentCar, distance, fuel);

                        if (catalog.get(currentCar)[0] > 100000) {
                            catalog.remove(currentCar);
                            System.out.printf("Time to sell the %s!%n", currentCar);
                        }
                    }

                    break;

                case "Refuel":
                    int currentLiters = catalog.get(currentCar)[1];
                    fuel = Integer.parseInt(commands[2]);

                    catalog.get(currentCar)[1] += fuel;

                    if (catalog.get(currentCar)[1] > 75) {
                        catalog.get(currentCar)[1] = 75;
                        fuel = 75 - currentLiters;
                    }

                    System.out.printf("%s refueled with %d liters%n", currentCar, fuel);
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(commands[2]);
                    catalog.get(currentCar)[0] -= kilometers;

                    if (catalog.get(currentCar)[0] < 10000) {
                        catalog.get(currentCar)[0] = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", currentCar, kilometers);
                    }

                    break;
            }

            newInput = scanner.nextLine();
        }

        for (Map.Entry<String, int[]> entry : catalog.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }
    }
}
