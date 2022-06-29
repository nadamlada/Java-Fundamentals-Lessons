package JF18ObjectsAndClassesExercise;

/*
You will receive an unknown number of lines. On each line, you will receive an array with 3 elements.
The first element will be a string and represents the name of the person. The second element will be a
string and will represent the ID of the person. The last element will be an integer which represents the age of the person.
When you receive the command "End", stop taking input and print all the people, ordered by age.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class X07OrderByAge {

    public static class Person {
        private String name;
        private String id;
        private int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        //George with ID: 123456 is 20 years old.
        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);
            Person person = new Person(name, id, age);
            persons.add(person);

            input = scanner.nextLine();
        }

        persons.sort(Comparator.comparing(Person::getAge));

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}