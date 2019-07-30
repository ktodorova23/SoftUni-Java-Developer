import models.*;
import models.colonists.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int maxFamilyCount = inputs[0];
        int maxFamilyCapacity = inputs[1];

        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        String line;

        while (!"end".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "insert":
                    Class clazz = Class.forName("models.colonists." + tokens[1]);
                    Colonist colonist = null;
                    if (tokens[1].equals("Surgeon") || tokens[1].equals("GeneralPractitioner")) {
                        Constructor<? extends Colonist> constructor =
                                clazz.getDeclaredConstructor(String.class, String.class, int.class, int.class, String.class);
                        constructor.setAccessible(true);
                        colonist = constructor.newInstance(tokens[2], tokens[3], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);

                    } else {
                        Constructor<? extends Colonist> constructor =
                                clazz.getDeclaredConstructor(String.class, String.class, int.class, int.class);
                        constructor.setAccessible(true);
                        colonist = constructor.newInstance(tokens[2], tokens[3], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
                    }
                    colony.addColonist(colonist);
                    break;
                case "remove":
                    if (tokens[1].equals("family")) {
                        colony.removeFamily(tokens[2]);
                    } else {
                        colony.removeColonist(tokens[2], tokens[3]);
                    }
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(tokens[1]));
                    break;
                case "potential":
                    System.out.println("potential: " + colony.getPotential());
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    Family family = colony.getFamilyById(tokens[1]);

                    if (family != null) {
                        System.out.println(family.toString());
                    } else {
                        System.out.println("family does not exist");
                    }
                    break;
            }
        }

    }
}
