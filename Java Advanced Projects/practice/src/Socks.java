import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Socks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();        //stack
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();       //queue

        ArrayList<Integer> createdPairs = new ArrayList<>();

        String[] line1 = sc.nextLine().split("\\s+");

        for (int i = 0; i < line1.length; i++) {
            leftSocks.push(Integer.parseInt(line1[i]));
        }
        String[] line2 = sc.nextLine().split("\\s+");
        for (int i = 0; i < line2.length; i++) {
            rightSocks.offer(Integer.parseInt(line2[i]));
        }

        while (leftSocks.size() > 0 && rightSocks.size() > 0) {
            int leftSock = leftSocks.peek();
            int rightSock = rightSocks.peek();
            if (leftSock > rightSock) {
                createdPairs.add(leftSock + rightSock);
                leftSocks.pop();
                rightSocks.poll();
            }
            if (rightSock > leftSock) {
                leftSocks.pop();
            }
            if (rightSock == leftSock) {
                rightSocks.poll();
                leftSocks.pop();
                leftSock++;
                leftSocks.push(leftSock);
            }
        }
        System.out.println(Collections.max(createdPairs));
        for (int i = 0; i <createdPairs.size(); i++) {
            System.out.print(createdPairs.get(i)+" ");
        }
    }
}