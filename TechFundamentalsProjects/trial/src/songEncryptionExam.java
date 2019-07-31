import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class songEncryptionExam {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(":");
            String artist = tokens[0];
            String song = tokens[1];
            int key = artist.length();
            boolean combinationIsValid = false;

            Pattern artistPattern = Pattern.compile("^[A-Z]{1}[a-z' ]+$");
            Matcher artistMatcher = artistPattern.matcher(artist);

            Pattern songPattern = Pattern.compile("^[A-Z ]+$");
            Matcher songMatcher = songPattern.matcher(song);

            if (artistMatcher.find() && songMatcher.find()) {
                combinationIsValid = true;
            }

            if (combinationIsValid) {
                StringBuilder decriptedMsg = new StringBuilder();
                for (int i = 0; i < artist.length(); i++) {
                    int tempKey = key;
                    char symbol = artist.charAt(i);
                    if (Character.isLetter(symbol)) {
                        if (Character.isUpperCase(symbol) && (char) (symbol + tempKey) <= 'Z') {
                            decriptedMsg.append((char) (symbol + tempKey));
                        } else if (Character.isUpperCase(symbol) && (char) (symbol + tempKey) > 'Z') {
                            tempKey -= ('Z' - symbol + 1);
                            decriptedMsg.append((char) ('A' + tempKey));
                        } else if (Character.isLowerCase(symbol) && (char) (symbol + tempKey) <= 'z') {
                            decriptedMsg.append((char) (symbol + tempKey));
                        } else if (Character.isLowerCase(symbol) && (char) (symbol + tempKey) > 'z') {
                            tempKey -= ('z' - symbol + 1);
                            decriptedMsg.append((char) ('a' + tempKey));
                        }
                    } else {
                        decriptedMsg.append(symbol);
                    }
                }

                decriptedMsg.append('@');
                for (int i = 0; i < song.length(); i++) {
                    int tempKey = key;
                    char symbol = song.charAt(i);
                    if (Character.isLetter(symbol)) {
                        if (Character.isUpperCase(symbol) && (char) (symbol + tempKey) <= 'Z') {
                            decriptedMsg.append((char) (symbol + tempKey));
                        } else if (Character.isUpperCase(symbol) && (char) (symbol + tempKey) > 'Z') {
                            tempKey -= ((int) ('Z') - (int) (symbol) + 1);
                            decriptedMsg.append((char) ('A' + tempKey));
                        }
                    } else {
                        decriptedMsg.append(symbol);
                    }
                }
                System.out.println("Successful encryption: " + decriptedMsg);
            } else {
                System.out.println("Invalid input!");
            }
            line = console.nextLine();
        }
    }
}
