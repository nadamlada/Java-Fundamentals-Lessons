package JF04DdataTypesAndVariablesLab;

/*
Read two names and a delimiter. Print the names joined by the delimiter.
 */

import java.util.Scanner;

public class L05ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String nextName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.printf("%s%s%s", name, delimiter, nextName);

    }
}