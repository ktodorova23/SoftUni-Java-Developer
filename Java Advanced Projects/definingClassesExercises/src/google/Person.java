package google;

import java.util.ArrayList;

public class Person {
    private String name;
    private Company company;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Parents> parents;
    private ArrayList<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;
        this.company = null;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public ArrayList<Parents> getParents() {
        return parents;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setParents(ArrayList<Parents> parents) {
        this.parents = parents;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void printInfo() {
        System.out.println(this.name);
        System.out.println("Company:");
        if (this.company != null) {
            System.out.println(String.format("%s %s %.2f", this.company.getName(), this.company.getDepartment(), this.company.getSalary()));
        }
        System.out.println("Car:");
        if (this.car != null) {
            System.out.println(this.car.getModel() + " " + this.car.getSpeed());
        }
        System.out.println("Pokemon:");
        if (!this.pokemons.isEmpty()) {
            this.pokemons.forEach(p -> System.out.println(p.getName() + " " + p.getType()));
        }
        System.out.println("Parents:");
        if (!this.parents.isEmpty()) {
            this.parents.forEach(p -> System.out.println(p.getName() + " " + p.getBirthday()));
        }
        System.out.println("Children:");
        if (!this.children.isEmpty()) {
            this.children.forEach(c -> System.out.println(c.getName() + " " + c.getBirthday()));
        }
    }
}
