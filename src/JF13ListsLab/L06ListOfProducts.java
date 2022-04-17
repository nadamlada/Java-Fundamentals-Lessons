package JF13ListsLab;

/*
Read a number n and n lines of products. Print a numbered list of all the products ordered by name.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class L06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        // Създаване на лист когато четем инпута от всеки следващ ред
        List<String> listOfProducts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            listOfProducts.add(product);
        }

        //Сортиране по азбучен ред на лист
        Collections.sort(listOfProducts);

        for (int i = 0; i < n; i++) {
            System.out.printf("%d.%s%n", i + 1, listOfProducts.get(i));
        }
    }
}