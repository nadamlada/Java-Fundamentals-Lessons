package JF10MethodsLab;

/*
Write a method that receives a grade between 2.00 and 6.00 and prints the corresponding grade in words:
•	2.00 – 2.99 - "Fail"
•	3.00 – 3.49 - "Poor"
•	3.50 – 4.49 - "Good"
•	4.50 – 5.49 - "Very good"
•	5.50 – 6.00 - "Excellent
 */

import java.util.Scanner;

public class L02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());

        gradeInText(n);
    }

    public static void gradeInText(double n) {

        String grade = "";
        if (2 <= n && n < 3) {
            grade = "Fail";
        } else if (3 <= n && n < 3.50) {
            grade = "Poor";
        } else if (3.50 <= n && n < 4.50) {
            grade = "Good ";
        } else if (4.50 <= n && n < 5.50) {
            grade = "Very good ";
        } else {
            grade = "Excellent";
        }

        System.out.println(grade);
    }
}