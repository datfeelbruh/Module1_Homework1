package Homework4.Expert1;

public class Human {
    private int age;
    private String name;
    private double weight;

    private void setAge(int age) {
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    public void info() {
        System.out.println(name + " - " + "возраст " + age + ", " + "вес " + weight);
    }

    public static HumanBuilder builder() {
        return new HumanBuilder(new Human());
    }

    public static class HumanBuilder {
        private final Human human;
        private HumanBuilder(Human human) {
            this.human = human;
        }

        public HumanBuilder name(String name) {
            human.setName(name);
            return this;
        }

        public HumanBuilder age(int age) {
            human.setAge(age);
            return this;
        }

        public HumanBuilder weight(double weight) {
            human.setWeight(weight);
            return this;
        }

        public Human build() {
            return human;
        }
    }
}
