package JF19ObjectsAndClassesMoreExercise;//package JFObjectsAndClassesMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MX03CarSalesman {
    public static class Car {
        private String carModel;
        private String carEngine;
        private String carWeight;
        private String carColor;


        public Car(String carModel, String carEngine, String carWeight, String carColor) {
            this.carModel = carModel;
            this.carEngine = carEngine;
            this.carWeight = carWeight;
            this.carColor = carColor;
        }

        @Override
        public String toString() {
            return String.format("%s:%n" +
                            " %s" +
                            " Weight: %s%n" +
                            " Color: %s%n"
                    , getCarModel(), getCarEngine(), getCarWeight(), getCarColor());
        }

        public String getCarModel() {
            return carModel;
        }

        public void setCarModel(String carModel) {
            this.carModel = carModel;
        }

        public String getCarEngine() {
            return carEngine;
        }

        public void setCarEngine(String carEngine) {
            this.carEngine = carEngine;
        }

        public String getCarWeight() {
            return carWeight;
        }

        public void setCarWeight(String carWeight) {
            this.carWeight = carWeight;
        }

        public String getCarColor() {
            return carColor;
        }

        public void setCarColor(String carColor) {
            this.carColor = carColor;
        }
    }

    public static class Engine {
        private String engineModel;
        private String enginePower;
        private String engineDisplacement;
        private String engineEfficiency;

        @Override
        public String toString() {
            return String.format("  %s:%n" +
                    "    Power: %s%n" +
                    "    Displacement: %s%n" +
                    "    Efficiency: %s%n", getEngineModel(), getEnginePower(), getEngineDisplacement(), getEngineEfficiency());
        }

        public Engine(String engineModel, String enginePower, String engineDisplacement, String engineEfficiency) {
            this.engineModel = engineModel;
            this.enginePower = enginePower;
            this.engineDisplacement = engineDisplacement;
            this.engineEfficiency = engineEfficiency;
        }

        public String getEngineModel() {
            return engineModel;
        }

        public void setEngineModel(String engineModel) {
            this.engineModel = engineModel;
        }

        public String getEnginePower() {
            return enginePower;
        }

        public void setEnginePower(String enginePower) {
            this.enginePower = enginePower;
        }

        public String getEngineDisplacement() {
            return engineDisplacement;
        }

        public void setEngineDisplacement(String engineDisplacement) {
            this.engineDisplacement = engineDisplacement;
        }

        public String getEngineEfficiency() {
            return engineEfficiency;
        }

        public void setEngineEfficiency(String engineEfficiency) {
            this.engineEfficiency = engineEfficiency;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String engineModel = "n/a";
        String enginePower = "n/a";
        String engineDisplacement = "n/a";
        String engineEfficiency = "n/a";


        List<Engine> engines = new ArrayList<>();

        //engines
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            //"{Model} {Power} {Displacement} {Efficiency}
            String[] inputEngine = scanner.nextLine().split(" ");

            if (inputEngine.length == 4) {
                engineModel = inputEngine[0];
                enginePower = inputEngine[1];
                engineDisplacement = inputEngine[2];
                engineEfficiency = inputEngine[3];
            } else if (inputEngine.length == 3) {

                if (inputEngine[2].charAt(0) >= 'A' && inputEngine[2].charAt(0) <= 'Z') {
                    engineEfficiency = inputEngine[2];
                } else {
                    engineDisplacement = inputEngine[2];
                }
            }

            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engines.add(engine);
        }


        List<Car> cars = new ArrayList<>();

        //cars
        int m = Integer.parseInt(scanner.nextLine());

        String carModel = "n/a";
        String carEngine = "n/a";
        String carWeight = "n/a";
        String carColor = "n/a";


        for (int i = 0; i < m; i++) {
            //"{Model} {Engine} {Weight} {Color}
            String[] inputCar = scanner.nextLine().split(" ");

            if (inputCar.length == 4) {
                carModel = inputCar[0];
                carEngine = inputCar[1];
                carWeight = inputCar[2];
                carColor = inputCar[3];
            } else if (inputCar.length == 3) {
                if (inputCar[2].charAt(0) >= 'A' && inputCar[2].charAt(0) <= 'Z') {
                    carColor = inputCar[2];
                } else {
                    carWeight = inputCar[2];
                }
            }

            Car car = new Car(carModel, carEngine, carWeight, carColor);
            cars.add(car);
        }

        cars.stream().forEach(s -> System.out.println(cars.toString()));
    }
}