package JF17ObjectsAndClassesLab;

/*
You will receive two numbers (0 to 1050), print their sum. You will receive two numbers (0 to 1050), print their sum.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class L02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger first = new BigInteger(scanner.nextLine());
        BigInteger second = new BigInteger(scanner.nextLine());

        //923847238931983192462832102 + 934572893617836459843471846187346
        BigInteger result = first.add(second);

        System.out.println(result);
    }
}