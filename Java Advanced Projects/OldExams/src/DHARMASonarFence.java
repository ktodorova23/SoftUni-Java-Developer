import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DHARMASonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!"Reprogram".equals(line = reader.readLine())) {
            String num = Integer.toBinaryString(Integer.parseInt(line));

            char[] fullNumber = new char[32];

            Arrays.fill(fullNumber, '0');
            for (int i = 0; i < num.length(); i++) {
                fullNumber[i + fullNumber.length - num.length()] = num.charAt(i);
            }

            for (int i = 0; i < fullNumber.length - 1; i++) {
                if (fullNumber[i] == fullNumber[i + 1]) {
                    if (fullNumber[i] == '0') {
                        fullNumber[i] = '1';
                        fullNumber[i + 1] = '1';
                    } else {
                        fullNumber[i] = '0';
                        fullNumber[i + 1] = '0';
                    }
                    i++;
                }
            }
            System.out.println(Long.parseLong(new String(fullNumber), 2));
        }
        ;
    }
}
