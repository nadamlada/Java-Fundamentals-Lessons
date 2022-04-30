package JF17ObjectsAndClassesExercise;

/*
Using the Person class, write a program that reads from the console N lines of personal information and
then prints all people whose age is more than 30 years, sorted in alphabetical order.
Note: you can use the stream() to filter people.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class X03OpinionPoll {

    public static class Person {
        //полетата
        private String name;
        private int age;

        //конструктор
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] commands = input.split(" ");
            String name = commands[0];
            int age = Integer.parseInt(commands[1]);
            Person person = new Person(name, age);
            if (age > 30) {
                persons.add(person);
            }
        }
        //сортиране по име в списъка
        persons.sort(Comparator.comparing(Person::getName));

        for (Person person : persons) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}