package JF15MidExamExercises.EX02ProgrammingFundamentalsMidExam;

/*
Every day, thousands of students pass by the reception at SoftUni with different questions to ask. The employees have to help everyone by providing all the information and answering all of the questions.
Three employees are working on the reception all day. Each of them can handle a different number of students per hour. Your task is to calculate how much time it will take to answer all the questions of a given number of students.
First, you will receive 3 lines with integers, representing the number of students that each employee can help per hour. On the following line, you will receive students count as a single integer.
Every fourth hour, all employees have a break, so they don't work for an hour. It is the only break for the employees, because they don't need rest, nor have a personal life. Calculate the time needed to answer all the student's questions and print it in the following format: "Time needed: {time}h."
Input / Constraints
•	On the first three lines -  each employee efficiency -  integer in the range [1 - 100]
•	On the fourth line - students count – integer in the range [0 – 10000]
•	Input will always be valid and in the range specified
Output
•	Print a single line: "Time needed: {time}h."
•	Allowed working time / memory: 100ms / 16MB
 */

import java.util.Scanner;

public class EX01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int bStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int cStudentsPerHour = Integer.parseInt(scanner.nextLine());

        int allWork = Integer.parseInt(scanner.nextLine());

        int workPerHour = aStudentsPerHour +
                bStudentsPerHour +
                cStudentsPerHour;

        int counterHours = 0;

        while (allWork > 0) {
            counterHours++;

            if (counterHours % 4 != 0) {
                allWork -= workPerHour;
            }
        }

        System.out.printf("Time needed: %dh.", counterHours);
    }
}