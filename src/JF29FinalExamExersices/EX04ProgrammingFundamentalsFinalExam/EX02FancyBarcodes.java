package JF29FinalExamExersices.EX04ProgrammingFundamentalsFinalExam;

/*
Your first task is to determine if the given sequence of characters is a valid barcode or not.
Each line must not contain anything else but a valid barcode. A barcode is valid when:
•	It is surrounded by a "@" followed by one or more "#"
•	It is at least 6 characters long (without the surrounding "@" or "#")
•	It starts with a capital letter
•	It contains only letters (lower and upper case) and digits
•	It ends with a capital letter
Examples of valid barcodes: @#FreshFisH@#, @###Brea0D@###, @##Che46sE@##, @##Che46sE@###
Examples of invalid barcodes: ##InvaliDiteM##, @InvalidIteM@, @#Invalid_IteM@#
Next, you have to determine the product group of the item from the barcode. The product group is obtained by concatenating all the digits found in the barcode. If there are no digits present in the barcode, the default product group is "00".
Examples:
@#FreshFisH@# -> product group: 00
@###Brea0D@### -> product group: 0
@##Che4s6E@## -> product group: 46
Input
On the first line, you will be given an integer n – the count of barcodes that you will be receiving next.
On the following n lines, you will receive different strings.
Output
For each barcode that you process, you need to print a message.
If the barcode is invalid:
•	"Invalid barcode"
If the barcode is valid:
•	"Product group: {product group}"
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String regex = "(@[#]+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@[#]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            String valid = "";

            while (matcher.find()) {
                valid = matcher.group();
            }

            if (valid.isEmpty()) {

                if (!matcher.find()) {
                    System.out.printf("Invalid barcode%n");
                    continue;
                }
            }

            StringBuilder code = new StringBuilder();
            String regexDigits = "[0-9]";

            Pattern pattern1 = Pattern.compile(regexDigits);
            Matcher matcher1 = pattern1.matcher(valid);

            while (matcher1.find()) {
                code.append(matcher1.group());
            }

            if (code.length() == 0) {
                System.out.printf("Product group: 00%n");
            } else {
                String print = code.toString();
                System.out.printf("Product group: %s%n", print);
                code.setLength(0);
            }
        }
    }
}

