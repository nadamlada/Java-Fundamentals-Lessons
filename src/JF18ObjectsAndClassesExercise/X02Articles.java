package JF18ObjectsAndClassesExercise;

/*
Create an article class with the following properties:
•	Title – a string
•	Content – a string
•	Author – a string
The class should have a constructor and the following methods:
•	Edit (new content) – change the old content with the new one
•	ChangeAuthor (new author) – change the author
•	Rename (new title) – change the title of the article
•	override ToString – print the article in the following format:
"{title} - {content}:{author}"
Write a program that reads an article in the following format "{title}, {content}, {author}".
 the next line, you will get a number n. On the next n lines, you will get one of the following commands:
 "Edit: {new content}"; "ChangeAuthor: {new author}"; "Rename: {new title}". At the end, print the final article.
 */

import java.util.Scanner;

public class X02Articles {

    public static class Article {
        //полета

        private String title;
        private String content;
        private String author;

        //конструктор
        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] fields = input.split(", ");
        int n = Integer.parseInt(scanner.nextLine());
        String title = fields[0];
        String content = fields[1];
        String author = fields[2];

        Article article = new Article(title, content, author);

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(": ");

            switch (commands[0]) {
                case "Edit":
                    article.setContent(commands[1]);
                    break;

                case "ChangeAuthor":
                    article.setAuthor(commands[1]);
                    break;

                case "Rename":
                    article.setTitle(commands[1]);
                    break;
            }
        }

        System.out.println(article);
    }
}