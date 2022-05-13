package JF21MapsLambdaAndStreamApiMoreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MX01RankingPAK {
    public static class User {
        String name;
        Map<String, Integer> contestsPoints = new TreeMap<>();


        public User(String name) {
            this.name = name;
        }

        public User(String name, Map<String, Integer> contestsPoints) {
            this.name = name;
            this.contestsPoints = contestsPoints;
        }

        @Override
        public String toString() {
            return String.format("%s%n%s%n%s%n", this.name, this.contestsPoints.toString());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Integer> getContestsPoints() {
            return contestsPoints;
        }

        public void setContestsPoints(Map<String, Integer> contestsPoints) {
            this.contestsPoints = contestsPoints;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> contestsPasswordsMap = new HashMap<>();

        while (!input.equals("end of contests")) {
            String[] contestsPasswords = input.split(":");
            String contest = contestsPasswords[0];
            String password = contestsPasswords[1];

            contestsPasswordsMap.put(contest, password);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            //"{contest}=>{password}=>{username}=>{points}"
            String[] data = input.split("=>");
            String contest = data[0];
            String password = data[1];
            String username = data[2];
            int points = Integer.parseInt(data[3]);

            if (validContestAndPassword(password, contest, contestsPasswordsMap)) {
                User user = new User(username);
                //така се пърлни лист в обект

                Map<String, Integer> buff = user.getContestsPoints();
                buff.putIfAbsent(contest, points);

                System.out.println(user);
            }

            input = scanner.nextLine();
        }
    }

    private static boolean validContestAndPassword(String password, String contest, Map<String, String> contestsPasswordsMap) {

        if (contestsPasswordsMap.containsKey(contest)) {
            if (contestsPasswordsMap.get(contest).equals(password)) {
                return true;
            }
        }

        return false;
    }
}