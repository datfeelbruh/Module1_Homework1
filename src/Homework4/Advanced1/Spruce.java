package Homework4.Advanced1;

public class Spruce extends Tree {
    @Override
    public void smell() {
        System.out.println("Ель : умеет пахнуть.");
    }

    @Override
    public void hasCones() {System.out.println("Ель : имеет шишки.");}
}
