package Homework2;

public class Cat {
    private final String species;
    private String name;

    Cat(String species) {
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
