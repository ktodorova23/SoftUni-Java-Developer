public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if (!(flourType.equals("White") || flourType.equals("Wholegrain"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!(bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double flourTypeModifier = 0;
        double bakingTechniqueModifier = 0;

        switch (this.getFlourType()) {
            case "White":
                flourTypeModifier = 1.5;
                break;
            case "Wholegrain":
                flourTypeModifier = 1.0;
                break;
        }

        switch (this.getBakingTechnique()) {
            case "Crispy":
                bakingTechniqueModifier = 0.9;
                break;
            case "Chewy":
                bakingTechniqueModifier = 1.1;
                break;
            case "Homemade":
                bakingTechniqueModifier = 1.0;
                break;
        }

        return (2 * this.getWeight()) * flourTypeModifier * bakingTechniqueModifier;
    }
}
