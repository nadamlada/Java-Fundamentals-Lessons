package JF18ObjectsAndClassesExercise;

/*
Write a program that generates random fake advertisement messages to extol some product. The messages must consist of 4 parts: laudatory phrase + event + author + city. Use the following predefined parts:
•	Phrases – {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."}
•	Events – {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"}
•	Authors – {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"}
•	Cities – {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
The format of the output message is: {phrase} {event} {author} – {city}.
As an input, you take the number of messages to be generated. Print each random message on a separate line.
 */

import java.util.Random;
import java.util.Scanner;

public class X01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //викаме си класа
        Message message = new Message();

        //принтиране n На брой пъти
        message.printMessages(n);
    }

    static class Message {

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();

        //{phrase} {event} {author} – {city}.
        void printMessages(int n) {

            for (int i = 0; i < n; i++) {
                System.out.printf("%s %s %s - %s%n",
                        this.phrases[random.nextInt(this.phrases.length)],
                        this.events[random.nextInt(this.events.length)],
                        this.authors[random.nextInt(this.authors.length)],
                        this.cities[random.nextInt(this.cities.length)]);
            }
        }
    }
}