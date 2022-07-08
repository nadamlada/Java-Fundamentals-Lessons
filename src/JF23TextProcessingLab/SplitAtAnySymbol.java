package JF23TextProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitAtAnySymbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "the quick brown fox jumps over the lazy dog";
        char separator = ' ';

        StringBuilder current = new StringBuilder();
        List<String> split = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) != separator) {
                current.append(text.charAt(i));

                //когато е сепаратора
            } else {
                //кърънт от стрингбилдър го правим в стринг
                split.add(current.toString());
                //изчистваме стринг билдъра
                current.setLength(0);
                //или Current = new StringBuilder;
            }
        }

        for (String s : split) {
            System.out.println(s);
        }
    }
}