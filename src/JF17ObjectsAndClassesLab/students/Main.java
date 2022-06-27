package JF17ObjectsAndClassesLab.students;

/*
Define a class Student, which holds the following information about students: first name, last name, age, and hometown.
Read the list of students until you receive the "end" command. After that, you will receive a city name. Print only students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".
 */

import JF17ObjectsAndClassesLab.students.L06Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<L06Students.Student> students = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] dataArray = input.split(" ");
            String firstName = dataArray[0];
            String lastName = dataArray[1];
            String age = dataArray[2];
            String town = dataArray[3];

            int index = indexOfStudent(students, firstName, lastName);

            if (index == -1) {
                students.add(new L06Students.Student(firstName, lastName, age, town));
            } else {
                students.set(index, new L06Students.Student(firstName, lastName, age, town));
            }

            input = scanner.nextLine();
        }

        String searchedTown = scanner.nextLine();

        for (L06Students.Student student : students) {
            if (student.getTown().equals(searchedTown)) {
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static int indexOfStudent(List<L06Students.Student> students, String firstName, String lastName) {

        for (int i = 0; i < students.size(); i++) {
            L06Students.Student student = students.get(i);

            if (student.getFirstName().equals(firstName) && (student.getLastName().equals(lastName))) {
                return i;
            }
        }

        return -1;
    }
}