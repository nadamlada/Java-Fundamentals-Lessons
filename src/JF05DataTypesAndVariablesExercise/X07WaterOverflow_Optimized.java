package JF05DataTypesAndVariablesExercise;

 /*
 You have a water tank with a capacity of 255 liters.
 On the next n lines, you will receive liters of water, which you have to pour into your tank.
 If the capacity is not enough, print "Insufficient capacity!" and continue reading the next line. On the last line, print the liters in the tank.
 Input
 The input will be on two lines:
 •	On the first line, you will receive n – the number of lines, which will follow
 •	On the next n lines – you receive quantities of water, which you have to pour into the tank
 Output
 Every time you do not have enough capacity in the tank to pour the given liters, print:
 "Insufficient capacity!".
 On the last line, print only the liters in the tank.
 Constraints
 •	n will be in the interval [1…20]
 •	liters will be in the interval [1…1000]

  */

 /*
 https://www.youtube.com/watch?app=desktop&v=rKrpYnC6jpM
 // друго решение
  */

import java.util.Scanner;

public class X07WaterOverflow_Optimized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int full = 0;
        
        for (int i = 0; i < n; i++) {
            int newLiters = Integer.parseInt(scanner.nextLine());
            full += newLiters;

            if (full > 255) {
                System.out.println("Insufficient capacity!");
                full -= newLiters;
            }
        }

        System.out.println(full);
    }
}