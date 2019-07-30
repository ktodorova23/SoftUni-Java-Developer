package comparingObjects;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Person) {
            return this.name.equals(((Person) obj).name) && this.age == ((Person) obj).age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + ((Integer)this.age).hashCode();
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = this.age - other.age;
        }
        return result;
    }
}
