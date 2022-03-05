package JF24TextProcessingMoreExercise;
/*
You will receive 3 lines of input. On the first line, you will receive a title of an article. On the next line, you
will receive the content of that article. On the next n lines until you receive "end of comments" you will get the
comments about the article. Print the whole information in HTML format. The title should be in "h1" tag (<h1></h1>);
the content in article tag (<article></article>); each comment should be in div tag (<div></div>). For more clarification
see the example below
 */

import java.util.Scanner;

public class MX05HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String content = scanner.nextLine();

        StringBuilder titlePrint = new StringBuilder(title);
        //titlePrint.append(System.lineSeparator());
        titlePrint.insert(0, String.format("<h1>%n    "));
        titlePrint.append(String.format("%n</h1>"));
        System.out.println(titlePrint);

        StringBuilder contentPrint = new StringBuilder(content);
        contentPrint.insert(0, String.format("<article>%n    "));
        contentPrint.append(String.format("%n</article>"));
        System.out.println(contentPrint);

        String comments = scanner.nextLine();

        while (!comments.equals("end of comments")) {
            StringBuilder commentsPrint = new StringBuilder(comments);
            commentsPrint.insert(0, String.format("<div>%n    "));
            commentsPrint.append(String.format("%n</div>"));
            System.out.println(commentsPrint);
            commentsPrint.setLength(0);

            comments = scanner.nextLine();
        }
    }
}