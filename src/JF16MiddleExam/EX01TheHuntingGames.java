package JF16MiddleExam;

import java.util.Scanner;

public class EX01TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysAll = Integer.parseInt(scanner.nextLine());
        int qtyPlayers = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());

        double waterPerDayPerOne = Double.parseDouble(scanner.nextLine());
        double foodPerDayPerOne = Double.parseDouble(scanner.nextLine());

        double waterLeft = waterPerDayPerOne * qtyPlayers * daysAll;
        double foodLeft = foodPerDayPerOne * qtyPlayers * daysAll;
        double energyLeft = groupEnergy;

        for (int i = 1; i <= daysAll; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            energyLeft -= energyLoss;

            if (energyLeft <= 0) {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", foodLeft, waterLeft);
                break;
            }

            if (i % 2 == 0) {
                energyLeft = 0.05 * energyLeft + energyLeft;
                waterLeft = waterLeft - 0.30 * waterLeft;
            }

            if (i % 3 == 0) {
                double amount = foodLeft / qtyPlayers;
                foodLeft -= amount;
                energyLeft = 0.10 * energyLeft + energyLeft;
            }
        }

        if (energyLeft > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energyLeft);
        }
    }
}