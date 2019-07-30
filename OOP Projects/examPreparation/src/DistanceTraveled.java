import java.util.Scanner;

public class DistanceTraveled {

    public static void main(String[] args) {
        Scanner pesho = new Scanner(System.in);

        int stepsMade = Integer.parseInt(pesho.nextLine());
        double lenght = Double.parseDouble(pesho.nextLine());
        int target = Integer.parseInt(pesho.nextLine());
        double currentDistance =0.0;
        double percent = 0.0;
        target = target*100;

        for (int i = 0; i <stepsMade ; i++) {
            if (i % 5 == 0){
                currentDistance = lenght*0.7 + currentDistance;
            }else {
                currentDistance = currentDistance+ lenght;
            }
        }
        percent = (currentDistance/target)*100;


        System.out.printf("You travelled %.2f of the distance!",percent);







    }

}