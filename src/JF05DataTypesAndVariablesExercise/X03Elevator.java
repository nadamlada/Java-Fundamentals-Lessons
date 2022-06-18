package JF05DataTypesAndVariablesExercise;

/*
Calculate how many courses will be needed to elevate n persons by using an elevator with a capacity of p persons.
The input holds two lines: the number of people n and the capacity p of the elevator.
 */

import java.util.Scanner;

public class X03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int qtyPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int fullCourses = qtyPeople / capacity;              //колко човека са в пълен курс
        int lastCourse = qtyPeople % capacity;             //колко човека са в последния курс

        if (lastCourse > 0) {
            fullCourses += 1;
        }

        System.out.println(fullCourses);
    }
}