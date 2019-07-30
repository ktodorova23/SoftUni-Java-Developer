package genericArrayCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayCreator<T> {

    public static <T> T[] create (int length, T item) {
        T[] array = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static <T> T[]create (Class<T> clazz, int length, T item) {
        T[] result = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            result[i] = item;
        }
        return result;
    }
}
