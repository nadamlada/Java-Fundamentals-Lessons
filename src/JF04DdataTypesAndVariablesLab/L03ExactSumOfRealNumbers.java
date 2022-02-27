package JF04DdataTypesAndVariablesLab;

/*
Write a program to enter n numbers and calculate and print their exact sum (without rounding).
 */

import java.math.BigDecimal;
import java.util.Scanner;

public class L03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());               //заради цикъла
        BigDecimal sum = new BigDecimal(0);                     // не може директна ст-ст, сравнява се само с друг биг десимал
        for (int i = 0; i < n; i++) {

            String numb = scanner.nextLine();
            BigDecimal newBigDec = new BigDecimal(numb);

            sum = sum.add(newBigDec);

        }
        System.out.println(sum);
    }
}