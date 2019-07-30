package repository;

public class Main {
    public static void main(String[] args) {
        Person hubby = new Person("Mitashe", 31, "18/09/1987");
        Person wifey = new Person("Krasi", 28, "23/02/1990");
        Person kiddo = new Person("Mitashe", 0, "08/06/2018");

        Repository repository = new Repository();
        repository.add(hubby);
        repository.add(wifey);
        repository.add(kiddo);

        System.out.println(repository.get(0));
        System.out.println(repository.delete(3));
        System.out.println(repository.delete(1));
        System.out.println(repository.getCount());
        repository.add(wifey);
        Person wifey2 = new Person("Krasi", 29, "23/02/1990");
        repository.update(3, wifey2);
        System.out.println(repository.get(3));

    }
}
