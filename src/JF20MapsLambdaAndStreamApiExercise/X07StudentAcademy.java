package JF20MapsLambdaAndStreamApiExercise;

/*
Write a program, which keeps the information about students and their grades.
On the first line, you will receive number n. After that, you will receive n pair of rows. First, you will receive the student's name, after that, you will receive his grade. Check if the student already exists and if not - add him. Keep track of all grades for each student.
When you finish reading data, keep students with an average grade higher or equal to 4.50.
Print the students and their average grade in the format:
"{name} –> {averageGrade}"
Format the average grade to the 2nd decimal place.
 */

import java.util.*;

public class X07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> book = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

//            if (!book.containsKey(name)) {
//                book.put(name, new ArrayList<>());
//            }
//            book.get(name).add(grade);

            List<Double> grades = new ArrayList<>();

            if (book.containsKey(name)) {
                grades = book.get(name);
            }

            grades.add(grade);
            book.put(name, grades);
        }

        List<Double> averageGrades = new ArrayList<>();

        for (Map.Entry<String, List<Double>> entry : book.entrySet()) {
            String name = entry.getKey();
            List<Double> grades = entry.getValue();
            double sum = 0;

            for (Double grade : grades) {
                sum += grade;
            }

            double averageGrade = sum / grades.size();

            if (averageGrade >= 4.50) {
                averageGrades.add(averageGrade);
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }
    }
}