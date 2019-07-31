import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class trial {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String surface = "";
        String mantle = "";
        String core = "";

        boolean validSurface = true;
        boolean validMantle = true;
        boolean validCore = true;
        boolean validSnowflake = true;

        for (int i = 1; i <= 5; i++) {
            String line = console.nextLine();
            if (i == 1 || i == 5) {
                for (int j = 0; j < line.length(); j++) {
                    if (Character.isLetterOrDigit(line.charAt(j))) {
                        validSurface = false;
                        break;
                    }

                    if (validSurface) {
                        surface = line;
                    }
                }
            } else if (i == 2 || i == 4) {
                for (int j = 0; j < line.length(); j++) {
                    if (!(Character.isDigit(line.charAt(j)) || line.charAt(j) == '_')) {
                        validMantle = false;
                        break;
                    }

                    if (validMantle) {
                        mantle = line;
                    }
                }
            } else {
                boolean hasSurface = false;
                boolean hasMantle = false;
                boolean hasCore = false;
                int countSurface = 0;
                int countMantle = 0;
                int countCore = 0;
                for (int j = 0; j < line.length(); j++) {
                    if(!Character.isLetterOrDigit(line.charAt(j))) {
                        countSurface++;
                    }


                }
            }
        }
    }
}
