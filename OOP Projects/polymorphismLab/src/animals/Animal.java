package animals;

public class Animal {
    private String name;
    private String favoriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favoriteFood = favouriteFood;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getFavoriteFood() {
        return favoriteFood;
    }

    protected void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    protected String explainSelf() {
        return String.format("I am %s and my favourite food is %s", this.name, this.favoriteFood);
    }
}
