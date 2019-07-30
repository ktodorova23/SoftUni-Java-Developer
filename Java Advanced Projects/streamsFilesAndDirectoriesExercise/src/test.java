import java.io.FileInputStream;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String word1, word2;
        int numCommon = 0;
        try {
            Scanner sc = new Scanner(new FileInputStream("words.txt"));
            Scanner sc2 = new Scanner(new FileInputStream("text.txt"));
            while (sc.hasNext()) {

                word1 = sc.
                while(sc2.hasNext()){
                    word2 = sc2.next();
                    if(word2.equals(word1))
                        numCommon++;
                    if (!sc2.hasNext()) {
                        System.out.println(word1+"-"+numCommon);
                        numCommon=0;
                    }
                }
                word1 = sc.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
