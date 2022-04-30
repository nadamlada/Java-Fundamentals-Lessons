package JF17ObjectsAndClassesExercise;

 /*
 Change the program from the second problem, so you can store a list of articles. You will not need the methods
 anymore (except the ToString method). On the first line, you will get a number n. On the next n lines,
 you will get some articles in the same format as the previous task ("{title}, {content}, {author}").
 Finally, you will get one of the three inputs: "title", "content", "author". You need to order the articles
 alphabetically based on the command and print them sorted by the given criteria.
  */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class X04ArticleVer2 {

    public static class ArticleTwo {
        String title;
        String content;
        String author;

        public ArticleTwo(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }

        @Override
        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<ArticleTwo> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //("{title}, {content}, {author}
            String input = scanner.nextLine();
            String[] commands = input.split(", ");
            String title = commands[0];
            String content = commands[1];
            String author = commands[2];

            ArticleTwo articlesTwo = new ArticleTwo(title, content, author);
            articles.add(articlesTwo);
        }
        String searched = scanner.nextLine();
        if (searched.equals("title")) {
            articles.sort(Comparator.comparing(ArticleTwo::getTitle));

        } else if (searched.equals("content")) {
            articles.sort(Comparator.comparing(ArticleTwo::getContent));

        } else if (searched.equals("author")) {
            articles.sort(Comparator.comparing(ArticleTwo::getAuthor));
        }

        for (ArticleTwo article : articles) {
            System.out.println(article);
        }
    }
}