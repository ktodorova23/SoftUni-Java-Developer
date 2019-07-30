package models.colonists;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;
    private int potential;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getPotential() {
        return this.talent + this.getPotentialBonuses();
    }

    protected abstract int getPotentialBonuses();

    public void grow(int years) {
        this.setAge(this.age + years);
    }
}
