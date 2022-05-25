package JF16ObjectsAndClassesLab;

 /*
Define a class Student, which holds the following information about students: first name, last name, age, and hometown.
Read the list of students until you receive the "end" command. After that, you will receive a city name. Print only students
which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".
 */

public class L06Students {

    static class Student {
        //полета
        String firstName;
        String lastName;
        String age;
        String town;

        //конструктор
        public Student(String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getTown() {
            return this.town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//        List<Student> studentsList = new ArrayList<>();
//
//        String input = scanner.nextLine();
//        while (!input.equals("end")) {
//            String[] dataArray = input.split(" ");
//
//            String firstName = dataArray[0];
//            String lastName = dataArray[1];
//            String age = dataArray[2];
//            String town = dataArray[3];
//
//            Student student = new Student(firstName, lastName, age, town);
//            studentsList.add(student);
//
//            input = scanner.nextLine();
//        }
//
//        String searchedTown = scanner.nextLine();
//
//        for (Student s : studentsList) {
//            if (s.getTown().equals(searchedTown)) {
//                System.out.printf("%s %s is %s years old%n", s.getFirstName(), s.getLastName(), s.getAge());
//            }
//
//        }
//
//    }

}

