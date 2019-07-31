import java.util.Arrays;
import java.util.Scanner;

public class testExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String dayEvent  = scanner.nextLine();

        String [] workDayEvent= dayEvent.split("\\|");

        int currentEnergy = 100;
        int currentCoins = 100;

        boolean complete = false;

        for (int i = 0; i <workDayEvent.length ; i++) {

            String [] token = workDayEvent[i].split("-");

            int number = Integer.parseInt(token[1]);
            String cmd = token[0];

            if (cmd.equals("rest")){

                if (currentEnergy + number > 100){

                    System.out.printf("You gained 0 energy.%n");
                    System.out.printf("Current energy: %d.%n" , currentEnergy);
                }else {

                    currentEnergy+=number;
                    System.out.printf("You gained %d energy.%n" , number);
                    System.out.printf("Current energy: %d.%n" , currentEnergy);


                }
            }else if (cmd.equals("order")){

                if (currentEnergy - number < 0){
                    System.out.println("You had to rest!");
                    currentEnergy+=50;
                }else {
                    System.out.printf("You earned %d coins.%n" , number);

                    currentEnergy-= 30;
                    currentCoins+=number;
                }
            }else {

                if (currentCoins - number > 0){

                    System.out.printf("You bought %s.%n" , cmd);
                    currentCoins-= number;

                }else {


                    System.out.printf("Closed! Cannot afford %s." , cmd);

                    complete = true;
                    break;



                }
            }

        }
        if (complete!=true){

            System.out.println("Day completed!");
            System.out.printf("Coins: %d%n" , currentCoins);
            System.out.printf("Energy: %d" , currentEnergy);
        }
    }
}