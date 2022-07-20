package Homework2;

public class Dog {
    private final String species;
    private String name;

    Dog(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }
}
