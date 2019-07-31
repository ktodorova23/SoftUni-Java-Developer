import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class songs {

    public static class Song {
        private String type;
        private String name;
        private String time;

        public String getType() {
            return type;
        }

        public void setTypeList(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String[] data = console.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song();

            song.setName(name);
            song.setTime(time);
            song.setTypeList(type);

            songs.add(song);
        }

        String typeList = console.nextLine();

        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            songs.stream().filter(e -> e.getType().equals(typeList)).forEach(el -> System.out.println(el.getName()));
        }


    }
}
