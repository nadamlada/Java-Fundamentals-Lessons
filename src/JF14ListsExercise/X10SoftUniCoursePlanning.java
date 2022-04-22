package JF14ListsExercise;

/*
You are tasked to help plan the next Programming Fundamentals course by keeping track of the lessons, that are going to be included in the course, as well as all the exercises for the lessons.
On the first input line, you will receive the initial schedule of lessons and exercises that are going to be part of the next course, separated by comma and space ", ". But before the course starts, there are some changes to be made. Until you receive "course start" you will be given some commands to modify the course schedule. The possible commands are:
Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
Insert:{lessonTitle}:{index} -insert the lesson to the given index, if it does not exist
Remove:{lessonTitle} -remove the lesson, if it exists
Swap:{lessonTitle}:{lessonTitle} -change the place of the two lessons, if they exist
Exercise:{lessonTitle} -add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already, in the following format "{lessonTitle}-Exercise". If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.
Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.
Input
•	On the first line -the initial schedule lessons -strings, separated by comma and space ", ".
•	Until "course start" you will receive commands in the format described above.
Output
•	Print the whole course schedule, each lesson on a new line with its number(index) in the schedule:
"{lesson index}.{lessonTitle}".
•	Allowed working time / memory: 100ms / 16MB.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> themes = new ArrayList<>();
        String[] buffer = input.split(", ");

        for (String s : buffer) {
            themes.add(s);
        }

        String whenToStop = scanner.nextLine();

        while (!whenToStop.equals("course start")) {
            String[] commands = whenToStop.split(":");
            String firstCommand = commands[0];
            String lessonTitle = commands[1];

            switch (firstCommand) {
                case "Add":
                    // ако тайтъл не съществува го добави накрая
                    if (!themes.contains(lessonTitle)) {
                        themes.add(lessonTitle);
                    }
                    break;

                case "Insert":
                    //ако тайтъл не съществува го добави на този индекс
                    int index = Integer.parseInt(commands[2]);
                    if (!themes.contains(lessonTitle)) {
                        themes.add(index, lessonTitle);
                    }
                    break;

                case "Remove":
                    // ако тайтъла е в списъка, го премахни
                    // направи същото с exercise (ако има упражнение след урока)

                    if (themes.contains(lessonTitle)) {
                        themes.remove(lessonTitle);
                    }

                    int indexLesson = themes.indexOf(lessonTitle);

                    if (themes.get(indexLesson + 1).equals(lessonTitle + "-Exercise ")) {
                        themes.remove(indexLesson + 1);
                    }
                    break;

                case "Swap":
                    //смени местата на двата тайтъла, ако са в списъка
                    // направи същото с exercise (ако има упражнение след урока)
                    String lessonTitleNext = commands[2];

                    if (themes.contains(lessonTitle) && themes.contains(lessonTitleNext)) {

                        int indexOfLessonNext = themes.indexOf(lessonTitleNext);
                        int indexOfLesson = themes.indexOf(lessonTitle);

                        themes.set(indexOfLessonNext, lessonTitle);
                        themes.set(indexOfLesson, lessonTitleNext);

                        //ако след Lesson има упражнение
                        String exercise = lessonTitle + "-Exercise ";
                        //ако след лесън некст има упражнение
                        String exerciseNext = lessonTitleNext + "-Exercise ";

                        if (themes.contains(exercise)) {
                            themes.remove(themes.indexOf(exercise));
                            themes.add(themes.indexOf(lessonTitle + 1), exercise);
                        }

                        if (themes.contains(exerciseNext)) {
                            themes.remove(themes.indexOf(exerciseNext));
                            themes.add(themes.indexOf(lessonTitleNext) + 1, exerciseNext);
                        }
                    }
                    break;

                case "Exercise":

                    //ако има урок с името на упражнението && след него няма упражнение
                    //добави упражнението точно след урока
                    // формат "{lessonTitle}-Exercise

                    int indexOfLesson = themes.indexOf(lessonTitle);
                    String exercise = lessonTitle + "-Exercise ";

                    if (themes.contains(lessonTitle) && !themes.contains(exercise)) {
                        themes.add(indexOfLesson + 1, exercise);

                        //ако няма такъв lesson, добави такъв лесън на края на листа и добави упражнение
                    } else if (!themes.contains(lessonTitle)) {
                        themes.add(lessonTitle);
                        themes.add(lessonTitle + "-Exercise ");
                    }
                    break;
            }

            whenToStop = scanner.nextLine();
        }

        int counter = 0;

        for (
                String theme : themes) {
            counter++;
            System.out.println(counter + "." + theme);
        }
    }
}
