import java.util.Scanner;

public class elevator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(console.nextLine());
        int capacity = Integer.parseInt(console.nextLine());

        int courses = (int) Math.ceil((double) numberOfPeople / capacity);

        System.out.println(courses);


    }
}
