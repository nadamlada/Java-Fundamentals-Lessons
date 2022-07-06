package JF21MapsLambdaAndStreamApiExercise;

/*
Write a program which keeps the information about companies and their employees.
You will be receiving company names and an employees' id until you receive the command "End" command. Add each employee to the given company. Keep in mind that a company cannot have two employees with the same id.
Print the company name and each employee's id in the following format:
"{company_name}
-- {id1}
-- {id2}
…
-- {idN}"
Input / Constraints
•	Until you receive "End", the input come in the format: "{companyName} -> {employeeId}".
•	The input always will be valid.
 */

import java.util.*;

public class X08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<String>> book = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String uni = data[0];
            String user = data[1];

            List<String> ids = new ArrayList<>();

            if (book.containsKey(uni)) {
                ids = book.get(uni);
            }

            //проверяваме дали този юзър вече е добавен
            if (!ids.contains(user)) {
                ids.add(user);
                book.put(uni, ids);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : book.entrySet()) {
            System.out.println(entry.getKey());
            List<String> students = entry.getValue();

            for (String s : students) {
                System.out.println("-- " + s);
            }
        }
    }
}