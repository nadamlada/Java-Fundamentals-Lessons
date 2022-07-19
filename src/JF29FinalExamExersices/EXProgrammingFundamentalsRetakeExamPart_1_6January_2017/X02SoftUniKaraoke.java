package JF29FinalExamExersices.EXProgrammingFundamentalsRetakeExamPart_1_6January_2017;

/*
SoftUni cultivates talent whether it's coding talent or something else and in this case, something else is singing. Since you love music you want to take part in the event but as a programmer you simply lack the "something else" so your job is to make the software to track participants' awards.
On the first line, you will receive a list with all participants that applied for performance.
On the second line, you will receive the list with all available songs.
On the next lines, until the "dawn" command, you will get the names of people, the song that they are performing on stage and the award they get from the audience.
However, not every time the plan goes according to schedule. In other words, everyone (listed or not) can go on stage and perform a song that is not even available and he still gets awards from the audience. However, you should record only the awards for listed participants that perform songs available in the list. In case someone is not listed or sings a song that is not available you should not record neither the participant, nor his award.
When the "dawn" comes, you need to print all participants, the count of the unique awards they received and all unique awards. Participants should be sorted by number of awards in descending order and then by participant name alphabetically. Awards should be sorted in alphabetical order.
Input
•	On the first line, you will receive list with all participants that applied for performance in the format: "{participant}, {participant} … {participant}"
•	On the second line, you will get all available songs in the in the format: "{song}, {song} … {song}"
•	On the next lines, until the "dawn" command you will receive every stage performance in the format: "{participant}, {song}, {award}"
•	Performances and songs will be separated by a comma and a single or multiple white spaces
Output
•	Print all participants along with the number of unique awards they won in the format:
o	"{participant}: {award count} awards"
o	"--{award}"
•	Print participants sorted by unique awards count in descending order. If two participants have the same unique award count, sort them alphabetically by name
•	Print unique awards for every participant sorted alphabetically
•	If there are no awards, print "No awards"
Constrains
•	The number of total participants will be in range [1 … 100]
•	The number of total songs will be in range [1 … 100]
•	The input will always end with the "dawn" command
 */

import java.util.*;

public class X02SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] allParticipants = scanner.nextLine().split(",\\s+");
        String[] allSongs = scanner.nextLine().split(",\\s+");

        String input = scanner.nextLine();

        Map<String, Integer> nameQtyPrices = new TreeMap<>();
        Map<String, List<String>> nameAwards = new HashMap<>();

        while (!input.equals("dawn")) {
            String[] current = input.split(",\\s+");
            String participant = current[0];
            String song = current[1];
            String award = current[2];

            if (validSong(song, allSongs) && validParticipant(participant, allParticipants)) {
                nameAwards.putIfAbsent(participant, new ArrayList<>());
                nameQtyPrices.putIfAbsent(participant, 0);

                if (!(nameAwards.get(participant).contains(award))) {
                    nameAwards.get(participant).add(award);
                    nameQtyPrices.put(participant, nameQtyPrices.get(participant) + 1);
                }
            }

            input = scanner.nextLine();
        }

        if (nameAwards.isEmpty()) {
            System.out.printf("No awards");
        }

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        nameQtyPrices.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : reverseSortedMap.entrySet()) {
            System.out.printf("%s: %d awards%n", entry.getKey(), entry.getValue());

            for (Map.Entry<String, List<String>> listEntry : nameAwards.entrySet()) {
                List<String> awards = listEntry.getValue();
                Collections.sort(awards);

                if (entry.getKey().equals(listEntry.getKey())) {

                    for (String sss : awards) {
                        System.out.printf("--%s%n", sss);
                    }
                }
            }
        }
    }

    private static boolean validParticipant(String participant, String[] allParticipants) {

        for (String s : allParticipants) {

            if (s.equals(participant)) {
                return true;
            }
        }

        return false;
    }

    private static boolean validSong(String song, String[] allSongs) {

        for (String s : allSongs) {

            if (s.equals(song)) {
                return true;
            }
        }

        return false;
    }
}
