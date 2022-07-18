package JF29FinalExamExersices.EXProgrammingFundamentaAdditionalRetakeExam10January2019PartII;

/*
After the successful second Christmas, Santa needs to gather information about the behavior of children to plan the presents for next Christmas. He has a secret helper, who is sending him encrypted information. Your task is to decrypt it and create a list of the children who have been good.
You will receive an integer, which represents a key and afterwards some messages, which you must decode by subtracting the key from the value of each character. After the decryption, to be considered a valid match, a message should:
-	Have a name, which starts after '@' and contains only letters from the Latin alphabet
-	Have a behaviour type - "G"(good) or "N"(naughty) and must be surrounded by "!" (exclamation mark).
The order in the message should be: child’s name -> child’s behavior. They can be separated from the others by any character except: '@', '-', '!', ':' and '>'.
You will be receiving message until you are given the “end” command. Afterwards, print the names of the children, who will receive a present, each on a new line.
Input / Constraints
•	The first line holds n – the number which you have to subtract from the characters – integer in range [1…100];
•	On the next lines, you will be receiving encrypted messages.
Output
Print the names of the children, each on a new line
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class X03SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            StringBuilder current = new StringBuilder(input);

            for (int i = 0; i < current.length(); i++) {
                int newChar = current.charAt(i) - key;
                current.setCharAt(i, (char) newChar);
            }
            // System.out.println(current);

            String regexGood = "@(?<group1>[A-Za-z]+)[^-@!:>]*(!G!)";

            Pattern pattern = Pattern.compile(regexGood);
            Matcher matcher = pattern.matcher(current);

            while (matcher.find()) {
                String valid = matcher.group("group1");
                System.out.println(valid);
            }

            input = scanner.nextLine();
        }
    }
}


