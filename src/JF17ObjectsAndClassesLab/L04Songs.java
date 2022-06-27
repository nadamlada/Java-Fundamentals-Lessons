package JF17ObjectsAndClassesLab;

/*
Define a class Song, which holds the following information about songs: Type List, Name, and Time.
On the first line, you will receive the number of songs - N.
On the next N-lines you will be receiving data in the following format: "{typeList}_{name}_{time}".
On the last line, you will receive "Type List" / "all". Print only the names of the songs which are from that Type List / All songs.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L04Songs {

    static class Song {
        private String typeList;
        private String name;
        private String time;

        public String getTypeList() {
            return this.typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //"{typeList}_{name}_{time}"

        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("_");
            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song();
            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {

            for (Song song : songs) {
                System.out.println(song.getName());
            }

        } else {

            for (Song song : songs) {

                if (song.getTypeList().equals(typeList)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}