package repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private int ID;

    public Repository() {
        this.data = new LinkedHashMap<>();
        ID = 0;
    }

//•	Method add(Person person) – adds an Person to the data field with the next ID value
//•	Method get(int id) – returns the Person object stored with the given ID
//•	Method update(int id, Person newPerson) – replaces the Person stored to the coresponding ID with the new Person object. Returns false if the ID doesn't exist, otherwise return true.
//•	Method delete(int id) – deletes the Person object by the given id. Return false if the id doesn't exist, otherwise return true.
//•	Method getCount() – returns the number of stored Person objects.

    public void add(Person person) {
        this.data.put(this.ID++, person);
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (this.data.containsKey(id)) {
            this.data.put(id, newPerson);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (this.data.containsKey(id)) {
            this.data.remove(id, this.data.get(id));
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.data.size();
    }
}
