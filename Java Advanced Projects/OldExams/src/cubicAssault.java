import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cubicAssault {
    public static class Region {
        private String name;
        private int blackMeteors;
        private int redMeteors;
        private int greenMeteors;

        public Region(String name) {
            this.name = name;
            this.blackMeteors = 0;
            this.redMeteors = 0;
            this.greenMeteors = 0;
        }

        public String getName() {
            return name;
        }

        public int getBlackMeteors() {
            return blackMeteors;
        }

        public void setBlackMeteors(int blackMeteors) {
            this.blackMeteors = blackMeteors;
        }

        public int getRedMeteors() {
            return redMeteors;
        }

        public void setRedMeteors(int redMeteors) {
            this.redMeteors = redMeteors;
        }

        public int getGreenMeteors() {
            return greenMeteors;
        }

        public void setGreenMeteors(int greenMeteors) {
            this.greenMeteors = greenMeteors;
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        
    }
}
