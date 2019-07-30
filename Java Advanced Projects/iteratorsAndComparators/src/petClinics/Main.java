package petClinics;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Clinic> clinics = new HashMap<>();
        HashMap<String, Pet> pets = new HashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    if (tokens[1].equals("Pet")) {
                        Pet pet = new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                        pets.putIfAbsent(tokens[2], pet);
                    } else {
                        try {
                            Clinic clinic = new Clinic(tokens[2], Integer.parseInt(tokens[3]));
                            clinics.putIfAbsent(tokens[2], clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    System.out.println(clinics.get(tokens[2]).add(pets.get(tokens[1])));
                    break;
                case "Release":
                    System.out.println(clinics.get(tokens[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (tokens.length == 2) {
                        for (Pet pet : clinics.get(tokens[1])) {
                            if (pet != null) {
                                System.out.println(pet.toString());
                            } else {
                                System.out.println("Room empty");
                            }
                        }
                    } else {
                        System.out.println(clinics.get(tokens[1]).printRoom(Integer.parseInt(tokens[2]) - 1));
                    }
                    break;
            }
        }
    }
}
