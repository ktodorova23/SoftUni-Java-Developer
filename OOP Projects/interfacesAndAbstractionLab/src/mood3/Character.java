package mood3;

public abstract class Character <P> implements GameObject {
    private String username;
    private String characterType;
    private int level;
    private Double specialPoints;
    private P hashedPassword;

    public Character(String username, String characterType, int level, Number specialPoints) {
        this.username = username;
        this.characterType = characterType;
        this.level = level;
//        this.specialPoints = specialPoints;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public Double getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | %s -> %s%n",
                this.getUsername(), this.hashedPassword, this.getCharacterType().getClass().getSimpleName());
    }
}
