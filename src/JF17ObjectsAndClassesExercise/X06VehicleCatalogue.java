package JF17ObjectsAndClassesExercise;

/*
You have to make a catalog for vehicles. You will receive two types of vehicles - a car or a truck.
Until you receive the command "End" you will receive lines of input in the format:
{typeOfVehicle} {model} {color} {horsepower}
After the "End" command, you will start receiving models of vehicles. Print for every received vehicle its data in the format:
Type: {typeOfVehicle}
Model: {modelOfVehicle}
Color: {colorOfVehicle}
Horsepower: {horsepowerOfVehicle}

When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower for the cars and the trucks in the format:
"{typeOfVehicles} have average horsepower of {averageHorsepower}."
The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type by the total count of vehicles from the same type.
Format the answer to the 2nd decimal point.
Constraints
•	The type of vehicle will always be a car or truck.
•	You will not receive the same model twice.
•	The received horsepower will be an integer in the interval [1…1000].
•	You will receive at most 50 vehicles.
•	Single whitespace will be used for the separator.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X06VehicleCatalogue {


    public static class Vehicle {
        /*
        Type: {typeOfVehicle}
        Model: {modelOfVehicle}
        Color: {colorOfVehicle}
        Horsepower: {horsepowerOfVehicle}
         */
        String typeOfVehicle;
        String modelOfVehicle;
        String colorOfVehicle;
        int horsepowerOfVehicle;

        public Vehicle(String typeOfVehicle, String modelOfVehicle, String colorOfVehicle, int horsepowerOfVehicle) {
            this.typeOfVehicle = typeOfVehicle;
            this.modelOfVehicle = modelOfVehicle;
            this.colorOfVehicle = colorOfVehicle;
            this.horsepowerOfVehicle = horsepowerOfVehicle;
        }

        public String getModelOfVehicle() {
            return this.modelOfVehicle;
        }

        public double getHorsepower() {
            return this.horsepowerOfVehicle;
        }

        @Override
        public String toString() {
            if (this.typeOfVehicle.equals("car")) {
                this.typeOfVehicle = "Car";
            }
            if (this.typeOfVehicle.equals("truck")) {
                this.typeOfVehicle = "Truck";
            }

            return String.format("Type: %s%n" +
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %s", this.typeOfVehicle, this.modelOfVehicle, this.colorOfVehicle, this.horsepowerOfVehicle);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();
        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();

        double sumCar = 0;
        double sumTruck = 0;

        while (!input.equals("End")) {
            //{typeOfVehicle} {model} {color} {horsepower}
            String[] commands = input.split(" ");

            String typeOfVehicle = commands[0];
            String modelOfVehicle = commands[1];
            String colorOfVehicle = commands[2];
            int horsepowerOfVehicle = Integer.parseInt(commands[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, modelOfVehicle, colorOfVehicle, horsepowerOfVehicle);
            vehicles.add(vehicle);

            if (typeOfVehicle.equals("car")) {
                cars.add(vehicle);
                sumCar += vehicle.getHorsepower();
            } else if (typeOfVehicle.equals("truck")) {
                trucks.add(vehicle);
                sumTruck += vehicle.getHorsepower();
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("Close the Catalogue")) {

            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModelOfVehicle().equals(input)) {
                    System.out.println(vehicle);
                }
            }

            input = scanner.nextLine();
        }

        double avgCars = sumCar / cars.size();
        double avgTrucks = sumTruck / trucks.size();

        if (cars.isEmpty()) {
            avgCars = 0.00;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", avgCars);

        if (trucks.isEmpty()) {
            avgTrucks = 0.00;
        }

        System.out.printf("Trucks have average horsepower of: %.2f.%n", avgTrucks);
    }
}