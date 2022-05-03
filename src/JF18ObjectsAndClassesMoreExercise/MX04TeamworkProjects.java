package JF18ObjectsAndClassesMoreExercise;
/*
It's time for teamwork projects and you are responsible for making the teams. First, you will receive an integer - the count of the teams you will have to register. You will be given a user and a team (separated with "-").  The user is the creator of that team.
For every newly created team you should print a message:
"Team {team Name} has been created by {user}!".
Next, you will receive a user with the team (separated with "->") which means that the user wants to join that team. Upon receiving the command: "end of assignment", you should print every team, ordered by the count of its members (descending) and then by name (ascending). For each team (disband teams as well), you have to print its members sorted by name (ascending). However, there are several rules:
•	If a user tries to create a team more than once a message should be displayed:
"Team {teamName} was already created!"
•	Creator of a team cannot create another team - the message should be thrown:
"{user} cannot create another team!"
•	If a user tries to join a currently non-existing team a message should be displayed:
"Team {teamName} does not exist!"
•	Member of a team cannot join another team - the message should be thrown:
"Member {user} cannot join team {team Name}!"
•	At the end (after teams' report) teams with zero members (with only a creator) should disband ordered by name in ascending other.
•	 Every valid team should be printed ordered by name (ascending) in this format:
"{teamName}:
 - {create}
 -- {member}..."

 */

import java.util.*;

public class MX04TeamworkProjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> teams = new ArrayList<>();
        List<String> creators = new ArrayList<>();
        List<String> members = new ArrayList<>();

        Map<String, List<String>> teamsMembers = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        //ще създавам толкова отбора
        for (int i = 0; i < n; i++) {
            String[] registered = input.split("-");
            String creator = registered[0];
            String team = registered[1];

            if (creators.contains(creator)) {
                System.out.printf("%s cannot create another team!%n", creator);
            } else if (teams.contains(team)) {
                System.out.printf("Team %s was already created!%n", team);
            } else {
                teamsMembers.putIfAbsent(team, new ArrayList<>());
                teamsMembers.get(team).add(creator);

                teams.add(team);
                creators.add(creator);
                members.add(creator);
                System.out.printf("Team %s has been created by %s!%n", team, creator);
            }

            input = scanner.nextLine();
        }

        while (!input.equals("end of assignment")) {
            String[] asks = input.split("->");
            String askedMember = asks[0];
            String askedTeam = asks[1];

            if (!teams.contains(askedTeam)) {
                System.out.printf("Team %s does not exist!%n", askedTeam);
            } else if (members.contains((askedMember))) {
                System.out.printf("Member %s cannot join team %s!%n", askedMember, askedTeam);
            } else {
                members.add(askedMember);
                teamsMembers.get(askedTeam).add(askedMember);
            }

            input = scanner.nextLine();
        }
        //•	At the end (after teams' report) teams with zero members (with only a creator) should disband ordered by name in ascending other.

//        teamsMembers.entrySet().stream()
//                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(),(e1.getValue().size())));

        List<String> print = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : teamsMembers.entrySet()) {
            entry.getValue().stream().sorted();

            //да се сортира печатането
            //you should print every team, ordered by the count of its members (descending)

            if (entry.getValue().size() != 1) {
                System.out.println(entry.getKey());

                for (int i = 0; i < entry.getValue().size(); i++) {

                    if (i == entry.getValue().size() - 1) {
                        System.out.printf("- %s%n", entry.getValue().get(i));
                    } else {
                        System.out.printf("- %s%n-", entry.getValue().get(i));
                    }
                }

            } else {
                print.add(entry.getKey());
                print.stream().sorted();
            }
        }

        System.out.println("Teams to disband:");
        for (String s : print) {
            System.out.println(s);
        }
    }
}