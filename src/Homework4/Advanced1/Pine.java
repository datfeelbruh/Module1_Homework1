package Homework4.Advanced1;

public class Pine extends Tree {
    @Override
    public void smell() {
        System.out.println("Сосна : умеет пахнуть");
    }
    @Override
    public void hasCones() {System.out.println("Сосна : имеет шишки.");}
}
