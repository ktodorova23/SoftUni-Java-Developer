import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Reflection.class;
//        System.out.println(clazz);
//        System.out.println(clazz.getSuperclass());
//
//        Class[] interfaces = clazz.getInterfaces();
//
//        for (Class anInterface : interfaces) {
//            System.out.println(anInterface);
//        }
//
//        Constructor constructor = clazz.getConstructor();
//
//        Reflection reflection = (Reflection) constructor.newInstance();
//        System.out.println(reflection);

        TreeSet<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                if (method.getParameterCount() == 0) {
                    getters.add(method);
                }
            }
            if (method.getName().startsWith("set")) {
                if (method.getParameterCount() == 1) {
                    if (void.class.equals(method.getReturnType())) {
                        setters.add(method);
                    }
                }
            }
        }

        Field[] field = clazz.getDeclaredFields();

        fields.addAll(Arrays.asList(field));

        fields.stream().filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        getters.stream().filter(g -> !Modifier.isPublic(g.getModifiers()))
                .forEach
                (method -> System.out.println(method.getName() + " have to be public!"));

        setters.stream().filter(s -> !Modifier.isPrivate(s.getModifiers()))
                .forEach
                (method -> System.out.println(method.getName() + " have to be private!"));
    }
}
