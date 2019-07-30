package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    public RandomArrayList() {
        super();
        this.random = new Random();
    }

    public Object getRandomElement() {
        int index = random.nextInt(super.size());

        Object element = super.get(index);
        super.remove(element);

        return element;
    }
}
