package JF18ObjectsAndClassesMoreExercise;

/*
Define two classes Car and Engine. A Car has a model, engine, weight, and color. An Engine has a model, power,
displacement, and efficiency. A Car’s weight and color and its Engine’s displacements and efficiency are optional.
On the first line, you will read a number N which will specify how many lines of engines you will receive, on each
of the next N lines you will receive information about an Engine in the following format
"{Model} {Power} {Displacement} {Efficiency}".
After the lines with engines, on the next line, you will receive a number M – specifying the number of
Cars that will follow, on each of the next M lines information about a Car will follow in the following format
"{Model} {Engine} {Weight} {Color}", where the engine in the format will be the model of an existing Engine.
When creating the object for a Car, you should keep a reference to the real engine in it, instead of just the engine’s model,
note that the optional properties might be missing from the formats.
Your task is to print each car (in the order you received them) and its information in the format defined below,
if any of the optional fields have not been given print "n/a" in its place instead:
{CarModel}:
  {EngineModel}:
    Power: {EnginePower}
    Displacement: {EngineDisplacement}
    Efficiency: {EngineEfficiency}
  Weight: {CarWeight}
  Color: {CarColor}
Optional
Override the classes’ ToString() methods to have a reusable way of displaying the objects.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MX03CarSalesmanPAK {

    public static class Car {
        String modelCar;
        String engineCar;
        String weightCar;
        String colorCar;
        String currentPower;
        String currentDisplacement;
        String currentEfficiency;


        public Car(String modelCar, String engineCar, String weightCar, String colorCar) {
            this.modelCar = modelCar;
            this.engineCar = engineCar;
            this.weightCar = weightCar;
            this.colorCar = colorCar;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "modelCar='" + modelCar + '\'' +
                    ", engineCar='" + engineCar + '\'' +
                    ", currentPower='" + currentPower + '\'' +
                    ", currentDisplacement='" + currentDisplacement + '\'' +
                    ", currentEfficiency='" + currentEfficiency + '\'' +
                    ", weightCar='" + weightCar + '\'' +
                    ", colorCar='" + colorCar + '\'' +
                    '}';
        }

        public String getModelCar() {
            return modelCar;
        }

        public String getEngineCar() {
            return engineCar;
        }

        public String getWeightCar() {
            return weightCar;
        }

        public String getColorCar() {
            return colorCar;
        }

    }

    public static class Engine {
        String model;
        static String power;
        static String displacement;
        static String efficiency;


        public Engine(String model, String power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public String getModel() {
            return model;
        }

        public static String getPower() {
            return power;
        }

        public static String getDisplacement() {
            return displacement;
        }

        public static String getEfficiency() {
            return efficiency;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        //engine

        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //"{Model} {Power} {Displacement} {Efficiency}
            String[] info = input.split(" ");
            String model = info[0];
            String power = info[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (info.length == 3) {
                String searched = info[2];
                if (searched.charAt(0) >= 'A' && searched.charAt(0) <= 'Z') {
                    efficiency = info[2];
                } else {
                    displacement = info[2];
                }
            }
            if (info.length == 4) {
                displacement = info[2];
                efficiency = info[3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);


            input = scanner.nextLine();
        }

        int m = Integer.parseInt(input);

        //car

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            input = scanner.nextLine();
            //"{Model} {Engine} {Weight} {Color}

            String[] info2 = input.split(" ");
            String modelCar = info2[0];
            String engineCar = info2[1];
            //"{Model} {Power} {Displacement} {Efficiency}
            if (engines.contains(engineCar)) {
                String currentPower = Engine.getPower();
                String currentDisplacement = Engine.getDisplacement();
                String currentEfficiency = Engine.getEfficiency();
            }

            String weightCar = "n/a";
            String colorCar = "n/a";

            if (info2.length == 3) {
                String searched = info2[2];
                if (searched.charAt(0) >= 'A' && searched.charAt(0) <= 'Z') {
                    colorCar = info2[2];
                } else {
                    weightCar = info2[2];
                }
            }
            if (info2.length == 4) {
                weightCar = info2[2];
                weightCar = info2[3];
            }

            Car car = new Car(modelCar, engineCar, weightCar, colorCar);
            cars.add(car);
        }
        cars.stream().forEach(s -> System.out.println(s.toString()));

    }
}

