import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class newOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        while (true){

            String[] command =scanner.nextLine().split(" ");

            if (command[0].equalsIgnoreCase("delete")){
                int num = Integer.parseInt(command[1]);

                while (input.contains(num)) {
                    input.remove(Integer.valueOf(num));
                }
                break;
            }
            else if (command[0].equalsIgnoreCase("insert")){
                int element = Integer.parseInt(command[1]);
                int position = Integer.parseInt(command[2]);
                if (position <= input.size() - 1) {
                    input.add(position, element);
                }
                break;

            }
            else if (command[0].equalsIgnoreCase("end")){
                break;
            }
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]",""));
    }
}