package JF20MapsLambdaAndStreamApiExercise;

/*
Write a program, which keeps the information about courses. Each course has a name and registered students.
You will receive the course name and student name until you receive the command "end". Check if such a course already exists and if not - add the course. Register the user into the course. When you do receive the command "end", print the courses with their names and total registered users. For each contest, print the registered users.
Input
•	Until you receive "end", the input come in the format: "{courseName} : {studentName}".
•	The product data is always delimited by " : ".
Output
•	Print information about each course, following the format:
"{courseName}: {registeredStudents}"
•	Print information about each student, following the format:
"-- {studentName}"
 */

import java.util.*;

public class X06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> book = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] enquiery = input.split(" : ");
            String course = enquiery[0];
            String student = enquiery[1];

            if (!book.containsKey(course)) {
                List<String> students = new ArrayList<>();
                students.add(student);
                book.put(course, students);
            } else {
                List<String> students = book.get(course);
                students.add(student);
                book.put(course, students);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : book.entrySet()) {
            List<String> students = entry.getValue();
            int qtyStudents = students.size();
            System.out.printf("%s: %d%n", entry.getKey(), qtyStudents);
            for (String student : students) {
                System.out.println("-- " + student);
            }
        }
    }
}