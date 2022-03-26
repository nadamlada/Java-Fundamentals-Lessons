package JF13ListsExercise;

/*
Anonymous has created a cyber-hyper virus that steals data from the CIA. You, as the lead security developer in the CIA, have been tasked to analyze the software of the virus and observe its actions on the data. The virus is known for its innovative and unbelievably clever technique of merging and dividing data into partitions.
You will receive a single input line containing STRINGS separated by spaces.
The strings may contain any ASCII character except whitespace.
You will then begin receiving commands in one of the following formats:
•	merge {startIndex} {endIndex}
•	divide {index} {partitions}
Every time you receive the merge command, you must merge all elements from the startIndex till the endIndex. In other words, you should concatenate them.
Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it.
Every time you receive the divide command, you must DIVIDE the element at the given index into several small substrings with equal length. The count of the substrings should be equal to the given partitions.
Example: {abcdef, ghi, jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}
If the string CANNOT be exactly divided into the given partitions, make all partitions except the LAST with EQUAL LENGTHS, and make the LAST one – the LONGEST.
Example: {abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
The input ends when you receive the command "3:1". At that point you must print the resulting elements, joined by a space.
Input
•	The first input line will contain the array of data.
•	On the next several input lines you will receive commands in the format specified above.
•	The input ends when you receive the command "3:1".
Output
•	As output, you must print a single line containing the elements of the array, joined by a space.
Constrains
•	The strings in the array may contain any ASCII character except whitespace.
•	The startIndex and the endIndex will be in the range [-1000, 1000].
•	The endIndex will ALWAYS be GREATER than the startIndex.
•	The index in the divide command will ALWAYS be INSIDE the array.
•	The partitions will be in the range [0, 100].
•	Allowed working time/memory: 100ms / 16MB.

 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class X08AnonymousThreatDessislavaTopuzakova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namesInput = scanner.nextLine(); //"Ivo Johny Tony Bony Mony"
        List<String> names = Arrays.stream(namesInput.split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();
        //•   "merge {startIndex} {endIndex}" -> split("\\s+") -> ["merge", "{startIndex}", "endIndex"]
        //•   "divide {index} {partitions}" ->split("\\s+") -> ["divide", "{index}", "partitions"]

        while (!command.equals("3:1")) {
            String[] commandData = command.split("\\s+");
            String commandName = commandData[0]; //merge or divide

            if (commandName.equals("merge")) {
                int startIndex = Integer.parseInt(commandData[1]);
                int endIndex = Integer.parseInt(commandData[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }

                if (endIndex > names.size() - 1) {
                    endIndex = names.size() - 1;
                }

                //проверка за индексите
                boolean isStartIndexValid = isValidIndex(startIndex, names.size());
                boolean isEndIndexValid = isValidIndex(endIndex, names.size());

                //ако са валидни и двата
                if (isStartIndexValid && isEndIndexValid) {
                    //{abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
                    StringBuilder resultMerge = new StringBuilder();

                    for (int index = startIndex; index <= endIndex; index++) {
                        resultMerge.append(names.get(index));
                    }

                    for (int index = startIndex; index <= endIndex; index++) {
                        names.remove(startIndex);
                    }

                    names.add(startIndex, resultMerge.toString());
                }
            } else if (commandName.equals("divide")) {
                int index = Integer.parseInt(commandData[1]);
                int partitions = Integer.parseInt(commandData[2]);
                String elementForDivide = names.get(index);
                //{abcdef, ghi, jkl} -> {ghi, jkl}
                names.remove(index);
                //"abcdef" -> 6 / 3 = 2
                int partSize = elementForDivide.length() / partitions;
                int begin = 0;

                for (int part = 1; part < partitions; part++) {
                    names.add(index, elementForDivide.substring(begin, begin + partSize));
                    index++;
                    begin += partSize;
                }

                names.add(index, elementForDivide.substring(begin));
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", names));
    }

    public static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}